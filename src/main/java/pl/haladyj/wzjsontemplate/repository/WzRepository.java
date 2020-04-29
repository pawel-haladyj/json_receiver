package pl.haladyj.wzjsontemplate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.haladyj.wzjsontemplate.model.Wz;

import java.util.Optional;

@Repository
public interface WzRepository extends JpaRepository<Wz,Long> {

    @Query(value = "SELECT sn FROM wz WHERE created_at = (SELECT MAX(created_at) FROM wz)", nativeQuery = true)
    Optional<String> findMostRecentSnFromWz();
}
