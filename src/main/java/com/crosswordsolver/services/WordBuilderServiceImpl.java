package com.crosswordsolver.services;

import com.crosswordsolver.components.Trie;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordBuilderServiceImpl implements WordBuilderService {

    private Trie trie;
    private String[] wordList;

    public WordBuilderServiceImpl(List<String> words) throws IOException {
        trie = new Trie();
        wordList = loadFileContent();
        for (String word : words) {
            trie.insert(word);
        }
    }

    @Override
    public String[] loadFileContent() throws IOException {
        ClassPathResource resource = new ClassPathResource("datasource/sorted_words_alpha_max15.txt");
        InputStreamReader reader = new InputStreamReader(resource.getInputStream());
        String fileContent = FileCopyUtils.copyToString(reader);
        return fileContent.split("\\r?\\n");
    }

    @Override
    public List<String> findWords(List<String> letters) {
        List<String> result = new ArrayList<>();
        backtrack(letters, 0, new StringBuilder(), result);
        return result;
    }


    @Override
    public void backtrack(List<String> letters, int index, StringBuilder path, List<String> result) {
        int wordLength = letters.size();
        if (path.length() == wordLength) {
            if (trie.search(path.toString())) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = index; i < letters.size(); i++) {
            path.append(letters.get(i));
            backtrack(letters, i + 1, path, result);
            path.deleteCharAt(path.length() - 1); // Backtrack
        }
    }

}