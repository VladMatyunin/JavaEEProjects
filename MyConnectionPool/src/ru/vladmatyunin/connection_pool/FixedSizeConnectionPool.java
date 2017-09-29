package ru.vladmatyunin.connection_pool;

import com.sun.istack.internal.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by vladislav on 30.09.17.
 */
public class FixedSizeConnectionPool implements ConnectionPool<SimpleConnectionProxy> {
    private BlockingDeque<Connection> AvailableConnectionStack;
    private int capacity;
    private String connectionString;

    private void Init() {
        try {
            for (int i = 0; i < capacity; i++) {
                Connection connection = DriverManager.getConnection(connectionString);
                AvailableConnectionStack.push(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FixedSizeConnectionPool(int capacity, String connectionString) {
        this.capacity = capacity;
        this.connectionString = connectionString;
        this.AvailableConnectionStack = new LinkedBlockingDeque<>();
        Init();
    }
    @Nullable
    @Override
    public synchronized Connection getConnection() {
        if (AvailableConnectionStack.size()>0)
            return new SimpleConnectionProxy(this, AvailableConnectionStack.pop());
        else try {
            return new SimpleConnectionProxy(this, AvailableConnectionStack.take());
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    public synchronized int getAvailableConnectionsCount() {
        return AvailableConnectionStack.size();
    }

    @Override
    public void initializeDefaultState(Connection connection) {

    }

    @Override
    public synchronized void dispose() throws SQLException {
        for (Connection connection : AvailableConnectionStack) {
            connection.close();
        }
    }

    void connectionBack(SimpleConnectionProxy proxy) {
        AvailableConnectionStack.push(proxy);
    }
}
