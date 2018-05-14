package edu.com.isa.mbing.servicio.interfacee;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;

import java.util.List;

public interface IPublicadorServicio {


  Publicador registrarPublicadorServicio(Publicador publicador);

  void  modificarDatosDePublicadorServicio(Publicador publicador);

  void eliminarPublicadorServicio( int idPublicador);

  Publicador listarPublicadorPorIdServicio(int idPublicador);

  List<Publicador> buscarPublicadoresServicio();

}
