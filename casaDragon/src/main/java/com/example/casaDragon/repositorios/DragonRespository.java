package com.example.casaDragon.repositorios;

import com.example.casaDragon.models.Dragon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DragonRespository extends JpaRepository <Dragon, Integer> {
}
