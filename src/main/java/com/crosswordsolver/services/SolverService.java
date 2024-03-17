package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface SolverService {

    List<String> solveCrossword(Integer wordLength, List<String> letters);

    List<String> buildWords(List<String> letters) throws IOException;

    List<String> removeBlanks(List<String> letters);

    List<String> buildAllWords(List<String> letters) throws IOException;

    List<String> lettersToLowerCase(List<String> letters);

    List<String> prepareOutput(List<String> words);

    List<String> wordsToUpperCase(List<String> words);

    List<String> prepareInput(List<String> letters);

    List<String> sortOutput(List<String> words);
}