package edu.com.isa.mbing.modelo;

import edu.com.isa.mbing.entidad.Mencion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMencionDao extends JpaRepository<Mencion,Integer> {

  @Query("FROM Mencion m WHERE m.publicacion.idPublicacion=:idPublicacion")
  List<Mencion> listarMencionPorPublicacionDao(@Param("idPublicacion") int idPublicacion);
}
