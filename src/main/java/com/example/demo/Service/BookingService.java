package com.example.demo.Service;

import com.example.demo.Dto.BookingDto;
import com.example.demo.Entity.Booking;
import com.example.demo.Entity.Show;
import com.example.demo.Repository.BookingRepository;
import com.example.demo.Repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ShowRepository showRepository;


    public BookingService(
            BookingRepository bookingRepository,
            ShowRepository showRepository) {

        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
    }


    // CREATE
    public Booking createBooking(BookingDto dto) {

        Booking booking = new Booking();

        booking.setUserId(dto.getUserId());
        booking.setBookingDate(dto.getBookingDate());
        booking.setNumberOfTickets(dto.getNumberOfTickets());
        booking.setSeatNumbers(dto.getSeatNumbers());
        booking.setTotalAmount(dto.getTotalAmount());

        Show show = showRepository.findById(dto.getShowId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Show not found with id: " + dto.getShowId()
                        )
                );

        booking.setShow(show);

        return bookingRepository.save(booking);
    }


    // UPDATE
    public Booking updateBooking(BookingDto bookingDto, Long id) {

        Booking existBooking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found with id: " + id
                        )
                );

        existBooking.setBookingDate(bookingDto.getBookingDate());
        existBooking.setNumberOfTickets(bookingDto.getNumberOfTickets());
        existBooking.setSeatNumbers(bookingDto.getSeatNumbers());
        existBooking.setTotalAmount(bookingDto.getTotalAmount());

        Show show = showRepository.findById(bookingDto.getShowId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "Show not found with id: "
                                        + bookingDto.getShowId()
                        )
                );

        existBooking.setShow(show);

        return bookingRepository.save(existBooking);
    }


    // DELETE
    public void deleteById(Long id) {

        Booking existBooking = bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found with id: " + id
                        )
                );

        bookingRepository.delete(existBooking);
    }


    // GET ALL
    public List<Booking> getAllBooking() {

        return bookingRepository.findAll();
    }


    // GET BY ID
    public Booking getBookingById(Long id) {

        return bookingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Booking not found with id: " + id
                        )
                );
    }
}