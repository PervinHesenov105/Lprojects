/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.entity;

/**
 *
 * @author Leyli
 */
public class UserSkill {
    private int id;
    private int user_id;
    private int skill_id;
    private int power;
    private User user;
    private Skill skill;

    public UserSkill(int id, int user_id, int skill_id, int power, User user, Skill skill) {
        this.id = id;
        this.user_id = user_id;
        this.skill_id = skill_id;
        this.power = power;
        this.user = user;
        this.skill = skill;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(int skill_id) {
        this.skill_id = skill_id;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "UserSkill{" + "id=" + id + ", user_id=" + user_id + ", skill_id=" + skill_id + ", power=" + power + '}';
    }
    
    
}
