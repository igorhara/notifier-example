package com.igorhara.example.ejb.dao;

import com.igorhara.example.ejb.entity.Notifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotifierDAO extends JpaRepository<Notifier, Long> {
}
