/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.company.dao.inter;

import com.mycompany.entity.Skill;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Leyli
 */
public interface SkillDaoInter {
    public List<Skill> getAllSkillById(int id);
    public Skill getSkill(ResultSet result)throws Exception;
}
