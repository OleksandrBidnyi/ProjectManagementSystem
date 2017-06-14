package homework.mySqlDaoImpl;

import homework.model.dao.DeveloperDAO;
import homework.model.entities.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DeveloperDAOImpl implements DeveloperDAO<Developer> {


    private String URL = "jdbc:mysql://localhost:3306/initdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String USER = "root";
    private String PASSWORD = "root";

    public DeveloperDAOImpl() {
    }

    public DeveloperDAOImpl(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void create(Developer developer) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO developers (name, company_id, salary) VALUES (?, ?, ?)")) {

            preparedStatement.setString(1, developer.getName());
            preparedStatement.setInt(2, developer.getCompanyId());
            preparedStatement.setInt(3, developer.getSalary());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public Developer read(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM developers WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                Developer developer = new Developer();
                if (resultSet.next()) {
                    developer.setId(resultSet.getInt("id"));
                    developer.setName(resultSet.getString("name"));
                    developer.setCompanyId(resultSet.getInt("company_id"));
                    developer.setSalary(resultSet.getInt("salary"));
                    return developer;
                } else
                    return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Developer> read() {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM developers ")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                ArrayList<Developer> developers = new ArrayList<>();

                while (resultSet.next()) {
                    Developer developer = new Developer();
                    developer.setId(resultSet.getInt("id"));
                    developer.setName(resultSet.getString("name"));
                    developer.setCompanyId(resultSet.getInt("company_id"));
                    developer.setSalary(resultSet.getInt("salary"));
                    developers.add(developer);
                }
                return developers;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Developer developer) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE developers SET name = ?, company_id = ?, salary = ? WHERE id = ?")) {

            preparedStatement.setString(1, developer.getName());
            preparedStatement.setInt(2, developer.getCompanyId());
            preparedStatement.setInt(3, developer.getSalary());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM developers WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
