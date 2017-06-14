package homework.mySqlDaoImpl;

import homework.model.dao.CompanyDAO;
import homework.model.entities.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class CompanyDAOImpl implements CompanyDAO<Company> {

    private String URL = "jdbc:mysql://localhost:3306/initdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String USER = "root";
    private String PASSWORD = "root";

    public CompanyDAOImpl() {
    }

    public CompanyDAOImpl(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void create(Company company) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO companies (name) VALUES (?)")) {

            preparedStatement.setString(1, company.getName());
            preparedStatement.execute();
            System.out.println("You has been added 1 company: " + company.getName());
            //System.out.println("You has been added 1 company");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Company read(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM companies WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                Company company = new Company();
                if (resultSet.next()) {
                    company.setId(resultSet.getInt("id"));
                    company.setName(resultSet.getString("name"));
                    return company;
                } else
                    return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return null;
    }

    @Override
    public Collection<Company> read() {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM companies ")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                ArrayList<Company> companies = new ArrayList<>();

                while (resultSet.next()) {
                    Company company = new Company();
                    company.setId(resultSet.getInt("id"));
                    company.setName(resultSet.getString("name"));
                    companies.add(company);
                }
                return companies;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Company company) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE companies SET name = ? WHERE id = ?")) {

            preparedStatement.setString(1, company.getName());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(int id) {
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM companies WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
