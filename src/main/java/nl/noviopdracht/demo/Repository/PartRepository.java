package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.Model.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

}