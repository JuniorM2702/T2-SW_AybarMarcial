package pe.edu.cibertec.T2_SW_AybarMarcial.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.T2_SW_AybarMarcial.model.bd.Autor;
import pe.edu.cibertec.T2_SW_AybarMarcial.repository.AutorRepository;

import java.util.List;
import java.util.Optional;
//Aybar
@AllArgsConstructor
@Service
public class AutorService implements IAutorService {
    private AutorRepository autorRepository;

    @Override
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public Optional<Autor> obtenerAutor(Integer id) {
        Optional<Autor> autor = autorRepository.findById(id);
        if(autor.isEmpty()){
            return Optional.empty();
        }
        return autor;
    }
}
