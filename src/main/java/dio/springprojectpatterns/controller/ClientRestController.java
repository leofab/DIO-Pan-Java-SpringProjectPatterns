package dio.springprojectpatterns.controller;

import dio.springprojectpatterns.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.springprojectpatterns.service.ClientService;


@RestController
@RequestMapping("clients")

public class ClientRestController {

    @Autowired(required = false)
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Client> add(@RequestBody Client client) {
        clientService.add(client);
        return ResponseEntity.ok(client);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        clientService.update(id, client);
        return ResponseEntity.ok(client);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }
}


