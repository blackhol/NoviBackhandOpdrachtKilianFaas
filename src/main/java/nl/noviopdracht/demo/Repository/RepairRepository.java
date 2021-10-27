package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.Model.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairRepository extends JpaRepository<Repair , Long > {
}
