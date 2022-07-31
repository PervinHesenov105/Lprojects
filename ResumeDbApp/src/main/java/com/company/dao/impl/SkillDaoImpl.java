/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.impl;

import static com.company.dao.inter.AbstractDao.connect;
import com.company.dao.inter.SkillDaoInter;
import com.mycompany.entity.Skill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leyli
 */
public class SkillDaoImpl implements SkillDaoInter{

   
    @Override
    public List<Skill> getAllSkillById(int id) {
        List<Skill> skills=new ArrayList();
try(Connection conn=connect()){
 
PreparedStatement statement = conn.prepareStatement("SELECT * from skill where id=?");
statement.setInt(1, id);
statement.execute();
ResultSet result = statement.getResultSet();
 
while (result.next()){
    Skill u=getSkill(result);
    skills.add(u);
         }
}catch(Exception ex){
    ex.printStackTrace();
}
   return skills; 
    }

    @Override
     public Skill getSkill(ResultSet result) throws Exception{
    int id=result.getInt("id");
    String name=result.getString("name");
    return new Skill(id, name);
    }
}
