package edu.com.isa.mbing.fachada;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.PublicadorSigue;
import edu.com.isa.mbing.servicio.interfacee.IPublicadorServicio;
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

  public Publicador listarPublicadorPorIdFachada(int idPublicador) {
    return publicadorServicio.listarPublicadorPorIdServicio(idPublicador);
  }

  public void  modificarDatosDePublicadorFachada(Publicador pu) {
    publicadorServicio. modificarDatosDePublicadorServicio(pu);
  }

  public void eliminarPublicadorFachada(int idPublicador) {
    publicadorServicio.eliminarPublicadorServicio(idPublicador);
  }
}
