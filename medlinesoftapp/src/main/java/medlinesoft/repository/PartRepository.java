package medlinesoft.repository;


import medlinesoft.entity.Part;
import medlinesoft.viewmodels.PartViewModel;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import static medlinesoft.utils.Constants.*;

/**
 * DAO class to access database entities of type Part
 *
 * @see Part
 */
public class PartRepository {

    public PartRepository(ServletContext servletContext) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS);
        Properties properties = new Properties();
        try {
            properties.load(servletContext.getResourceAsStream(PATH_TO_DB_PROPERTIES));
            connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(PROPERTIES_LOAD_ERROR_MESSAGE);
            connection = DriverManager.getConnection(DEFAULT_DB_URL, DEFAULT_DB_USER, DEFAULT_DB_PASSWORD);
        }

    }

    private Connection connection;

    /**
     * get all Part objects using filter from view model
     *
     * @param viewModel - filters applied by user
     * @return - all satisfied objects
     * @throws SQLException
     */
    public List<Part> getAll(PartViewModel viewModel) throws SQLException {
        String order = viewModel.isAsc() ? "asc" : "desc";
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM part where NAME ILIKE ? AND NUMBER ILIKE ? AND vendor " +
                "ILIKE ? AND qty<=? AND shipped BETWEEN ? AND ? AND received BETWEEN ? AND ? ORDER BY " + viewModel.getOrderByParameter() + " " + order + ";");

        statement.setString(1, "%" + viewModel.getName() + "%");
        statement.setString(2, "%" + viewModel.getNumber() + "%");
        statement.setString(3, "%" + viewModel.getVendor() + "%");
        statement.setInt(4, viewModel.getQty());

        statement.setDate(5, new Date(viewModel.getShippedAfter().getTime()));
        statement.setDate(6, new Date(viewModel.getShippedBefore().getTime()));
        statement.setDate(7, new Date(viewModel.getReceivedAfter().getTime()));
        statement.setDate(8, new Date(viewModel.getReceivedBefore().getTime()));

        ResultSet resultSet = statement.executeQuery();
        List<Part> partList = new ArrayList<Part>();
        while (resultSet.next()) {
            Part part = new Part();
            part.setName(resultSet.getString(1));
            part.setNumber(resultSet.getString(2));
            part.setVendor(resultSet.getString(3));
            part.setQty(resultSet.getInt(4));
            part.setShipped(resultSet.getDate(5));
            part.setReceived(resultSet.getDate(6));
            partList.add(part);
            resultSet.next();
        }
        return partList;
    }

    public void dispose() throws SQLException {
        connection.close();
    }
}
