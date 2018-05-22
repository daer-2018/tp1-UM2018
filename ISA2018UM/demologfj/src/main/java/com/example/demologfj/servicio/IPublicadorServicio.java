package com.example.demologfj.servicio;

import com.example.demologfj.entidad.Publicador;

import java.util.List;

public interface IPublicadorServicio {


  Publicador registrarPublicadorServicio(Publicador publicador);

  void  modificarDatosDePublicadorServicio(Publicador publicador);
/*
  void eliminarPublicadorServicio( int idPublicador);

  Publicador listarPublicadorPorIdServicio(int idPublicador);
*/
  List<Publicador> buscarPublicadoresServicio();


}
