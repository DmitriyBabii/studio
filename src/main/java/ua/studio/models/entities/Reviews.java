package ua.studio.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Studio studio;
    private String review;
    private Integer rating;     // TODO check for 0 to 5

    public Reviews(User user, Studio studio, String review, Integer rating) {
        this.user = user;
        this.studio = studio;
        this.review = review;

        if (rating > 5) {
            rating = 5;
        } else if (rating < 0) {
            rating = 0;
        }
        this.rating = rating;
    }
}
