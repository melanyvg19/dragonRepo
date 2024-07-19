package com.example.casaDragon.repositories;

import com.example.casaDragon.models.Aliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliadoRepository extends JpaRepository <Aliado, Integer> {

}
