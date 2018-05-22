package edu.com.isa.mbing.servicio.interfacee;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.PublicadorSigue;

import java.util.List;

public interface IPublicadorSigueServicio {

  int seguirAotroPublicadorServicio(Publicador publicador,Publicador seguidor);
  PublicadorSigue seguirPublicadorServicio(PublicadorSigue publicadorSigue);

  List<PublicadorSigue>listarPublicadoresQueMeSiguenServicio(int usuarioId);

  void dejarDeSeguirPublicadorServicio( int idPublicador,int idseguido);

}
