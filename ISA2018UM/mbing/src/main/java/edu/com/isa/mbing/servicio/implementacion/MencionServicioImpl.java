package edu.com.isa.mbing.servicio.implementacion;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.servicio.interfacee.IMencionServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
MencionServicioImpl implements IMencionServicio {
  @Override
  public List<Publicacion> buscarPublicacionesPorMencion(Publicador publicador) {

    return null;
  }
}
