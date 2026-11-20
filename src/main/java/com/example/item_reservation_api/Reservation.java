package com.example.item_reservation_api;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "予約")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "予約ID")
    private int id;

    @Column(name = "備品ID")
    private int itemId;

    @Column(name = "予約日")
    private LocalDate reservationDate;

    @Column(name = "予約者名")
    private String reserverName;

    @Column(name = "予約個数")
    private int quantity;
}
