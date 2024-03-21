package ua.studio.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.studio.models.PaymentType;
import ua.studio.models.entities.Reservation;
import ua.studio.models.entities.Studio;
import ua.studio.models.entities.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReservationRepositoryTest {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private UserRepository userRepository;
    private UUID customerId;

    @BeforeEach
    void setUp() {
        User customer = new User();
        Studio studio = new Studio();
        Reservation reservation = new Reservation(
                "Name",
                "Surname",
                "Email",
                "Promo",
                PaymentType.CARD,
                Timestamp.valueOf(LocalDateTime.now()),
                customer,
                studio
        );

        userRepository.save(customer);
        studioRepository.save(studio);
        reservationRepository.save(reservation);

        customerId = customer.getId();
    }

    @AfterEach
    void tearDown() {
        reservationRepository.deleteAll();
    }

    @Test
    void findAllByUserId() {
        assertNotNull(reservationRepository.findAllByUserId(customerId));
    }
}