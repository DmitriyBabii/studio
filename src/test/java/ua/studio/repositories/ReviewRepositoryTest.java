package ua.studio.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.studio.models.entities.Reviews;
import ua.studio.models.entities.Studio;
import ua.studio.models.entities.User;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StudioRepository studioRepository;
    private UUID userId;

    @BeforeEach
    void setUp() {
        User user = new User();
        Studio studio = new Studio();
        Reviews reviews = new Reviews(
                user,
                studio,
                "I like it",
                4
        );
        userRepository.save(user);
        studioRepository.save(studio);
        reviewRepository.save(reviews);
    }

    @AfterEach
    void tearDown() {
        reviewRepository.deleteAll();
    }

    @Test
    void findAllByUserId() {
        assertNotNull(reviewRepository.findAllByUserId(userId));
    }
}