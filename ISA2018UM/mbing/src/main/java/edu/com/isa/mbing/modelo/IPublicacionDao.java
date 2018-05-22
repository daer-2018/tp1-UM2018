package edu.com.isa.mbing.modelo;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionDao extends JpaRepository<Publicacion, Integer> {

  List<Publicacion> findPublicacionsByPublicador_IdPublicador(Integer idPublicador);

  @Query( "FROM Publicacion p WHERE p.cuerpo LIKE %:tag% ")
  List<Publicacion> buscarPublicacionesPorTagDao(@Param("tag") String tag);


  @Query( "FROM Publicacion p WHERE p.cuerpo LIKE %:mencion% ")
  List<Publicacion> buscarPublicacionesPorMencionDao(@Param("mencion") String mencion);

  @Query( "FROM Publicacion p WHERE p.publicador.idPublicador =:idPublicador AND p.idPublicacion=:idPublicacion")
  Publicacion buscarParaBorrarPublicacionDao(@Param("idPublicador") int idPublicador, @Param("idPublicacion") int idPublicacion);

  @Query("FROM Publicacion p WHERE p.publicador.idPublicador =:idPublicador")
  Publicacion buscarPublicadorQueSigoDao(@Param("idPublicador") int idPublicador);

}
