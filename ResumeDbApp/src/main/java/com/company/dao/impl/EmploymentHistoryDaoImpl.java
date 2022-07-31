/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import static com.company.dao.inter.AbstractDao.connect;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leyli
 */
public class EmploymentHistoryDaoImpl implements EmploymentHistoryDaoInter{

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id) {
        List<EmploymentHistory> employmentHistory=new ArrayList();
try(Connection conn=connect()){
 
PreparedStatement statement = conn.prepareStatement("SELECT * from employmenthistory where user_id=?");
statement.setInt(1, id);
statement.execute();
ResultSet result = statement.getResultSet();
 
while (result.next()){
    EmploymentHistory u=getEmploymentHistory(result);
    employmentHistory.add(u);
         }
}catch(Exception ex){
    ex.printStackTrace();
}
   return employmentHistory; 
    }

    @Override
     public EmploymentHistory getEmploymentHistory(ResultSet result) throws Exception{
    int id=result.getInt("id");
    String header=result.getString("header");
    Date beginDate=result.getDate("beginDate");
    Date endDate=result.getDate("endDate");
    String jobDescription=result.getString("jobDescription");
    int user_id=result.getInt("user_id");
   
    return new EmploymentHistory(id, header, beginDate, endDate, jobDescription, user_id, new User(user_id));
    }
    
}
