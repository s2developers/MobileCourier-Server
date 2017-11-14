package pl.s2devs.person.courier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.s2devs.person.courier.model.Courier;

/**
 * Created by rafal on 14.11.17.
 */
@Repository
public interface CourierRepository extends JpaRepository<Courier, Long> {

    Courier findByEmail(String email);

}
