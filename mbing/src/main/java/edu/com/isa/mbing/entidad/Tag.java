package edu.com.isa.mbing.entidad;

import javax.persistence.*;

@Entity
@Table  (name="tag")
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
private int idTag;

  @ManyToOne// Muchas publicaciones son de un publicador
  @JoinColumn(name ="id_publicacion", nullable = false) // creo registro en BD
  private Publicacion publicacion;

@Column(name = "textotag", length = 255)
private String textoTag;

  public Tag() {
  }

  public Tag(Publicacion publicacion, String textoTag) {
    this.publicacion = publicacion;
    this.textoTag = textoTag;
  }

  public int getIdTag() {
    return idTag;
  }

  public void setIdTag(int idTag) {
    this.idTag = idTag;
  }

  public Publicacion getPublicacion() {
    return publicacion;
  }

  public void setPublicacion(Publicacion publicacion) {
    this.publicacion = publicacion;
  }

  public String getTextoTag() {
    return textoTag;
  }

  public void setTextoTag(String textoTag) {
    this.textoTag = textoTag;
  }
}
