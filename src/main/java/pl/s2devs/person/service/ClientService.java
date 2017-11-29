package pl.s2devs.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.model.Person;
import pl.s2devs.person.repository.PersonRepository;

import static pl.s2devs.shared.response.RegistrationResponse.Code;

/**
 * Created by rafal on 14.11.17.
 */
@Service
public class ClientService {

    @Autowired
    private PersonRepository personRepository;

    public PersonRepository getClientRepository() {
        return personRepository;
    }

    public Code registerNewClient(Person Person) {
        Person nullable = personRepository.findByEmail(Person.getEmail());

        if(emailAddressIsAvailable(nullable)) {
            personRepository.save(Person);
            return Code.PERSON_REGISTERED;
        } else {
            return Code.EMAIL_TAKEN;
        }

    }

    private boolean emailAddressIsAvailable(Person nullable) {
        return nullable == null;
    }

}
