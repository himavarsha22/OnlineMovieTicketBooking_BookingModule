package com.cg.sprint.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.sprint.dao.ShowDAO;
import com.cg.sprint.dto.Show;
@Service
public class ShowService 
{
     @Autowired
     ShowDAO sDao;
     public void setsDao(ShowDAO sDao) { this.sDao=sDao;}
     
     @Transactional(readOnly=true)
     public Optional<Show> getShow(int showId)
     {
    	  return sDao.findById(showId);
     }
     
     @Transactional(readOnly=true)
     public List<Show> getShows()
     {
    	 return sDao.findAll();
     }
     
     @Transactional
     public void insertShow(Show show)
     {
    	  sDao.save(show);
     }
     
     @Transactional
     public void deleteShow(int showId)
     {
    	  sDao.deleteById(showId);
     }
}
