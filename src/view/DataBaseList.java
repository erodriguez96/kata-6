/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Person;

/**
 *
 * @author eduardo
 */
public class DataBaseList {

    public static List<Person> read() throws ClassNotFoundException, SQLException {
        List<Person> listPerson = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:kata.sdb");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from PEOPLE;");
        while (resultSet.next()) {
            Integer id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            Character gender = resultSet.getString(3).charAt(0);
            String birthDate = resultSet.getString(4);
            Float weight = resultSet.getFloat(5);
            String mail = resultSet.getString(6);
            listPerson.add(new Person(id, name, gender, birthDate, weight, mail));
        }
        return listPerson;
    }
    
}
