package edu.com.isa.mbing.servicio.implementacion;

import edu.com.isa.mbing.entidad.Publicacion;
import edu.com.isa.mbing.entidad.Publicador;
import edu.com.isa.mbing.entidad.PublicadorSigue;
import edu.com.isa.mbing.modelo.IPublicadorSigueDao;
import edu.com.isa.mbing.servicio.interfacee.IPublicadorSigueServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;

@Service
public class PublicadorSigueServicioImpl implements IPublicadorSigueServicio {

  @Autowired
  private IPublicadorSigueDao publicadorSigueDao;

  @Override
  public int seguirAotroPublicadorServicio(Publicador publicador, Publicador seguidor) {
    int estado = 0;
    PublicadorSigue publicadorSigue = new PublicadorSigue();
    publicadorSigue.setIdPublicadorSigue(0);
    publicadorSigue.setPublicador(publicador);
    publicadorSigue.setSeguido(seguidor);
    if (publicadorSigueDao.save(publicadorSigue) != null) estado = 1;
    return estado;
  }

  @Override
  public PublicadorSigue seguirPublicadorServicio(PublicadorSigue publicadorSigue) {
    return publicadorSigueDao.save(publicadorSigue);
  }

    @Override
    public List<PublicadorSigue> listarPublicadoresQueMeSiguenServicio(int usuarioId) {
      return publicadorSigueDao.ListarMisSeguidoresDao(usuarioId);
    }

  @Override
  public void dejarDeSeguirPublicadorServicio( int idPublicador,int idseguido) {
    PublicadorSigue publicadorSigue = new PublicadorSigue();
    publicadorSigue = publicadorSigueDao.dejarDeSeguirPublicadorDao(idPublicador,idseguido);
    publicadorSigueDao.delete(publicadorSigue.getIdPublicadorSigue());
  }

}
