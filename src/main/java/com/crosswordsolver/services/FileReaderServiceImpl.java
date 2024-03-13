package com.crosswordsolver.services;

import com.crosswordsolver.components.Trie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FileReaderServiceImpl implements FileReaderService {

    private final Trie trie;

    @Autowired
    public FileReaderServiceImpl(Trie trie) {
        this.trie = trie;
        try {
            ClassPathResource resource = new ClassPathResource("datasource/sorted_words_alpha_max15.txt");
            InputStreamReader reader = new InputStreamReader(resource.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                trie.insert(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}