package ua.studio.models.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter(AccessLevel.NONE)
    private UUID id;
    private String name;
    private String email;
    private String password;
    @Column(columnDefinition = "VARCHAR(1000)")
    private String aboutMe;

    @ElementCollection
    @CollectionTable(
            name = "saved_studios",
            joinColumns = @JoinColumn(name = "user_id")
    )
    private List<Studio> savedStudio;
}
