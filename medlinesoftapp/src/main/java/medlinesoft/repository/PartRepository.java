package medlinesoft.repository;


import medlinesoft.entity.Part;
import medlinesoft.viewmodels.PartViewModel;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by Vlad on 08/12/17.
 */
public class PartRepository {

    public PartRepository() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/medline", "postgres","sa");
    }
    private Connection connection;

    public List<Part> getAll(PartViewModel viewModel) throws SQLException {
        String order = viewModel.isAsc() ? "asc" :"desc";
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM part where NAME ILIKE ? AND NUMBER ILIKE ? AND vendor " +
                "ILIKE ? AND qty<=? AND shipped BETWEEN ? AND ? AND received BETWEEN ? AND ? ORDER BY "+viewModel.getOrderByParameter()+" "+order+";");

        statement.setString(1,"%"+viewModel.getName()+"%");
        statement.setString(2,"%"+viewModel.getNumber()+"%");
        statement.setString(3,"%"+viewModel.getVendor()+"%");
        statement.setInt(4, viewModel.getQty());
        statement.setDate(5, new Date(viewModel.getShippedAfter().getTime()));
        statement.setDate(6, new Date(viewModel.getShippedBefore().getTime()));
        statement.setDate(7, new Date(viewModel.getReceivedAfter().getTime()));
        statement.setDate(8, new Date(viewModel.getReceivedBefore().getTime()));

        ResultSet resultSet = statement.executeQuery();
        List<Part> partList = new ArrayList<Part>();
        while (resultSet.next()){
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
