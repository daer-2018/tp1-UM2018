package edu.com.isa.mbing.servicio.interfacee;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Tag;

import java.util.List;

public interface ITagServicio {

  List<Publicacion> buscarPublicacionesPorTag(Tag tag);

}
