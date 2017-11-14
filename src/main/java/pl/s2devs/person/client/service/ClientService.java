package pl.s2devs.person.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.s2devs.person.client.model.Client;
import pl.s2devs.person.client.repository.ClientRepository;

import static pl.s2devs.shared.response.RegistrationResponse.Code;

/**
 * Created by rafal on 14.11.17.
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public Code registerNewClient(Client client) {
        Client nullable = clientRepository.findByEmail(client.getEmail());

        if(emailAddressIsAvailable(nullable)) {
            clientRepository.save(client);
            return Code.CLIENT_REGISTERED;
        } else {
            return Code.EMAIL_TAKEN;
        }

    }

    private boolean emailAddressIsAvailable(Client nullable) {
        return nullable == null;
    }

}
