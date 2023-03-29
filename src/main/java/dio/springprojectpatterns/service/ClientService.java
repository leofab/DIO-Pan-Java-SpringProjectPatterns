package dio.springprojectpatterns.service;

import dio.springprojectpatterns.model.Client;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ClientService {

    Iterable<Client> findAll();

    Optional<Client> findById(Long id);

    Client add(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
