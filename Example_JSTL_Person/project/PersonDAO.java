package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    private Connection connection = null;
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "student";
        String password = "student";
        connection = DriverManager.getConnection(url, username, password);
        return connection;
    } // end method getConnection()

    
    public void closeConnection() throws SQLException {
        if (connection != null)
            connection.close();
    } // end method closeConnection()


    public void insertPerson(Person newPerson) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("INSERT INTO person(person_id, first_name, last_name, email_address, create_date) VALUES(?, ?, ?, ?, sysdate)");
        
        ps.setInt(1, newPerson.getPersonId());
        ps.setString(2, newPerson.getFirstName());
        ps.setString(3, newPerson.getLastName());
        ps.setString(4, newPerson.getEmailAddress());
        ps.executeUpdate();
        ps.close();
        closeConnection();
    } // end method insertPerson()
    
    
    public void updatePerson(Person person) throws SQLException, ClassNotFoundException {
        
        Statement statement = getConnection().createStatement();
        String update = "UPDATE person SET first_name = '" + person.getFirstName() +
                        "', last_name = '" + person.getLastName() +
                        "', email_address = '" + person.getEmailAddress() +
                        "' WHERE person_id = " + person.getPersonId();
        statement.executeQuery(update);
        
        statement.close();
        closeConnection();
    } // end method insertPerson()
    

    public List<Person> selectAll() throws SQLException, ClassNotFoundException {
        List<Person> personsList = new ArrayList();
        
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person ORDER BY person_id");
        Person person = null;
        while (resultSet.next()) {
            person = new Person();
            person.setPersonId(resultSet.getInt("person_id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setEmailAddress(resultSet.getString("email_address"));
            person.setDateCreation(resultSet.getString("create_date"));
            personsList.add(person);
        } // end while

        resultSet.close();
        statement.close();
        closeConnection();
        return personsList;
    } // end method selectAll()
    
    
    public Person selectById(int id) throws SQLException, ClassNotFoundException {
        
        Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM person WHERE person_id = " + id);
        Person person = null;
        while (resultSet.next()) {
            person = new Person();
            person.setPersonId(resultSet.getInt("person_id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setEmailAddress(resultSet.getString("email_address"));
            person.setDateCreation(resultSet.getString("create_date"));
        } // end while

        resultSet.close();
        statement.close();
        closeConnection();
        return person;
    } // end method selectAll()


    public void delete(int id) throws SQLException, ClassNotFoundException {
        Statement statement = getConnection().createStatement();
        statement.executeUpdate("DELETE FROM person WHERE person_id = " + id);

        statement.close();
        closeConnection();
    } // end method delete()

} // end class PersonDAO