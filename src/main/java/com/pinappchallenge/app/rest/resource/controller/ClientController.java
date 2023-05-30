package com.pinappchallenge.app.rest.resource.controller;

import com.pinappchallenge.app.rest.Service.ClientService;
import com.pinappchallenge.app.rest.model.dto.ClientAddReqDTO;
import com.pinappchallenge.app.rest.model.dto.ClientKpiResDTO;
import com.pinappchallenge.app.rest.model.dto.ClientResDTO;
import com.pinappchallenge.app.rest.model.entity.ClientEntity;
import com.pinappchallenge.app.rest.resource.ClientResource;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController implements ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/listClients")
    @Override
    public ResponseEntity<List<ClientResDTO>> getClients() {

        return ResponseEntity.ok(clientService.getClients());
    }

    @PostMapping(value = "/addClient")
    @Override
    public ResponseEntity<String> addClient(@RequestBody ClientAddReqDTO client) {
        clientService.addClient(client);
        return ResponseEntity.ok("Client saved");
    }

    @GetMapping(value = "/kpiClients")
    @Override
    public ClientKpiResDTO getAverageAgeAndDeviation() {
        return clientService.getClientsAverageAge();
    }


}
