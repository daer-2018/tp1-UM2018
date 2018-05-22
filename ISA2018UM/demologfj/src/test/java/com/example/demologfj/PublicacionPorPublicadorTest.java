package com.example.demologfj;
import com.example.demologfj.entidad.Publicacion;
import com.example.demologfj.entidad.Publicador;
import com.example.demologfj.servicio.PublicacionServicioImpl;
import com.example.demologfj.servicio.PublicadorServicioImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicacionPorPublicadorTest {

  @Autowired
  PublicacionServicioImpl publicacionServicio;


  @Autowired
  PublicadorServicioImpl publicadorServ;

  @Test
  public void crearPublicadorTest(){

    Publicador publicadors = new Publicador();
    publicadors.setNombre("publicadorINTEGRADOR2");
    publicadors.setIdPublicador(15);

    Assert.assertEquals(publicadors.getNombre(),
      publicadorServ.registrarPublicadorServicio(publicadors).getNombre());
    Assert.assertThat(publicadors.getIdPublicador(),
      is(publicadorServ.registrarPublicadorServicio(publicadors).getIdPublicador()));

    Publicacion publicacion = new Publicacion();
    publicacion.setIdPublicacion(15);
    publicacion.setPublicador(publicadors);
    publicacion.setCuerpo("Publicacion INTEGRADORA2");
    publicacion.setFecha(LocalDate.now());

    Assert.assertThat(publicadors.getIdPublicador(),
      is(publicacionServicio.publicarPublicacionServicio(publicacion).getPublicador().getIdPublicador()));


  }
}