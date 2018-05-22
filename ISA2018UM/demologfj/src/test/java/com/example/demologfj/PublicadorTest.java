package com.example.demologfj;


import com.example.demologfj.entidad.Publicador;
import com.example.demologfj.servicio.PublicadorServicioImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicadorTest {

  @Autowired
  PublicadorServicioImpl publicadorServicio;

  //Test Capa Entidad
  @Test
  public void registrarPublicadorEntidad(){
    Publicador publicador = new Publicador();
    publicador.setNombre("testTeando1");
    publicador.setIdPublicador(3);
    Assert.assertEquals("testTeando1",publicador.getNombre());
    Assert.assertThat(3,is(publicador.getIdPublicador()));
  }

  //Test Capa Servicio
  @Test
  public void registrarPublicadorServicio(){
    Publicador publicadors = new Publicador();
    publicadors.setNombre("testTeando5");
    publicadors.setIdPublicador(1);
    Assert.assertEquals(publicadors.getNombre(),
      publicadorServicio.registrarPublicadorServicio(publicadors).getNombre());
    Assert.assertThat(publicadors.getIdPublicador(),
      is(publicadorServicio.registrarPublicadorServicio(publicadors).getIdPublicador()));

  }

}
