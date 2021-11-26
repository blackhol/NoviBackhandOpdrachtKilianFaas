package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.files.Carfiles;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarFileRepository extends CrudRepository<Carfiles, Long> {

    @Query("select f from Carfiles as f where f.car.carID = ?1")
    List<Carfiles> findFilesByCarId(Long carID);

    @Modifying
    @Query("delete from Carfiles as f where f.car.carID = ?1 and f.modifiedFileName in (?2)")
    void deleteFilesByUserUdAndImageNames(long carID, List<String> removeImages);
}
