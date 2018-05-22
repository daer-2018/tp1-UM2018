package edu.com.isa.mbing.fachada;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.Tag;
import edu.com.isa.mbing.servicio.interfacee.IPublicacionServicio;
import edu.com.isa.mbing.servicio.interfacee.IPublicadorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PublicacionFachada {

  @Autowired
  private IPublicacionServicio publicacionServicio;

  public Publicacion publicarPublicacionFachada(Publicacion publicacion) {
    return publicacionServicio.publicarPublicacionServicio(publicacion);
  }

  public int republicarPublicacionFachada(Publicador publicador, Publicacion publicacion) { //IPublicacionServicio
    return  publicacionServicio.republicarPublicacionServicio(publicador,publicacion);
  }

  public List<Publicacion> buscarPublicacionesPorPublicadorFachada(int idPublicador) { //IPublicacionServicio
    return publicacionServicio.buscarPublicacionesPorPublicadorServicio(idPublicador);
  }

  public List<Publicacion> buscarPublicacionesPorTagFachada(String texto){ //IMencionServicio
    return publicacionServicio.buscarPublicacionesPorTagServicio(texto);
  }

  public List<Publicacion> buscarPublicacionesPorMencionFachada(String publicador){ //IMencionServicio
    return publicacionServicio.buscarPublicacionesPorMencionServicio(publicador);
  }

  public void borrarPublicacionFachada(int idPublicador, int idPublicacion) { //IPublicacionServicio
    publicacionServicio.borrarPublicacionServicio(idPublicador,idPublicacion);
  }

  public List<Publicacion> listarPublicacionesFachada() {
    return publicacionServicio.listarPublicacionesServicio();
  }
  // Buscar que publicaciones sigue este publicador, mostrar sus "todas"
  public List<Publicacion>listarPublicacionesQuestaSiguiendoFachada(int idPublicador) { //IPublicadorSeguidorServicio

    return publicacionServicio.listarPublicacionesQuestaSiguiendoServicio(idPublicador);
  }
}
