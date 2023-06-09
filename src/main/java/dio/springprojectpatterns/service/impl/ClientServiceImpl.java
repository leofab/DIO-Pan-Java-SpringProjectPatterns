package dio.springprojectpatterns.service.impl;

import dio.springprojectpatterns.model.Adress;
import dio.springprojectpatterns.model.Client;
import dio.springprojectpatterns.repository.AdressRepo;
import dio.springprojectpatterns.repository.ClientRepo;
import dio.springprojectpatterns.service.ClientService;
import dio.springprojectpatterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepo clientRepo;
    @Autowired
    private AdressRepo adressRepo;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        Optional<Client> client = clientRepo.findById(id);
        return client;
    }

    @Override
    public Client add(Client client) {
        // Buscar o id da pessoa que no AdressRepo é o cep
        saveClientWithCep(client);
        return client;
    }

    @Override
    public void update(Long id, Client client) {
        Optional<Client> client2 = clientRepo.findById(id);
        if(client2.isPresent()){
            saveClientWithCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }

    private void saveClientWithCep(Client client) {
        String cep = client.getAdress().getCep();
        Adress adress = adressRepo.findById(cep).orElseGet(() -> {
            Adress newAdress = viaCepService.findCep(cep);
            adressRepo.save(newAdress);
            return newAdress;
        });

        client.setAdress(adress);
        clientRepo.save(client);
    }
}
