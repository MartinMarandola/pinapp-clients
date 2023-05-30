package com.pinappchallenge.app.rest.Service.impl;

import com.pinappchallenge.app.rest.Service.ClientService;
import com.pinappchallenge.app.rest.mapper.ClientDTOMapper;
import com.pinappchallenge.app.rest.model.dto.ClientAddReqDTO;
import com.pinappchallenge.app.rest.model.dto.ClientKpiResDTO;
import com.pinappchallenge.app.rest.model.dto.ClientResDTO;
import com.pinappchallenge.app.rest.model.entity.ClientEntity;
import com.pinappchallenge.app.rest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientResDTO> getClients() {
        return ClientDTOMapper.fromGetClients(clientRepository.findAll());
    }

    @Override
    public void addClient(ClientAddReqDTO client) {
        ClientEntity c = ClientDTOMapper.fromClientDTO(client);
        if (searchUser(c)) {
            throw new RuntimeException("Client already exists");
        }
        clientRepository.save(c);
    }

    /**
     * checks if the user exists
     */
    private boolean searchUser(ClientEntity client) {
        ClientEntity existingClient = clientRepository.findByNameAndLastName(client.getName(), client.getLastName());
        boolean exists = existingClient != null;
        return exists;
    }

    @Override
    public ClientKpiResDTO getClientsAverageAge() {
        List<ClientEntity> clients;
        clients = clientRepository.findAll();
        ClientKpiResDTO client = new ClientKpiResDTO(getAverage(clients), calculateStandardDeviation(clients));
        return client;
    }

    /**
     * Calculates the average age of all clients
     */
    private double getAverage(List<ClientEntity> clients) {
        int suma = 0;

        for (ClientEntity c : clients) {
            suma += c.getAge();
        }

        return (double) suma / clients.size();
    }

    /**
     * Calculates the standard deviation
     */
    private double calculateStandardDeviation(List<ClientEntity> clients) {
        int n = clients.size();

        double suma = 0;
        double average = getAverage(clients);

        for (ClientEntity c : clients) {
            suma += Math.pow(c.getAge() - average, 2);
        }

        return Math.sqrt(suma / n);
    }
}
