package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.files.Carfiles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFileRepository extends CrudRepository<Carfiles, Long> {
}
