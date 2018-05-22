package edu.com.isa.mbing.servicio.implementacion;

import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.modelo.IPublicadorDao;
import edu.com.isa.mbing.servicio.interfacee.IPublicadorServicio;
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
  public Publicador listarPublicadorPorIdServicio(int idPublicador) {
    return publicadorDao.findOne(idPublicador);
  }

  @Override
  public void  modificarDatosDePublicadorServicio(Publicador pu) {
    publicadorDao.save(pu);
  }

  @Override
  public void eliminarPublicadorServicio(int idPublicador) {
    publicadorDao.delete(idPublicador);
  }


}
