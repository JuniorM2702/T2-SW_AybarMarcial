package pe.edu.cibertec.T2_SW_AybarMarcial.service;
//Aybar
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("uploads");

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        Files.copy(archivo.getInputStream(), this.pathFolder.resolve(archivo.getOriginalFilename()));
    }

    @Override
    public void guardarArchivos(List<MultipartFile> archivosList) throws Exception {
        for (MultipartFile archivo : archivosList) {
            this.guardarArchivo(archivo);
        }
    }

    @Override
    public void validarExtensiones(List<MultipartFile> archivosList) throws Exception {
        for (MultipartFile archivo : archivosList) {
            String extension = obtenerExtension(archivo);
            if (!extensionValida(extension)) {
                throw new Exception("Extensión inválida para el archivo: " + archivo.getOriginalFilename());
            }
        }
    }

    private String obtenerExtension(MultipartFile archivo) {
        String originalFileName = archivo.getOriginalFilename();
        return originalFileName != null ? originalFileName.substring(originalFileName.lastIndexOf(".") + 1) : "";
    }

    private boolean extensionValida(String extension) {
        return extension.equalsIgnoreCase("pdf") || extension.equalsIgnoreCase("png") || extension.equalsIgnoreCase("docx");
    }
}
