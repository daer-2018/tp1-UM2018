package com.example.demologfj;

import com.example.demologfj.entidad.Publicacion;
import com.example.demologfj.entidad.Publicador;
import com.example.demologfj.servicio.PublicacionServicioImpl;
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
public class PublicacionTest {
  @Autowired
  PublicacionServicioImpl publicacionServicio;

  @Test
  public void publicarPublicacionEntidad() {

    Publicacion publicacion = new Publicacion();

    Publicador publicador = new Publicador();
    publicador.setIdPublicador(4);
    publicador.setNombre("coco");

    publicacion.setIdPublicacion(2);
    publicacion.setPublicador(publicador);
    publicacion.setCuerpo("Publicando desde el Test");


    Assert.assertEquals("Publicando desde el Test",publicacion.getCuerpo());
    Assert.assertThat(2,is(publicacion.getIdPublicacion()));
    Assert.assertThat(4,is(publicacion.getPublicador().getIdPublicador()));
    Assert.assertEquals("coco",publicacion.getPublicador().getNombre());
  }

  @Test
  public void publicarPublicacionServicio() {
    Publicacion publicacion = new Publicacion();

    Publicador publicador = new Publicador();
    publicador.setIdPublicador(4);
    publicador.setNombre("paco");

    publicacion.setIdPublicacion(2);
    publicacion.setPublicador(publicador);
    publicacion.setCuerpo("Publicando desde el Testereado");
    publicacion.setFecha(LocalDate.now());

    Assert.assertEquals(publicacion.getCuerpo(),
      publicacionServicio.publicarPublicacionServicio(publicacion).getCuerpo());
    Assert.assertThat(publicacion.getIdPublicacion(),
      is(publicacionServicio.publicarPublicacionServicio(publicacion).getIdPublicacion()));
    Assert.assertThat(publicacion.getPublicador().getIdPublicador(),
      is(publicacionServicio.publicarPublicacionServicio(publicacion).getPublicador().getIdPublicador()));
   }
  }
