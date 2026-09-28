package com.example.demo.Repository;

import com.example.demo.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
