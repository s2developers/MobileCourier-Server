package pl.s2devs.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.s2devs.person.model.Client;
import pl.s2devs.person.repository.ClientRepository;

import java.util.List;

/**
 * Created by rafal on 14.11.17.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    ClientRepository courierRepository;

    @GetMapping("/get/clients")
    public ResponseEntity<List<Client>> getAllClients() {
        return ResponseEntity.ok(courierRepository.findAll());
    }

    @GetMapping("/add/client")
    public ResponseEntity<Client> addClient(@RequestParam String email, @RequestParam String password) {
        Client client = new Client();
        client.setEmail(email);
        client.setPassword(password);
        courierRepository.save(client);
        return ResponseEntity.ok(client);
    }

}
