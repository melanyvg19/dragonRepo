package com.example.casaDragon.repositories;

import com.example.casaDragon.models.Jinete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JineteRepository extends JpaRepository <Jinete, Integer> {
}
