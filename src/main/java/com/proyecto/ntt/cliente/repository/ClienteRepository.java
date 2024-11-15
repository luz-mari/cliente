package com.proyecto.ntt.cliente.repository;

import com.proyecto.ntt.cliente.repository.dao.ClienteDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<ClienteDao, Integer> {

}
