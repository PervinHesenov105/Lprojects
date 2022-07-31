/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.mycompany.entity.Country;
import com.mycompany.entity.Nationality;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Leyli
 */
public interface NationalityDaoInter {
    public List<Nationality> getAllNationalityById(int id);
    public Nationality getNationality(ResultSet result)throws Exception;
    public List<Nationality> getAll();
}
