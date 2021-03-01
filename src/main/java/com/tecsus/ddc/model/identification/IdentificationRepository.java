package com.tecsus.ddc.model.identification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IdentificationRepository extends JpaRepository<Identification, Long> {

    @Override
    List<Identification> findAll();

    @Override
    Optional<Identification> findById(Long aLong);

    @Override
    <S extends Identification> S save(S s);

    @Override
    void delete(Identification identification);
}
