package pl.s2devs.person.courier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.courier.model.Courier;
import pl.s2devs.person.courier.repository.CourierRepository;
import pl.s2devs.shared.response.RegistrationResponse;

/**
 * Created by rafal on 14.11.17.
 */
@Service
public class CourierService {

    @Autowired
    private CourierRepository courierRepository;

    public CourierRepository getCourierRepository() {
        return courierRepository;
    }

    public RegistrationResponse.Code registerNewClient(Courier courier) {
        Courier nullable = courierRepository.findByEmail(courier.getEmail());

        if(emailAddressIsAvailable(nullable)) {
            courierRepository.save(courier);
            return RegistrationResponse.Code.CLIENT_REGISTERED;
        } else {
            return RegistrationResponse.Code.EMAIL_TAKEN;
        }

    }

    private boolean emailAddressIsAvailable(Courier nullable) {
        return nullable == null;
    }

}
