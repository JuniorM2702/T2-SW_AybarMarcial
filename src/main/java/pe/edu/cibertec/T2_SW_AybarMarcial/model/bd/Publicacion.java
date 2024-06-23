package pe.edu.cibertec.T2_SW_AybarMarcial.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idpublicacion;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "resumen")
    private String resumen;

    @Column(name = "fechpublicacion")
    private Date fechPublicacion;

    @ManyToOne
    @JsonIgnoreProperties("publicaciones")
    @JoinColumn(name = "idautor")
    private Autor autor;
}