package homework.mySqlDaoImpl;

import homework.model.entities.Skill;
import homework.model.dao.SkillDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class SkillDAOImpl implements SkillDAO<Skill> {

    private String URL = "jdbc:mysql://localhost:3306/initdb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private String USER = "root";
    private String PASSWORD = "root";

    public SkillDAOImpl() {
    }

    public SkillDAOImpl(String URL, String USER, String PASSWORD) {
        this.URL = URL;
        this.USER = USER;
        this.PASSWORD = PASSWORD;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void create(Skill skill) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO skills (skill) VALUES (?)")) {

            preparedStatement.setString(1,skill.getSkill());
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Skill read(int id) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SKILLS WHERE id = ?")) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                Skill skill = new Skill();
                if (resultSet.next()) {
                    skill.setId(resultSet.getInt("id"));
                    skill.setSkill(resultSet.getString("skill"));
                    return skill;
                } else
                    return null;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Collection<Skill> read() {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SKILLS ")) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                ArrayList<Skill> skills = new ArrayList<>();

                while (resultSet.next()) {
                    Skill skill = new Skill();
                    skill.setId(resultSet.getInt("id"));
                    skill.setSkill(resultSet.getString("skill"));
                    skills.add(skill);
                }
                return skills;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void update(int id, Skill skill) {

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("UPDATE skills SET skill = ? WHERE id = ?")) {

            preparedStatement.setString(1, skill.getSkill());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM SKILLS WHERE id = ?")) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
