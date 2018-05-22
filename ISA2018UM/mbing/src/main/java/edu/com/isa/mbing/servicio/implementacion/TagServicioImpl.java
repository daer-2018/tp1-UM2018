package edu.com.isa.mbing.servicio.implementacion;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Tag;
import edu.com.isa.mbing.servicio.interfacee.ITagServicio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServicioImpl implements ITagServicio {
  @Override
  public List<Publicacion> buscarPublicacionesPorTag(Tag tag) {
    return null;
  }
}
