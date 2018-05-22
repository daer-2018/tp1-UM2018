package com.example.demologfj.modelo;

import com.example.demologfj.entidad.Publicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicadorDao extends JpaRepository<Publicador,Integer> {
}
