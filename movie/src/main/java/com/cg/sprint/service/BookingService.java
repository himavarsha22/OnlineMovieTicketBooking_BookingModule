package com.cg.sprint.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint.dao.BookingDAO;
import com.cg.sprint.dto.Booking;
@Service
public class BookingService 
{
    @Autowired
    BookingDAO bDao;
    public void setbDao(BookingDAO bDao) { this.bDao=bDao; }
    
    @Transactional(readOnly=true)
    public Optional<Booking> getBooking(int bookingId)
    {
    	return bDao.findById(bookingId);
    }
    
    @Transactional(readOnly=true)
    public List<Booking> getBookings()
    {
    	return bDao.findAll();
    }
    
    @Transactional()
    public void insertBooking(Booking booking)
    {
    	bDao.save(booking);
    }
    
    @Transactional
    public void deleteBooking(int bookingId)
    {
    	bDao.deleteById(bookingId);
    }
}
