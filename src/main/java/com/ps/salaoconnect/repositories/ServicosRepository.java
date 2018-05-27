package com.ps.salaoconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.salaoconnect.domain.Servicos;

@Repository
public interface ServicosRepository extends JpaRepository<Servicos, Integer>{

}
