package com.pinappchallenge.app.rest.resource;


import com.pinappchallenge.app.rest.model.dto.ClientAddReqDTO;
import com.pinappchallenge.app.rest.model.dto.ClientKpiResDTO;
import com.pinappchallenge.app.rest.model.dto.ClientResDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api(
        value = "Client API Resources"
)
public interface ClientResource {
    @ApiOperation(
            value = "Get Clients",
            notes = "Returns the data of all clients."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "forbidden")})
    ResponseEntity<List<ClientResDTO>> getClients();

    @ApiOperation(
            value = "Adds a New Client",
            notes = "Returns a message if the client was saved."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "forbidden")})
    ResponseEntity<String> addClient(
            @ApiParam(value = "Client Body Data", required = true) ClientAddReqDTO client);

    @ApiOperation(
            value = "Calculate the average age and standard deviation",
            notes = "Returns the clients average age and standard deviation."
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "forbidden")})
    ClientKpiResDTO getAverageAgeAndDeviation();
}
