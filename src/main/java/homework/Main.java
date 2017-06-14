package homework;

import homework.model.entities.*;
import homework.mySqlDaoImpl.*;

/**
 * Created by Aleksandr on 12.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("================================== \n ---Working with table Companies--- \n================================== ");
        CompanyDAOImpl companyDAO = new CompanyDAOImpl();
        System.out.println("Read all companies");
        companyDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("=======================================");

        System.out.println("Adding company");
        Company company = new Company("Lais");
        companyDAO.create(company);
        companyDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("=======================================");

        System.out.println("Updating  company");
        Company companyUpdate = new Company("LaisUpdate");
        companyDAO.update(4, companyUpdate);
        companyDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("=======================================");

        System.out.println("Deleting company");
        companyDAO.delete(4);
        companyDAO.read().stream().forEach(x -> System.out.println(x));

        System.out.println("================================== \n ---Working with table Customers--- \n================================== ");
        System.out.println("Read all customer");
        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
        customerDAO.read().stream().forEach(x -> System.out.println(x));


        System.out.println("Adding customer");
        Customer customer = new Customer("Cola");
        customerDAO.create(customer);
        customerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Updating customer");
        Customer customerUpdate = new Customer("ColaUpdate");
        customerDAO.update(4, customerUpdate);
        customerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Deleting customer");
        customerDAO.delete(4);
        customerDAO.read().stream().forEach(x -> System.out.println(x));

        System.out.println("================================== \n ---Working with table Developers--- \n================================== ");
        System.out.println("Read all Developers");
        DeveloperDAOImpl developerDAO = new DeveloperDAOImpl();
        developerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Adding developer");
        Developer developer = new Developer("Antonio", 2, 5555);
        developerDAO.create(developer);
        developerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Updating developer");
        Developer developerUpdate = new Developer("Antonio2", 2, 6666);
        developerDAO.update(10, developerUpdate);
        developerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Deleting developer");
        developerDAO.delete(10);
        developerDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");


        System.out.println("================================== \n ---Working with table Projects--- \n================================== ");
        System.out.println("Read all Projects");
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();
        projectDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Adding project");
        Project project = new Project("SocialNetwork", 2, 2, 800000);
        projectDAO.create(project);
        projectDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Updating project");
        Project projectUpdate = new Project("SocialNetwork2", 3, 2, 900000);
        projectDAO.update(10, projectUpdate);
        projectDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Deleting project");
        projectDAO.delete(10);
        projectDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("================================== \n ---Working with table Skills--- \n================================== ");
        System.out.println("Read all Skills");
        SkillDAOImpl skillDAO = new SkillDAOImpl();
        skillDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Adding skill");
        Skill skill = new Skill("Python");
        skillDAO.create(skill);
        skillDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Updating skill");
        Skill skillUpdate = new Skill("Ruby");
        skillDAO.update(6, skillUpdate);
        skillDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");

        System.out.println("Deleting skill");
        skillDAO.delete(6);
        skillDAO.read().stream().forEach(x -> System.out.println(x));
        System.out.println("====================================");
    }
}
