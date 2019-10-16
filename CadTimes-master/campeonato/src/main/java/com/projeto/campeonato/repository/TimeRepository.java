package com.projeto.campeonato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.campeonato.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
