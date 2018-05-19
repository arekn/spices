package pl.arekn.oregano.migration.history;

import org.springframework.stereotype.Service;
import pl.arekn.oregano.persistence.history.History;
import pl.arekn.oregano.persistence.history.HistoryRepository;

import java.time.Instant;

@Service
public class HistoryLogger {

    private final HistoryRepository historyRepository;

    public HistoryLogger(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    private void log(String dataType, MigrationType migrationType){
        History history = History.builder()
                .dataType(dataType)
                .timestamp(Instant.now())
                .migrationType(migrationType)
                .build();
        historyRepository.save(history);
    }

    public void logImport(String dataType){
        this.log(dataType, MigrationType.IMPORT);
    }

    public void logExport(String dataType){
        this.log(dataType, MigrationType.EXPORT);
    }
}
