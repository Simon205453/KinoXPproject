package com.example.kinoxpproject.ticket.service;

import com.example.kinoxpproject.movie.dto.MovieDto;
import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.ticket.dto.TicketDto;
import com.example.kinoxpproject.ticket.model.Ticket;
import com.example.kinoxpproject.ticket.repository.TicketRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class TicketServiceTest {
    @InjectMocks
    private TicketService underTest;
    @Mock
    private TicketRepository ticketRepository;
    private AutoCloseable autoCloseable;
    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }
    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    /*
    @Test
    void findAllTickets() {
        underTest.findAllTickets();
        verify(ticketRepository).findAll();
    }

     */

    /*

    @Test
    void findTicketById() {

        Long id = 10L;
        given(ticketRepository.existsById(id)).willReturn(true);

        underTest.deleteTicket(id);

        verify(ticketRepository).deleteById(id);



    }

     */

    @Test
    void createTicket() {
   

    }

    @Test
    void updateTicket() {
    }

    @Test
    void deleteTicket() {

    }

    @Test
    void findAllTicketsForMovieID() {

    }
}