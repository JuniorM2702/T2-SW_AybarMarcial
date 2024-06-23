package pe.edu.cibertec.T2_SW_AybarMarcial.model.bd;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idautor;

    @Column(name = "nomautor")
    private String nomAutor;

    @Column(name = "apeautor")
    private String apeAutor;

    @Column(name = "fechnacautor")
    private Date fechNacAutor;

    @OneToMany(mappedBy = "autor")
    @JsonIgnoreProperties("autor")
    private List<Publicacion> publicaciones;


}