package com.solvd.dice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ConnectionPool {

    private volatile static ConnectionPool instance = null;

    private final List<Connection> availableConnections;

    private ConnectionPool(Integer quantityConnection) {
        this.availableConnections = new ArrayList<>();
        IntStream.range(0, quantityConnection)
                .boxed()
                .forEach(x -> {
                    this.availableConnections.add(new Connection());
                });
    }

    public static ConnectionPool getInstance(Integer quantityConnection) {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool(quantityConnection);
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        synchronized (this.availableConnections) {
            while (this.availableConnections.isEmpty()) {
                try {
                    availableConnections.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return availableConnections.remove(0);
    }

    public void releaseConnection(Connection connection) {
        synchronized (this.availableConnections) {
            this.availableConnections.add(connection);
            this.availableConnections.notifyAll();
        }
    }
}
