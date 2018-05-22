package edu.com.isa.mbing.servicio.interfacee;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;

import java.util.List;

public interface IMencionServicio {

  public List<Publicacion> buscarPublicacionesPorMencion(Publicador publicador);

}
