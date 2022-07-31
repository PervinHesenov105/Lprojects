/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.mycompany.entity.UserSkill;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Leyli
 */
public interface UserSkillDaoInter {
    public List<UserSkill> getAllSkillByUserId(int id);
    public UserSkill getUserSkill(ResultSet result)throws Exception;
}
