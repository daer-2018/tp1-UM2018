package edu.com.isa.mbing.modelo;

import edu.com.isa.mbing.entidad.Mencion;
import edu.com.isa.mbing.entidad.PublicadorSigue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicadorSigueDao extends JpaRepository<PublicadorSigue, Integer> {

  //ListarMisSeguidoresDao -> los que me siguen.
  @Query("FROM PublicadorSigue ps WHERE ps.seguido.idPublicador=:idPublicador")
  List<PublicadorSigue> ListarMisSeguidoresDao(@Param("idPublicador") int idPublicador);



  @Query("FROM PublicadorSigue ps WHERE ps.publicador.idPublicador=:idPublicador AND ps.seguido.idPublicador=:idSeguido")
  PublicadorSigue dejarDeSeguirPublicadorDao(@Param("idPublicador") int idPublicador,@Param("idSeguido") int idSeguido);

  // ListarMisSeguidosDao --> A los que sigo
  @Query("FROM PublicadorSigue ps WHERE ps.publicador.idPublicador=:idPublicador")
  List<PublicadorSigue> ListarMisSeguidosDao(@Param("idPublicador") int idPublicador);
}
