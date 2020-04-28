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

import com.cg.sprint.dto.Show;
import com.cg.sprint.service.ShowService;
@RestController
public class ShowController 
{
	@Autowired ShowService showService;
    public void setShowService(ShowService showService)
    {
    	this.showService=showService;
    }
    
    @GetMapping(value="/getShow/{showId}",produces="application/json")
    public ResponseEntity<Optional<Show>> getShowDetails(@PathVariable int showId)
    {
    	Optional<Show> show = showService.getShow(showId);
    	if(show.isPresent())
    		return new ResponseEntity<Optional<Show>>(show,HttpStatus.OK);
    	return new ResponseEntity<Optional<Show>>(show,HttpStatus.NOT_FOUND);
    }
    
    @GetMapping(value="/getShows",produces="application/json")
    public List<Show> getShowsDetails()
    {
    	return showService.getShows();
    }
    
    @PostMapping(value="/addShow",consumes="application/json")
    public ResponseEntity<String> addShow(@RequestBody() Show show)
    {
    	 try
    	 {
    		 showService.insertShow(show);
    		 return new ResponseEntity<String>("Show Details Added",HttpStatus.OK);
    	 }
    	 catch(Exception ex)
    	 {
    		 return new ResponseEntity<String>("Show Details Cannot be Added",HttpStatus.BAD_REQUEST);
    	 }
    }
    
    @DeleteMapping("/deleteShow/{showId}")
    public ResponseEntity<String> deleteShow(int showId)
    {
    	 try
    	 {
    		 showService.deleteShow(showId);
    		 return new ResponseEntity<String>("Show Details Deleted",HttpStatus.OK);
    	 }
    	 catch(Exception ex)
    	 {
    		 return new ResponseEntity<String>("Show Details Cannot be Deleteed",HttpStatus.BAD_REQUEST);
    	 }
    }

}