package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrosswordServiceImpl implements CrosswordService {

    private final String[] wordList;

    public CrosswordServiceImpl() throws IOException {
        this.wordList = loadFileContent();
    }

    @Override
    public String[] loadFileContent() throws IOException {
        ClassPathResource resource = new ClassPathResource("datasource/sorted_words_alpha_max15.txt");
        InputStreamReader reader = new InputStreamReader(resource.getInputStream());
        String fileContent = FileCopyUtils.copyToString(reader);
        return fileContent.split("\\r?\\n");
    }

    @Override
    public String buildString(List<String> letters) {
        StringBuilder sb = new StringBuilder();
        for (String letter : letters) {
            if (letter == null || letter.isBlank()) {
                sb.append("_");
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    @Override
    public int findLowerIndex(int value) {
        int min = 0;
        int max = wordList.length - 1;
        int index = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (value == wordList[mid].length()) {
                index = mid;
                max = mid - 1;
            }
            if (value < wordList[mid].length()) {
                max = mid - 1;
            }
            if (value > wordList[mid].length()) {
                min = mid + 1;
            }
        }
        return index;
    }

    @Override
    public int findUpperIndex(int value) {
        int min = 0;
        int max = wordList.length - 1;
        int index = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (value == wordList[mid].length()) {
                index = mid;
                min = mid + 1;
            }
            if (value < wordList[mid].length()) {
                max = mid - 1;
            }
            if (value > wordList[mid].length()) {
                min = mid + 1;
            }
        }
        return index;
    }

    @Override
    public List<String> findWords(int startIndex, int endIndex, String knownLetters) {
        List<String> foundWords = new ArrayList<>();
        List<Integer> knownIndices = new ArrayList<>();

        for (int i = 0; i < knownLetters.length(); i++) {
            if (knownLetters.charAt(i) != '_') {
                knownIndices.add(i);
            }
        }
        for (int i = startIndex; i < endIndex; i++) {
            boolean flag = true;
            for (int index : knownIndices) {
                if (knownLetters.charAt(index) != wordList[i].charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                foundWords.add(wordList[i]);
            }
        }
        return foundWords;
    }
}
