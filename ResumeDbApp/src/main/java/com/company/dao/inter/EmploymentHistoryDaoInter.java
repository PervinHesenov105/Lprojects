/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.mycompany.entity.EmploymentHistory;
import java.sql.ResultSet;
import java.util.List;


public interface EmploymentHistoryDaoInter {
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id);
    public EmploymentHistory getEmploymentHistory(ResultSet result)throws Exception;      
}
