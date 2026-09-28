package com.example.demo.Repository;

import com.example.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
