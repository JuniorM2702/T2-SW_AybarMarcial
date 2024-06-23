package pe.edu.cibertec.T2_SW_AybarMarcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.T2_SW_AybarMarcial.model.bd.Publicacion;
import pe.edu.cibertec.T2_SW_AybarMarcial.service.IPublicacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/publicacion")
public class PublicacionController {

    private final IPublicacionService publicacionService;

    @Autowired
    public PublicacionController(IPublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }

    @GetMapping
    public List<Publicacion> listarPublicaciones() {
        return publicacionService.listarPublicaciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicacionPorId(@PathVariable Integer id) {
        Optional<Publicacion> publicacion = publicacionService.obtenerPublicacionxId(id);
        return publicacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Publicacion crearPublicacion(@RequestBody Publicacion publicacion) {
        return publicacionService.guardarPublicacion(publicacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publicacion> actualizarPublicacion(@PathVariable Integer id, @RequestBody Publicacion publicacion) {
        if (!publicacionService.obtenerPublicacionxId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        publicacion.setIdpublicacion(id);
        return ResponseEntity.ok(publicacionService.guardarPublicacion(publicacion));
    }
}
