package edu.com.isa.mbing.entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "publicacion")
@NamedQuery(name="Publicacion.getPublicacionsByPublicador_IdPublicador",
query = "FROM Publicacion WHERE publicador.idPublicador =?1")
public class Publicacion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int idPublicacion;

  //  @JsonIgnore
  @ManyToOne// Muchas publicaciones son de un publicador
  @JoinColumn(name ="id_publicador", nullable = false) // creo registro en BD
  private Publicador publicador; //private int idPublicador;

  // @JsonIgnore // si descomento tengo que escribir yo la fecha
  @JsonSerialize(using = ToStringSerializer.class)// te pasa automaticamente la fecha
  @Column(name = "fecha")
  private LocalDate fecha;


  @Column(name = "cuerpo", nullable = false, length = 250)
  private String cuerpo;

  @JsonIgnore
  @OneToMany(mappedBy = "publicacion", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Tag> tags;

  @JsonIgnore
  @OneToMany(mappedBy = "publicacion", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Mencion> mencions;

  public Publicacion() {
  }

  public int getIdPublicacion() {
    return idPublicacion;
  }

  public void setIdPublicacion(int idPublicacion) {
    this.idPublicacion = idPublicacion;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public void setFecha(LocalDate fecha) {
    this.fecha = fecha;
  }

  public Publicador getPublicador() {
    return publicador;
  }

  public void setPublicador(Publicador publicador) {
    this.publicador = publicador;
  }

  public String getCuerpo() {
    return cuerpo;
  }

  public void setCuerpo(String cuerpo) {
    this.cuerpo = cuerpo;
  }

  public List<Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  public List<Mencion> getMencions() {
    return mencions;
  }

  public void setMencions(List<Mencion> mencions) {
    this.mencions = mencions;
  }
}
