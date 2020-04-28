package com.cg.sprint.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.dto.User;
import com.cg.sprint.service.UserService;
@RestController
public class UserController 
{
	  @Autowired
	  UserService userService;
	  public void setUserService(UserService userService) { this.userService = userService; }
	
      @GetMapping(value="/getUser/{userId}",produces="application/json")
      public ResponseEntity<Optional<User>> getUserDetails(@PathVariable String userId)
      {
    	  Optional<User> user =  userService.getUser(userId);
    	  if(user.isPresent())
    		  return new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
    	  return new ResponseEntity<Optional<User>>(user,HttpStatus.NOT_FOUND);
      }
      
      @GetMapping(value="/getUsers",produces="application/json")
      public List<User> getUsersDetails()
      {
    	  return userService.getUsers();
      }
      
      /* PostMapping is used for both save/update */
      @PostMapping(value="/addUser",consumes="application/json")
      public ResponseEntity<String> addUserDetails(@RequestBody() User user)
      {
    	  try
    	  {
    	      userService.insertUser(user);
    	      return new ResponseEntity<String>("User Added",HttpStatus.OK);
    	  }
    	  catch(Exception ex)
    	  {
    	    	return new ResponseEntity<String>(ex.getMessage()+" Insertion Failed",HttpStatus.BAD_REQUEST);
    	  } 
      }
      
      /*@PutMapping(value="/updateUser",consumes="application/json")
      public void updateUserDetails(@RequestBody() User user)
      {
    	    userService.updateUser(user);
      }*/
      
      @DeleteMapping("/deleteUser/{userId}")
      public ResponseEntity<String> deleteUserDetails(@PathVariable String userId)
      {
    	  try
    	  {
    	    userService.deleteUser(userId);
    	    return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
    	  }
    	  catch(Exception ex)
    	  {
    		  return new ResponseEntity<String>("Deletion Failed",HttpStatus.BAD_REQUEST);
    	  }
      }
}
