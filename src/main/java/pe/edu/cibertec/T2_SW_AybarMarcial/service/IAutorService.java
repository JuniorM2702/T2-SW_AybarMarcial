package pe.edu.cibertec.T2_SW_AybarMarcial.service;

import pe.edu.cibertec.T2_SW_AybarMarcial.model.bd.Autor;

import java.util.List;
import java.util.Optional;

public interface IAutorService {
    List<Autor> listarAutores();
    Autor guardarAutor(Autor autor);
    Optional<Autor> obtenerAutor(Integer id);
}
