package com.proyecto.ntt.cliente.repository;

import com.proyecto.ntt.cliente.repository.dao.ClienteDao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteDao, Integer> {

}
