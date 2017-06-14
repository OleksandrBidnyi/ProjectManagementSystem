package homework.mySqlDaoImpl;

import homework.model.dao.CustomerDAO;
import homework.model.entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CustomerDAOImpl implements CustomerDAO<Customer> {

    private String URL = "jdbc:mysql://localhost:3306/initdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String USER = "root";
    private String PASSWORD = "root";

    public CustomerDAOImpl() {
    }

    public CustomerDAOImpl(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void create(Customer customer) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO customers (name) VALUES (?)")) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Customer read(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                Customer customer = new Customer();
                if (resultSet.next()) {
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    return customer;
                } else
                    return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Collection<Customer> read() {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers ")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                ArrayList<Customer> customers = new ArrayList<>();

                while (resultSet.next()) {
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    customers.add(customer);
                }
                return customers;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Customer customer) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE customers SET name = ? WHERE id = ?")) {

            preparedStatement.setString(1, customer.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM customers WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
