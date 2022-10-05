package com.example.kinoxpproject;

import com.example.kinoxpproject.movie.model.Movie;
import com.example.kinoxpproject.movie.model.MovieGenre;
import com.example.kinoxpproject.movie.repository.MovieRepository;
import com.example.kinoxpproject.reservation.model.Reservation;
import com.example.kinoxpproject.reservation.repository.ReservationRepository;
import com.example.kinoxpproject.theater.model.Theater;
import com.example.kinoxpproject.theater.repository.TheaterRepository;
import com.example.kinoxpproject.ticket.model.Ticket;
import com.example.kinoxpproject.ticket.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class KinoXPprojectApplication {

    private static final Logger log = LoggerFactory.getLogger(KinoXPprojectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(KinoXPprojectApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(MovieRepository movieRepository,
                                        ReservationRepository reservationRepository,
                                        TheaterRepository theaterRepository,
                                        TicketRepository ticketRepository){
        return (args -> {

            final List<Theater> theaters = new ArrayList<>();
            final List<Movie> movies = new ArrayList<>();
            final List<Ticket> tickets = new ArrayList<>();
            final List<Reservation> reservations = new ArrayList<>();

            //The only two theaters
            theaters.add(new Theater(240, 1, false));
            theaters.add(new Theater(400, 2, false));
            theaterRepository.saveAll(theaters);

            //add movies
            String movie1Description = "John Wick 5 er efterfølgeren til den ikke eksisterende 4er, hvor makkeren bliver genoplivet for tredje gang";
            String movie2Description = "John Wick 6 er efterfølgeren til den ikke eksisterende 5er, hvor makkeren bliver genoplivet for fjerde gang";
            movies.add(new Movie("John Wick 5", "2t 22m", MovieGenre.ACTION, 18, movie1Description, "d. 24.dec : 20:00", theaters.get(0)));
            movies.add(new Movie("John Wick 6", "1t 05m", MovieGenre.ACTION, 18, movie2Description, "d. 23.dec : 20:00", theaters.get(0)));
            movies.add(new Movie("J. Leth biografi", "0t 69m", MovieGenre.COMEDY, 18, movie2Description, "d. 2.feb : 23:00", theaters.get(1)));
            movieRepository.saveAll(movies);


            //tickets for h2 test only
            tickets.add(new Ticket(1, 89, movies.get(0), reservations));
            tickets.add(new Ticket(47, 89, movies.get(0), reservations));
            tickets.add(new Ticket(42, 89, movies.get(1), reservations));
            ticketRepository.saveAll(tickets);

            //Vi bliver nødt til at dele tickets arrayet op i "tickets til sal1 og tickets til sal2" ellers får begge sale alle tickets :>
            final List<Ticket> ticketsForTheater1 = new ArrayList<>();
            final List<Ticket> ticketsForTheater2 = new ArrayList<>();
            ticketsForTheater1.add(new Ticket(1,2, movies.get(1), reservations));
            ticketsForTheater1.add(new Ticket(11,22, movies.get(0), reservations));
            ticketsForTheater2.add(new Ticket(12, 123, movies.get(1), reservations));
            ticketsForTheater2.add(new Ticket(123, 12345, movies.get(0), reservations));
            ticketsForTheater2.add(new Ticket(124, 123456, movies.get(0), reservations));
            ticketsForTheater2.add(new Ticket(125, 1234567, movies.get(0), reservations));
            ticketsForTheater2.add(new Ticket(126, 12345678, movies.get(0), reservations));
            ticketRepository.saveAll(ticketsForTheater1);
            ticketRepository.saveAll(ticketsForTheater2);


            //add reservations
            reservations.add(new Reservation("blaagaardbajer@påhusets.jatak", 6, ticketsForTheater1));
            reservations.add(new Reservation("2centimeter@defeater.action", 3, ticketsForTheater2));
            reservationRepository.saveAll(reservations);
        });
    }

}
