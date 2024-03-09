package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface CrosswordService {

    String[] loadFileContent() throws IOException;

    String buildString(List<String> letters);

    int findLowerIndex(int value);

    int findUpperIndex(int value);

    List<String> findWords(int startIndex, int endIndex, String knownLetters);

}