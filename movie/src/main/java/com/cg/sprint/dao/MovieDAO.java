package com.cg.sprint.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.dto.Movie;
public interface MovieDAO extends JpaRepository<Movie,Integer>
{
    public Optional<Movie> findMovieByMovieNameAndLanguage(String movieName,String language);
}
