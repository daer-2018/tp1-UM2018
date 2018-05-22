package edu.com.isa.mbing.modelo;

import edu.com.isa.mbing.entidad.Mencion;
import edu.com.isa.mbing.entidad.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITagDao extends JpaRepository<Tag,Integer> {

  @Query("FROM Tag  t WHERE t.publicacion.idPublicacion=:idPublicacion")
  List<Tag> listarTagPorPublicacion(@Param("idPublicacion") int idPublicacion );


}
