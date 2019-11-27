package com.cadtimes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cadtimes.model.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

}
