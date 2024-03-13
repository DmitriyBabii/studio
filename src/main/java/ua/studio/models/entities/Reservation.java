package ua.studio.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.studio.models.PaymentType;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    @Column(columnDefinition = "VARCHAR(1000)")
    private String promo;
    @Enumerated
    private PaymentType paymentType;
    private Timestamp start;

    @ManyToOne
    private User customer;
    @ManyToOne
    private Studio studio;
}
