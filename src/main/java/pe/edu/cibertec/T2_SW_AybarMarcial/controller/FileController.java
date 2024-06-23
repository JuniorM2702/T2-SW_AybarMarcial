package pe.edu.cibertec.T2_SW_AybarMarcial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.edu.cibertec.T2_SW_AybarMarcial.model.dto.ArchivoDto;
import pe.edu.cibertec.T2_SW_AybarMarcial.service.FileService;

import java.util.List;

@RestController
@RequestMapping("api/v1/files")
public class FileController {

    private final FileService fileService;

    @Value("${file.upload.max-size-mb}")
    private int maxFileSizeMb;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ArchivoDto> subirArchivos(
            @RequestParam("files") List<MultipartFile> multipartFileList
    ) {
        try {
            fileService.validarExtensiones(multipartFileList); //
            fileService.guardarArchivos(multipartFileList);
            return ResponseEntity.ok().body(ArchivoDto.builder()
                    .mensaje("Archivos subidos correctamente")
                    .build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ArchivoDto.builder()
                            .mensaje("Error al subir los archivos: " + e.getMessage())
                            .build());
        }
    }
}
