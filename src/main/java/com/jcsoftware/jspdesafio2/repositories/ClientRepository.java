package com.jcsoftware.jspdesafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jcsoftware.jspdesafio2.entities.Client;



public interface ClientRepository extends JpaRepository<Client,Long> {

}
