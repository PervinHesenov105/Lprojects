/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leyli
 */
public abstract class AbstractDao {
    public static Connection connect(){
        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/resume", "leyli", "1234");
        } finally{
        return conn;
    }
    }
}
