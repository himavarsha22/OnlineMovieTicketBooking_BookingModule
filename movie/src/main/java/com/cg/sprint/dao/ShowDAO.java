package com.cg.sprint.dao;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.dto.Movie;
import com.cg.sprint.dto.Show;
public interface ShowDAO extends JpaRepository<Show,Integer>
{
    public Optional<Show> findByMovie(Movie movie);
}
