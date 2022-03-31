package com.megawarez.dao;

import com.megawarez.domain.Session;
import org.springframework.data.repository.CrudRepository;

public interface SessionDao extends CrudRepository<Session, Integer> {
}