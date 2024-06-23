package pe.edu.cibertec.T2_SW_AybarMarcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_AybarMarcial.model.bd.Autor;
import pe.edu.cibertec.T2_SW_AybarMarcial.service.IAutorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/autor")
public class AutorController {

    private final IAutorService autorService;

    @Autowired
    public AutorController(IAutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<Autor> listarAutores() {
        return autorService.listarAutores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtenerAutorPorId(@PathVariable Integer id) {
        Optional<Autor> autor = autorService.obtenerAutor(id);
        return autor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorService.guardarAutor(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizarAutor(@PathVariable Integer id, @RequestBody Autor autor) {
        if (!autorService.obtenerAutor(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        autor.setIdAutor(id);
        return ResponseEntity.ok(autorService.guardarAutor(autor));
    }
}
