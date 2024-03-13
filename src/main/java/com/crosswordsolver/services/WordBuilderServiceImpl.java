package com.crosswordsolver.services;

import com.crosswordsolver.components.Trie;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WordBuilderServiceImpl implements WordBuilderService {

    private final Trie trie;
    private final FileReaderService fileReaderService;

    @Override
    public void populateTrie() throws IOException {
        String[] words = fileReaderService.loadFileContent();
        for (String w : words) {
            trie.insert(w.trim());
        }
    }

    @Override
    public List<String> findWords(List<String> letters) throws IOException {
        populateTrie();
        List<String> result = new ArrayList<>();
        findWordsUtil(letters, new ArrayList<>(), result);
        return result;
    }

    @Override
    public void findWordsUtil(List<String> remainingLetters, List<String> currentWord, List<String> result) {
        if (remainingLetters.isEmpty()) {
            String word = String.join("", currentWord);
            if (trie.search(word) && !result.contains(word)) {
                result.add(word);
            }
            return;
        }

        for (int i = 0; i < remainingLetters.size(); i++) {
            String letter = remainingLetters.get(i);
            currentWord.add(letter);
            List<String> newRemaining = new ArrayList<>(remainingLetters);
            newRemaining.remove(i);
            findWordsUtil(newRemaining, currentWord, result);
            currentWord.remove(currentWord.size() - 1);
        }
    }

}