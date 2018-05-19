package pl.arekn.oregano.migration;

import org.springframework.web.bind.annotation.*;
import pl.arekn.oregano.migration.history.HistoryLogger;
import pl.arekn.oregano.persistence.album.Album;
import pl.arekn.oregano.persistence.album.AlbumRepository;

import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumMigrationController {

    private final static String CONTROLLER_DATA_TYPE = "Album";

    private final HistoryLogger historyLogger;

    private final AlbumRepository albumRepository;

    public AlbumMigrationController(AlbumRepository albumRepository, HistoryLogger historyLogger) {
        this.albumRepository = albumRepository;
        this.historyLogger = historyLogger;
    }

    @PostMapping("/import")
    public void importAlbums(@RequestBody List<Album> importedAlbums) {
        albumRepository.saveAll(importedAlbums);
        historyLogger.logImport(CONTROLLER_DATA_TYPE);
    }

    @GetMapping("/export")
    public Iterable<Album> exportAlbums() {
        historyLogger.logExport(CONTROLLER_DATA_TYPE);
        return albumRepository.findAll();
    }
}
