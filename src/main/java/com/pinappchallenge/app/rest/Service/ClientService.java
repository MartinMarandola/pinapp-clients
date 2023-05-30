package com.pinappchallenge.app.rest.Service;

import com.pinappchallenge.app.rest.model.dto.ClientAddReqDTO;
import com.pinappchallenge.app.rest.model.dto.ClientKpiResDTO;
import com.pinappchallenge.app.rest.model.dto.ClientResDTO;
import com.pinappchallenge.app.rest.model.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    List<ClientResDTO> getClients();

    void addClient(ClientAddReqDTO client);

    ClientKpiResDTO getClientsAverageAge();
}
