package com.ps.salaoconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.salaoconnect.domain.Salao;

@Repository
public interface SalaoRepository extends JpaRepository<Salao, Integer>{

}
