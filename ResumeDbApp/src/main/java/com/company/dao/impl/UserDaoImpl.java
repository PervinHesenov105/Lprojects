/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import com.company.dao.inter.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.Nationality;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leyli
 */
public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    public void printAllUsers() {
        List<User> users = getAll();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Override
    public User getUser(ResultSet result) throws Exception {
        int id = result.getInt("id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        String phone = result.getString("phone");
        String email = result.getString("email");
        String profileDesc = result.getString("profileDescription");
        String address = result.getString("address");
        Date birthdate = result.getDate("birthdate");
        Country birthplace = new Country(result.getInt("birthplace_id"),result.getString("birthplace"));
        Nationality nationality = new  Nationality(result.getInt("nationality_id"),result.getString("nationality"));

        return new User(id, name, surname, phone, email, profileDesc, address, birthdate, birthplace, nationality);
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList();
        try ( Connection conn = connect()) {

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select user.* , country.country as birthplace,"
                    + " nationality.nationality from user left join country \n"
                    + "on user.birthplace_id=country.id left join nationality on user.nationality_id=nationality.id;");

            while (result.next()) {
                User u = getUser(result);
                users.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return users;

    }

    @Override
    public boolean updateUser(User u) {
        try ( Connection conn = connect()) {
            PreparedStatement statement = conn.prepareStatement("UPDATE User SET name=?,surname=?,"
                    + "phone=?,email=?,profileDescription=?,address=?,"
                    + "birthdate=? WHERE id=?");
            statement.setString(1, u.getName());
            statement.setString(2, u.getSurname());
            statement.setString(3, u.getPhone());
            statement.setString(4, u.getEmail());
             statement.setString(5, u.getProfileDesc());
             statement.setString(6, u.getAddress());
             statement.setDate(7, u.getBirthdate());
            statement.setInt(8, u.getId());

            return statement.execute();

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try ( Connection conn = connect()) {
            Statement statement = conn.createStatement();

            return statement.execute("delete from User WHERE id=" + id);

        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public User getById(int userId) {
        User u = null;
        try ( Connection conn = connect()) {

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select user.* , country.country as birthplace,"
                    + " nationality.nationality from user left join country \n"
                    + "on user.birthplace_id=country.id left join nationality on user.nationality_id=nationality.id where user.id=" + userId);

            while (result.next()) {
                u = getUser(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean addUser(User u) {
        try ( Connection conn = connect()) {
            PreparedStatement statement = conn.prepareStatement("insert into user(id,name,surname,phone,email,profileDescription) values(?,?,?,?,?,?)");
            statement.setInt(1, u.getId());
            statement.setString(2, u.getName());
            statement.setString(3, u.getSurname());
            statement.setString(4, u.getPhone());
            statement.setString(5, u.getEmail());
             statement.setString(6, u.getProfileDesc());
            return statement.execute();

        } catch (Exception ex) {
            return false;
        }
    }

}
