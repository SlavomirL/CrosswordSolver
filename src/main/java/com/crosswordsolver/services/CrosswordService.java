package com.crosswordsolver.services;

import java.util.List;

public interface CrosswordService {

    String buildString(List<String> letters);

    int findLowerIndex(int value);

    int findUpperIndex(int value);

    List<String> findWords(int startIndex, int endIndex, String knownLetters);

}