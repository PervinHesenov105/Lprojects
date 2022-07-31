/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import static com.company.dao.inter.AbstractDao.connect;
import com.company.dao.inter.NationalityDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.Nationality;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leyli
 */
public class NationalityDaoImpl implements NationalityDaoInter{

    @Override
    public List<Nationality> getAllNationalityById(int id) { 
List<Nationality> nationalities=new ArrayList();
try(Connection conn=connect()){
 
PreparedStatement statement = conn.prepareStatement("SELECT * from nationality where id=?");
statement.setInt(1, id);
statement.execute();
ResultSet result = statement.getResultSet();
 
while (result.next()){
    Nationality u=getNationality(result);
    nationalities.add(u);
         }
}catch(Exception ex){
    ex.printStackTrace();
}
   return nationalities;
    }

    @Override
    public Nationality getNationality(ResultSet result) throws Exception {
    int id=result.getInt("id");
    String nationality=result.getString("nationality");
    
    
    return new Nationality(id, nationality);
    }
    
    
    @Override
    public List< Nationality > getAll() {
        List< Nationality > list = new ArrayList<>();
        Connection conn;
        try {
            conn = connect();

            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM nationality");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                Nationality nationality = getNationality(rs);
                list.add(nationality);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
