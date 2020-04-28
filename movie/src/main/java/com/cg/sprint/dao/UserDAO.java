package com.cg.sprint.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.dto.User;
public interface UserDAO  extends JpaRepository<User,String>
{

}
