package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface WordBuilderService {

    void populateTrie() throws IOException;

    List<String> findWords(List<String> letters) throws IOException;

    List<String> findAllWords(List<String> letters);

    void findWordsUtil(List<String> remainingLetters, List<String> currentWord, List<String> result);

    void findAllWordsUtil(List<String> remainingLetters, List<String> currentWord, List<String> result);
}