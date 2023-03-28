package dio.springprojectpatterns.service;

import dio.springprojectpatterns.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    Iterable<Client> findAll();

    Client findById(Long id);

    void add(Client client);

    void update(Long id, Client client);

    void delete(Long id);
}
