package ru.task3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.task3.models.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainClass {

    private final static String REPORT_PATH = "src/main/resources/report.json";

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Results results = objectMapper.readValue(new File(args[0]), Results.class);
        TestsData testsData = objectMapper.readValue(new File(args[1]), TestsData.class);
        Files.deleteIfExists(Paths.get(REPORT_PATH));
        List<Report> reportList = new ArrayList<>();
        for (Result result : results.getValues()) {
            Optional<Test> testOptional = testsData.getTests().stream().filter(test -> test.getId().equals(result.getId())).findAny();
            if (testOptional.isPresent()) {
                Test test = testOptional.get();
                reportList.add(new Report(test.getId(),
                        test.getTitle(),
                        test.getValue(),
                        test.getValues()));
            }
        }
        objectMapper.writeValue(new File(REPORT_PATH), reportList);
    }
}
