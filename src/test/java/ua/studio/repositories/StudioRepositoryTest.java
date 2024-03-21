package ua.studio.repositories;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.studio.models.entities.Studio;
import ua.studio.models.entities.User;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudioRepositoryTest {
    @Autowired
    private StudioRepository studioRepository;
    @Autowired
    private UserRepository userRepository;
    private UUID managerId;

    @BeforeEach
    void setUp() {
        User manager = new User();
        Studio studio = new Studio(
                "StudioCosy",
                "Kharkiv",
                "Some address",
                "Some description",
                123.,
                manager
        );

        userRepository.save(manager);
        studioRepository.save(studio);

        managerId = manager.getId();
    }

    @AfterEach
    void tearDown() {
        studioRepository.deleteAll();
    }

    @Test
    void findAllBySearch() {
        assertNotNull(studioRepository.findAllBySearch("Kharkiv").stream().findAny().get());
        assertNotNull(studioRepository.findAllBySearch("StudioCosy").stream().findAny().get());
    }

    @Test
    void findAllByManagerId() {
        assertNotNull(studioRepository.findAllByManagerId(managerId).stream().findAny().get());
    }
}