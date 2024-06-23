package pe.edu.cibertec.T2_SW_AybarMarcial.model.bd;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAutor;

    @Column(name = "NomAutor")
    private String nomAutor;

    @Column(name = "ApeAutor")
    private String apeAutor;

    @Column(name = "FechNacAutor")
    @Temporal(TemporalType.DATE)
    private Date fechNacAutor;

    @OneToMany(mappedBy = "autor")
    private List<Publicacion> publicaciones;
}