package pl.arekn.oregano.migration;

import org.springframework.web.bind.annotation.*;
import pl.arekn.oregano.migration.history.HistoryLogger;
import pl.arekn.oregano.persistence.photo.Photo;
import pl.arekn.oregano.persistence.photo.PhotoRepository;

import java.util.List;

@RestController
@RequestMapping("photo")
public class PhotoMigrationController {

    private final static String CONTROLLER_DATA_TYPE = "Photo";

    private final PhotoRepository photoRepository;

    private final HistoryLogger historyLogger;

    public PhotoMigrationController(PhotoRepository photoRepository, HistoryLogger historyLogger) {
        this.photoRepository = photoRepository;
        this.historyLogger = historyLogger;
    }

    @PostMapping("/import")
    public void importPhotos(@RequestBody List<Photo> importedPhotos) {
        photoRepository.saveAll(importedPhotos);
        historyLogger.logImport(CONTROLLER_DATA_TYPE);
    }

    @GetMapping("/export")
    public Iterable<Photo> exportPhotos() {
        historyLogger.logExport(CONTROLLER_DATA_TYPE);
        return photoRepository.findAll();
    }
}
