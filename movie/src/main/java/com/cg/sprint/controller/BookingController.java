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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.dto.Booking;
import com.cg.sprint.service.BookingService;
@RestController
public class BookingController 
{
    @Autowired BookingService bookingService;
    public void setBookingService(BookingService bookingService)
    {
    	this.bookingService=bookingService;
    }
    
    @GetMapping(value="/getBooking/{bookingId}",produces="application/json")
    public ResponseEntity<Optional<Booking>> getBookingDetails(@PathVariable int bookingId)
    {
    	Optional<Booking> booking = bookingService.getBooking(bookingId);
    	if(booking.isPresent())
    		return new ResponseEntity<Optional<Booking>>(booking,HttpStatus.OK);
    	return new ResponseEntity<Optional<Booking>>(booking,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value="/getBookings",produces="application/json")
    public List<Booking> getBookingsDetails()
    {
    	return bookingService.getBookings();
    }
    
    @PostMapping(value="/addBooking",consumes="application/json")
    public ResponseEntity<String> addBooking(@RequestBody Booking booking)
    {
    	try
    	{
    		bookingService.insertBooking(booking);
    		return new ResponseEntity<String>("Booking Details Added",HttpStatus.OK);
    	}
    	catch(Exception ex)
    	{
    		return new ResponseEntity<String>("Booking Details Cannot be Added",HttpStatus.BAD_REQUEST);
    	}
    }
    
    @DeleteMapping("/deleteBooking/{bookingId}")
    public ResponseEntity<String> deleteBooking(int bookingId)
    {
    	try
    	{
    		bookingService.deleteBooking(bookingId);
    		return new ResponseEntity<String>("Booking Details Deleted",HttpStatus.OK);
    	}
    	catch(Exception ex)
    	{
    		return new ResponseEntity<String>("Booking Details Cannot be Deleted",HttpStatus.BAD_REQUEST);
    	}
    }
}
