package edu.com.isa.mbing.entidad;

import com.sun.istack.internal.Interned;

import javax.persistence.*;

@Entity
@Table(name = "mencion")
public class Mencion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMencion;

  @ManyToOne// Muchas publicaciones son de un publicador
  @JoinColumn(name ="id_publicacion", nullable = false) // creo registro en BD
    private Publicacion publicacion;

    @Column(name = "texto_mencion",length = 255)
    private String textoMencion;

  public Mencion() {
  }

  public Mencion(Publicacion publicacion, String textoMencion) {
    this.publicacion = publicacion;
    this.textoMencion = textoMencion;
  }

  public int getIdMencion() {
    return idMencion;
  }

  public void setIdMencion(int idMencion) {
    this.idMencion = idMencion;
  }

  public Publicacion getPublicacion() {
    return publicacion;
  }

  public void setPublicacion(Publicacion publicacion) {
    this.publicacion = publicacion;
  }

  public String getTextoMencion() {
    return textoMencion;
  }

  public void setTextoMencion(String textoMencion) {
    this.textoMencion = textoMencion;
  }
}