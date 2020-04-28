package com.cg.sprint.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.dto.Booking;
public interface BookingDAO extends JpaRepository<Booking,Integer>
{
    
}
