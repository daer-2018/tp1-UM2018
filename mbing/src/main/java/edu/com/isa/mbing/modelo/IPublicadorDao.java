package edu.com.isa.mbing.modelo;

import edu.com.isa.mbing.entidad.Publicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPublicadorDao extends JpaRepository<Publicador,Integer> {
}
