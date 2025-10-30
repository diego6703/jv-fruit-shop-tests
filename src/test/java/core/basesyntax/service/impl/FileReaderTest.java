package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.service.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {
    private static final String MOCK_CSV_FILE_PATH = "src/test/resources/reportToRead.csv";
    private static final String WRONG_FILE_PATH = "srcreportToRead.csv";
    private static final String NO_FILE_PATH = "src/test/resources/reportToRead2.csv";
    private FileReader fileReader;

    @BeforeEach
    void initializeService() {
        fileReader = new FileReaderImpl();
    }

    @Test
    void save_existingPath_ok() {
        List<String> expected = new ArrayList<>();
        expected.add("b,banana,20");
        expected.add("s,banana,100");
        expected.add("p,banana,13");
        expected.add("p,banana,5");
        expected.add("s,banana,50");
        assertEquals(expected, fileReader.read(MOCK_CSV_FILE_PATH),
                "can't read existing file from proper path");
    }

    @Test
    void read_nonExistingFile_notOk() {
        List<String> expected = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> fileReader.read(NO_FILE_PATH),
                "not throwing error for non existing file");
    }

    @Test
    void read_wrongPath_notOk() {
        List<String> expected = new ArrayList<>();
        assertThrows(RuntimeException.class, () -> fileReader.read(WRONG_FILE_PATH),
                "not throwing error for non existing file");
    }
}
