package pe.edu.cibertec.T2_SW_AybarMarcial.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "Publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;

    @Column(name = "Titulo")
    private String titulo;

    @Column(name = "Resumen")
    private String resumen;

    @Column(name = "FechPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechPublicacion;

    @ManyToOne
    @JoinColumn(name = "IdAutor")
    private Autor autor;
}