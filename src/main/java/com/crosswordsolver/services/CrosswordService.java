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
public class CrosswordService {

    public List<String> findPossibleWords(String knownLetters) {
        List<String> result = new ArrayList<>();
        return result;
    }

    public String[] loadFileContent() throws IOException {
        ClassPathResource resource = new ClassPathResource("datasource/sorted_words_alpha_max15.txt");
        InputStreamReader reader = new InputStreamReader(resource.getInputStream());
        String fileContent = FileCopyUtils.copyToString(reader);
        return fileContent.split("\\r?\\n");
    }

    public String buildString(List<String> letters) {
        StringBuilder sb = new StringBuilder();
        for (String letter : letters) {
            if (letter.equals(" ") || letter == null || letter.isBlank()) {
                sb.append("_");
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public int findLowerIndex(String[] input, int value, int min, int max) {
        int index = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (value == input[mid].length()) {
                index = mid;
                max = mid - 1;
            }
            if (value < input[mid].length()) {
                max = mid - 1;
            }
            if (value > input[mid].length()) {
                min = mid + 1;
            }
        }
        return index;
    }

    public int findUpperIndex(String[] input, int value, int min, int max) {
        int index = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (value == input[mid].length()) {
                index = mid;
                min = mid + 1;
            }
            if (value < input[mid].length()) {
                max = mid - 1;
            }
            if (value > input[mid].length()) {
                min = mid + 1;
            }
        }
        return index;
    }

    public List<String> findWords(String[] input, int startIndex, int endIndex, String knownLetters) {
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
                if (knownLetters.charAt(index) != input[i].charAt(index)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                foundWords.add(input[i]);
            }
        }
        return foundWords;
    }

}