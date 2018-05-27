package com.ps.salaoconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.salaoconnect.domain.Avaliacao;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

}
