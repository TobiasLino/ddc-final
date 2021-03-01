package com.tecsus.ddc.model.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    List<Client> findAll();

    @Override
    Optional<Client> findById(Long aLong);

    @Override
    <S extends Client> S save(S s);
}
