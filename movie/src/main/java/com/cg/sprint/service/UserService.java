package com.cg.sprint.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint.dao.UserDAO;
import com.cg.sprint.dto.User;
@Service
public class UserService 
{
    @Autowired 
    UserDAO userDao;
    public void setUserDao(UserDAO userDAO) { this.userDao=userDao; }
    
    @Transactional(readOnly=true)
    public Optional<User> getUser(String userId)
    {
    	return userDao.findById(userId);
    }
    
    @Transactional(readOnly=true)
    public List<User> getUsers()
    {
    	return userDao.findAll();
    }
    
    @Transactional
    public User insertUser(User user)
    {
    	 return userDao.save(user);
    }
    
    /*@Transactional
    public void updateUser(User user)
    {
    	 userDao.save(user);
    }*/
    
    @Transactional
    public void deleteUser(String userId)
    {
    	 userDao.deleteById(userId);
    }
}
