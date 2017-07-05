package com.igorhara.example.ejb.dao;

import com.igorhara.example.ejb.entity.Notifier;
import com.igorhara.example.ejb.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerDAO extends JpaRepository<Owner, Long> {
}
