package edu.com.isa.mbing.entidad;

import javax.persistence.*;

/*Publicador común que aún no hizo una publicacion para ser seguido*/
@Entity
@Table(name = "publicador")
public class Publicador { // Persona

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPublicador;

  @Column(name = "nombre", nullable = false,length = 25)
  private String nombre;


  public Publicador() {
  }

  public int getIdPublicador() {
    return idPublicador;
  }

  public void setIdPublicador(int idPublicador) {
    this.idPublicador = idPublicador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}

 /* @OneToMany(mappedBy = "publicador", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY,orphanRemoval = true)
  private List<Publicacion> publicaciones;
*/
