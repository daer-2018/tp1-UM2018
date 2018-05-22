package com.example.demologfj.servicio;

import com.example.demologfj.entidad.Publicador;
import com.example.demologfj.servicio.IPublicadorServicio;
import com.example.demologfj.modelo.IPublicadorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicadorServicioImpl implements IPublicadorServicio {

  @Autowired
  private IPublicadorDao publicadorDao;

  @Override
  public Publicador registrarPublicadorServicio(Publicador pu) {

    return publicadorDao.save(pu);
  }

  @Override
  public List<Publicador> buscarPublicadoresServicio() {
    return publicadorDao.findAll();
  }



  @Override
  public void  modificarDatosDePublicadorServicio(Publicador pu) {
    publicadorDao.save(pu);
  }
  /*
  @Override
  public Publicador listarPublicadorPorIdServicio(int idPublicador) {

    return publicadorDao.findOne(idPublicador);
  }
  @Override
  public void eliminarPublicadorServicio(int idPublicador) {
    publicadorDao.delete(idPublicador);
  }
*/

}
