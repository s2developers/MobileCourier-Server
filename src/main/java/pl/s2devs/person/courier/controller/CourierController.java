package pl.s2devs.person.courier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.s2devs.person.courier.model.Courier;
import pl.s2devs.person.courier.service.CourierService;
import pl.s2devs.shared.response.RegistrationResponse;

import java.util.List;

/**
 * Created by rafal on 14.11.17.
 */
@RestController
@RequestMapping("/courier")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping("/get/all")
    public ResponseEntity<List<Courier>> getAllClients() {
        return ResponseEntity.ok(courierService.getCourierRepository().findAll());
    }

    @GetMapping("/get/by/email")
    public ResponseEntity<Courier> getClientByEmail(@RequestParam String email) {
        return ResponseEntity.ok(courierService.getCourierRepository().findByEmail(email));
    }

    @PostMapping("/new")
    public ResponseEntity<RegistrationResponse> registerNewClient(@RequestBody Courier courier) {
        return ResponseEntity.ok(new RegistrationResponse(
                courier,
                courierService.registerNewClient(courier)
        ));
    }

}
