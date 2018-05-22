package edu.com.isa.mbing.fachada;

import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.PublicadorSigue;
import edu.com.isa.mbing.servicio.interfacee.IPublicadorSigueServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicadorSigueFachada {

  @Autowired
  private IPublicadorSigueServicio publicadorSigueServicio;

  public int seguirAotroPublicadorFachada(Publicador Publicador, Publicador seguido) { //IPublicadorServicio
    return   publicadorSigueServicio.seguirAotroPublicadorServicio(Publicador,seguido);
  }

  public PublicadorSigue seguirPublicadorFachada(PublicadorSigue publicadorSigue) { //IPublicacionServicio
    return publicadorSigueServicio.seguirPublicadorServicio(publicadorSigue);
  }

  public List<PublicadorSigue> listarPublicadoresQueMeSiguenFachada(int usuarioId){
      return publicadorSigueServicio.listarPublicadoresQueMeSiguenServicio(usuarioId);
  }

  public void dejarDeSeguirPublicadorFachada(int idPublicador, int idSeguido){
    publicadorSigueServicio.dejarDeSeguirPublicadorServicio(idPublicador, idSeguido);
  }

}
