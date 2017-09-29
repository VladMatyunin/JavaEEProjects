package ru.vladmatyunin.connection_pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vladislav on 30.09.17.
 */
public interface ConnectionPool<T extends ConnectionProxy> {

    Connection getConnection();

    int getAvailableConnectionsCount();

    void initializeDefaultState(Connection connection);

    void dispose() throws SQLException;
}
