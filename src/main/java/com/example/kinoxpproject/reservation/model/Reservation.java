package com.example.kinoxpproject.reservation.model;


import com.example.kinoxpproject.ticket.model.Ticket;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
public class Reservation {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private int numberOfPersons;
    @OneToMany
    @JoinColumn(name = "ticket_id")
    private List<Ticket> ticket;

}
