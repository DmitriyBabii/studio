package ua.studio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.studio.models.entities.Reviews;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, UUID> {
    @Query("SELECT r FROM Reviews r WHERE r.user.id=:id")
    List<Reviews> findAllByUserId(@Param("id") UUID id);
}
