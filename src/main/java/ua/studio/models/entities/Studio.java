package ua.studio.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.studio.models.DayWeek;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    @ElementCollection
    private List<String> pictures;
    private String city;
    private String address;
    private Time timeStarts;
    private Time timeEnds;
    @Enumerated
    private DayWeek dayStarts;
    @Enumerated
    private DayWeek dayEnds;
    @ElementCollection
    private List<String> tags;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price; // per hour
    private Integer maxClients;

    @ManyToOne
    private User manager;
    @OneToMany(mappedBy = "studio")
    private List<Reviews> reviews;

    public Studio(String name, String city, String address, String description, Double price, User manager) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.description = description;
        this.price = price;
        this.manager = manager;
    }
}
