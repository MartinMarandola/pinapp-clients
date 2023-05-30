package com.pinappchallenge.app.rest.mapper;

import com.pinappchallenge.app.rest.model.dto.ClientAddReqDTO;
import com.pinappchallenge.app.rest.model.dto.ClientResDTO;
import com.pinappchallenge.app.rest.model.entity.ClientEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClientDTOMapper {


    public static ClientEntity fromClientDTO(ClientAddReqDTO clientDTO) {
        ClientEntity client = new ClientEntity();
        client.setName(clientDTO.getName());
        client.setLastName(clientDTO.getLastName());
        client.setAge(clientDTO.getAge());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth;
        try {
            dateOfBirth = format.parse(clientDTO.getDateOfBirth());
            client.setDateOfBirth(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return client;
    }

    public static List<ClientResDTO> fromGetClients(List<ClientEntity> clients){
        int ageLimitIndex = 80;
        List<ClientResDTO> clientsResList = new ArrayList<>();
        for (ClientEntity c : clients){
            ClientResDTO clientRes = new ClientResDTO();
            clientRes.setId(c.getId());
            clientRes.setName(c.getName());
            clientRes.setLastName(c.getLastName());
            clientRes.setAge(c.getAge());
            clientRes.setDateOfBirth(c.getDateOfBirth());

            LocalDate localDate = c.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            localDate = localDate.plusYears(ageLimitIndex);

            Date datePlusYears = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            clientRes.setEstimatedDeathDate(datePlusYears);

            clientsResList.add(clientRes);
        }
        return clientsResList;
    }
}
