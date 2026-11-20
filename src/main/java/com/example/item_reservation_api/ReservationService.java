package com.example.item_reservation_api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        return reservationRepository.findById(id).orElseThrow();
    }

    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(int id, Reservation reservation) {
        reservation.setId(id);
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
