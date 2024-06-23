package pe.edu.cibertec.T2_SW_AybarMarcial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.T2_SW_AybarMarcial.model.bd.Autor;
@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
