package com.example.demo.Repository;


import com.example.demo.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show,Long> {

    //Show findById(String Id);
}
