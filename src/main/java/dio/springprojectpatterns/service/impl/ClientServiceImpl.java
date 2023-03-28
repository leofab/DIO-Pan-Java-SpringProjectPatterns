package dio.springprojectpatterns.service.impl;

import dio.springprojectpatterns.model.Client;
import dio.springprojectpatterns.service.ClientService;


public class ClientServiceImpl  implements ClientService {
    @Override
    public Iterable<Client> findAll() {
        return null;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public Client add(Client client) {

        return client;
    }

    @Override
    public void insert(Client client) {

    }

    @Override
    public void update(Long id, Client client) {

    }

    @Override
    public void delete(Long id) {

    }
}
