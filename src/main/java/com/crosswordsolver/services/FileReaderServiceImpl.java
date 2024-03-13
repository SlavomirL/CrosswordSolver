package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;

@Service
@RequiredArgsConstructor
public class FileReaderServiceImpl implements FileReaderService {

    private final static String FILE_PATH = "datasource/sorted_words_alpha_max15.txt";

    @Override
    public String[] loadFileContent() throws IOException {
        ClassPathResource resource = new ClassPathResource(FILE_PATH);
        InputStreamReader reader = new InputStreamReader(resource.getInputStream());
        String fileContent = FileCopyUtils.copyToString(reader);
        return fileContent.split("\\r?\\n");
    }

}