package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.FileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileWriterTest {
    private static final String EXISTING_FILE_PATH = "src/test/resources/finalReport.csv";
    private static final String NON_EXISTING_FILE_PATH =
            "src/test/resources/nonexistingdirectory/finalReport.csv";
    private FileWriter fileWriter;

    @BeforeEach
    void initializeService() {
        fileWriter = new FileWriterImpl();
    }

    @Test
    void write_existingPath_ok() {
        String report = "report";
        fileWriter.write(report, EXISTING_FILE_PATH);
    }

    @Test
    void write_nonExistingDirectory_notOk() {
        String report = "report";
        assertThrows(RuntimeException.class, () -> fileWriter.write(report, NON_EXISTING_FILE_PATH),
                "not throwing error for non existing directory");
    }

}
