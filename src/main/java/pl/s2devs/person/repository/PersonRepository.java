package pl.s2devs.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.s2devs.person.model.Person;

/**
 * Created by rafal on 14.11.17.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByEmail(String email);

}
