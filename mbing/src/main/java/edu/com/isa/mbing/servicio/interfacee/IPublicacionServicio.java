package edu.com.isa.mbing.servicio.interfacee;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.Tag;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPublicacionServicio {

    Publicacion publicarPublicacionServicio(Publicacion publicacion);

    int republicarPublicacionServicio(Publicador publicador, Publicacion publicacion);


    List<Publicacion> listarPublicacionesServicio();

    List<Publicacion> buscarPublicacionesPorPublicadorServicio(int idPublicador);

    List<Publicacion> buscarPublicacionesPorMencionServicio(String publicador);

    List<Publicacion> buscarPublicacionesPorTagServicio(String texto);

    void borrarPublicacionServicio(int idPublicador, int idPublicacion);

    // Que publicaciones está siguiend este publicador
    List<Publicacion> listarPublicacionesQuestaSiguiendoServicio(int idPublicador);


}
