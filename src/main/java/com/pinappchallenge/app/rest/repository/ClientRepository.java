package com.pinappchallenge.app.rest.repository;

import com.pinappchallenge.app.rest.model.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByNameAndLastName(@Param("name") String clientName, @Param("lastName") String lastName);
}
