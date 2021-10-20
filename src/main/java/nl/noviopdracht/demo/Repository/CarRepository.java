package nl.noviopdracht.demo.Repository;

import nl.noviopdracht.demo.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarRepository extends JpaRepository< Car , Long> {

}