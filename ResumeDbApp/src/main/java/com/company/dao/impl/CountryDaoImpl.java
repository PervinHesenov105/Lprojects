/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import static com.company.dao.inter.AbstractDao.connect;
import com.company.dao.inter.CountryDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
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
public class CountryDaoImpl implements CountryDaoInter{

    @Override
    public List<Country> getAllCountryById(int id) { 
List<Country> countries=new ArrayList();
try(Connection conn=connect()){
 
PreparedStatement statement = conn.prepareStatement("SELECT * from country where id=?");
statement.setInt(1, id);
statement.execute();
ResultSet result = statement.getResultSet();
 
while (result.next()){
    Country u=getCountry(result);
    countries.add(u);
         }
}catch(Exception ex){
    ex.printStackTrace();
}
   return countries;
    }

    @Override
    public Country getCountry(ResultSet result) throws Exception {
    int id=result.getInt("id");
    String country=result.getString("country");
    
    
    return new Country( id, country);
    }
    
    @Override
    public List<Country> getAll() {
        List<Country> list = new ArrayList<>();
        Connection conn;
        try {
            conn = connect();

            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM country");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                Country contry = getCountry(rs);
                list.add(contry);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
}
