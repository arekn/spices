package pl.arekn.oregano.migration.history;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.arekn.oregano.persistence.history.History;
import pl.arekn.oregano.persistence.history.HistoryRepository;

@RestController
@RequestMapping("history")
public class MigrationHistoryController {

    private final HistoryRepository historyRepository;

    public MigrationHistoryController(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @GetMapping
    public Iterable<History> getAllHistory() {
        return historyRepository.findAll();
    }
}
