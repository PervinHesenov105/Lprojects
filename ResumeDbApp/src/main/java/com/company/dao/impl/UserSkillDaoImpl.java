/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import static com.company.dao.inter.AbstractDao.connect;
import com.company.dao.inter.UserSkillDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Leyli
 */
public class UserSkillDaoImpl implements UserSkillDaoInter{
    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> userSkills=new ArrayList();
try(Connection conn=connect()){
 
PreparedStatement statement = conn.prepareStatement("SELECT user.*, us.skill_id,us.user_id, skill.name skill_name,us.power\n" +
"from resume.user left join resume.user_skill us\n" +
"on user.id=us.user_id\n" +
"left join resume.skill on skill.id=us.skill_id where user_id=?");
statement.setInt(1, id);
statement.execute();
ResultSet result = statement.getResultSet();
 
while (result.next()){
    UserSkill u=getUserSkill(result);
    userSkills.add(u);
         }
}catch(Exception ex){
    ex.printStackTrace();
}
   return userSkills; 
    }

    @Override
     public UserSkill getUserSkill(ResultSet result) throws Exception{
    int id=result.getInt("id");
    int user_id=result.getInt("user_id");
    int skill_id=result.getInt("skill_id");
    int power=result.getInt("power");
    String skill_name=result.getString("skill_name");
    
    return new UserSkill(id, user_id, skill_id, power, new User(id), new Skill(skill_id,skill_name));
    }

  
}
