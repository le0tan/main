package seedu.algobase.integration;

import static seedu.algobase.integration.IntegrationTestUtil.getTempFilePath;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import seedu.algobase.logic.LogicManager;
import seedu.algobase.logic.commands.exceptions.CommandException;
import seedu.algobase.logic.parser.exceptions.ParseException;
import seedu.algobase.model.ModelManager;
import seedu.algobase.model.ReadOnlyAlgoBase;
import seedu.algobase.model.UserPrefs;
import seedu.algobase.model.util.SampleDataUtil;
import seedu.algobase.storage.JsonAlgoBaseStorage;
import seedu.algobase.storage.JsonUserPrefsStorage;
import seedu.algobase.storage.StorageManager;

public class AddPlanCommandIntegrationTest {
    // --- COPY BELOW FOR INTEGRATION TESTS ----------------------------------------------------------------

    @TempDir
    public Path testFolder;

    private StorageManager storageManager;
    private ModelManager modelManager;
    private LogicManager logicManager;

    @BeforeEach
    public void setup() {
        ReadOnlyAlgoBase sampleAlgoBase = SampleDataUtil.getSampleAlgoBase();
        JsonAlgoBaseStorage algoBaseStorage = new JsonAlgoBaseStorage(getTempFilePath(testFolder, "ab"));
        JsonUserPrefsStorage userPrefsStorage = new JsonUserPrefsStorage(getTempFilePath(testFolder, "prefs"));
        storageManager = new StorageManager(algoBaseStorage, userPrefsStorage);
        modelManager = new ModelManager(sampleAlgoBase, new UserPrefs());
        logicManager = new LogicManager(modelManager, storageManager);
    }

    // --- COPY ABOVE FOR INTEGRATION TESTS ----------------------------------------------------------------

    @Test
    public void addplan_allConstraints() throws CommandException, ParseException {
        logicManager.execute("addplan n/test d/test start/2019-01-01 end/2019-01-01\n");
        logicManager.execute("addplan n/test1 d/test start/2018-01-01 end/2018-02-28\n");
    }
}