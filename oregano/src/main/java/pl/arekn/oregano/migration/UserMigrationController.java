package pl.arekn.oregano.migration;

import org.springframework.web.bind.annotation.*;
import pl.arekn.oregano.migration.history.HistoryLogger;
import pl.arekn.oregano.persistence.user.User;
import pl.arekn.oregano.persistence.user.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserMigrationController {

    private final static String CONTROLLER_DATA_TYPE = "User";

    private final UserRepository userRepository;

    private final HistoryLogger historyLogger;

    public UserMigrationController(UserRepository userRepository, HistoryLogger historyLogger) {
        this.userRepository = userRepository;
        this.historyLogger = historyLogger;
    }

    @PostMapping("/import")
    public void importUsers(@RequestBody List<User> importedUsers) {
        userRepository.saveAll(importedUsers);
        historyLogger.logImport(CONTROLLER_DATA_TYPE);
    }

    @GetMapping("/export")
    public Iterable<User> exportUsers() {
        historyLogger.logExport(CONTROLLER_DATA_TYPE);
        return userRepository.findAll();
    }
}
