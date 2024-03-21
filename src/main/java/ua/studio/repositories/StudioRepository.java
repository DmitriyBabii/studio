package ua.studio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.studio.models.entities.Studio;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudioRepository extends JpaRepository<Studio, UUID> {
    @Query("SELECT s FROM Studio s WHERE s.name=:search OR s.city=:search")
    List<Studio> findAllBySearch(@Param("search") String search);

    @Query("SELECT s FROM Studio s WHERE s.manager.id=:id")
    List<Studio> findAllByManagerId(@Param("id") UUID id);
}
