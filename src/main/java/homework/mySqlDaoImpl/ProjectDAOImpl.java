package homework.mySqlDaoImpl;

import homework.model.dao.ProjectDAO;
import homework.model.entities.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ProjectDAOImpl implements ProjectDAO<Project> {

    private String URL = "jdbc:mysql://localhost:3306/initdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String USER = "root";
    private String PASSWORD = "root";

    public ProjectDAOImpl() {
    }

    public ProjectDAOImpl(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void create(Project project) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projects (name, company_Id, customer_id, cost ) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setInt(2, project.getCompanyId());
            preparedStatement.setInt(3, project.getCustomerId());
            preparedStatement.setInt(4, project.getCost());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Project read(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                Project project = new Project();
                if (resultSet.next()) {
                    project.setId(resultSet.getInt("id"));
                    project.setName(resultSet.getString("name"));
                    project.setCompanyId(resultSet.getInt("company_id"));
                    project.setCustomerId(resultSet.getInt("customer_id"));
                    project.setCost(resultSet.getInt("cost"));
                    return project;
                } else
                    return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Project> read() {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projects ")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                ArrayList<Project> projects = new ArrayList<>();

                while (resultSet.next()) {
                    Project project = new Project();
                    project.setId(resultSet.getInt("id"));
                    project.setName(resultSet.getString("name"));
                    project.setCompanyId(resultSet.getInt("company_id"));
                    project.setCustomerId(resultSet.getInt("customer_id"));
                    project.setCost(resultSet.getInt("cost"));
                    projects.add(project);
                }
                return projects;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Project project) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE projects SET name = ?, company_id = ?, customer_id = ?, cost = ? WHERE id = ?")) {

            preparedStatement.setString(1, project.getName());
            preparedStatement.setInt(2, project.getCompanyId());
            preparedStatement.setInt(3, project.getCustomerId());
            preparedStatement.setInt(4, project.getCost());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM projects WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
