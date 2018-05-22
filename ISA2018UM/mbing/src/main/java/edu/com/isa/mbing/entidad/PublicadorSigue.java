package edu.com.isa.mbing.entidad;

import javax.persistence.*;

@Entity
@Table(name = "publicador_sigue")
public class PublicadorSigue {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPublicadorSigue;

  @ManyToOne// Muchas publicaciones son de un publicador
  @JoinColumn(name ="id_publicador", nullable = false) // creo registro en BD
  private Publicador publicador;


  @ManyToOne// Muchas publicaciones son de un publicador
  @JoinColumn(name ="id_seguido", nullable = false) // creo registro en BD
  private Publicador seguido;

  public PublicadorSigue() {
  }

  public PublicadorSigue(Publicador publicador, Publicador seguido) {
    this.publicador = publicador;
    this.seguido = seguido;
  }

  public int getIdPublicadorSigue() {
    return idPublicadorSigue;
  }

  public void setIdPublicadorSigue(int idPublicadorSigue) {
    this.idPublicadorSigue = idPublicadorSigue;
  }

  public Publicador getPublicador() {
    return publicador;
  }

  public void setPublicador(Publicador publicador) {
    this.publicador = publicador;
  }

  public Publicador getSeguido() {
    return seguido;
  }

  public void setSeguido(Publicador seguido) {
    this.seguido = seguido;
  }

}
