package com.example.demologfj.fachada;

import com.example.demologfj.entidad.Publicador;
import com.example.demologfj.servicio.IPublicadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicadorFachada {

  @Autowired
  private IPublicadorServicio publicadorServicio;

  public Publicador registrarPublicadorFachada(Publicador pu) {
    return publicadorServicio.registrarPublicadorServicio(pu);
  }

  public List<Publicador> buscarPublicadoresFachada() {
    return publicadorServicio.buscarPublicadoresServicio();
  }



  public void  modificarDatosDePublicadorFachada(Publicador pu) {
    publicadorServicio. modificarDatosDePublicadorServicio(pu);
  }
  /*
  public Publicador listarPublicadorPorIdFachada(int idPublicador) {
    return publicadorServicio.listarPublicadorPorIdServicio(idPublicador);
  }
  public void eliminarPublicadorFachada(int idPublicador) {
    publicadorServicio.eliminarPublicadorServicio(idPublicador);
  }*/
}
