package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.Model.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends JpaRepository<Action, Long> {
}
