/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.mycompany.entity.Country;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Leyli
 */
public interface CountryDaoInter {
    public List<Country> getAllCountryById(int id);
    public Country getCountry(ResultSet result)throws Exception;
    public List<Country> getAll();
}
