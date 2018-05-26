package com.ps.salaoconnect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.salaoconnect.domain.Agendar;

@Repository
public interface AgendarRepository extends JpaRepository<Agendar, Integer>{

}
