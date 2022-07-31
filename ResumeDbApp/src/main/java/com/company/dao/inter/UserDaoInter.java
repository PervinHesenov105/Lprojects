
package com.company.dao.inter;

import com.mycompany.entity.User;
import com.mycompany.entity.UserSkill;
import java.sql.ResultSet;
import java.util.List;


public interface UserDaoInter {
    public List<User> getAll();
    public boolean updateUser(User u);
    public boolean addUser(User u);
    public boolean removeUser(int id);
    public User getById(int id);
    public void printAllUsers();
    public User getUser(ResultSet result) throws Exception;
    
   
}
