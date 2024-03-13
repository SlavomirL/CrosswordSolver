package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface SolverService {

    List<String> solveCrossword(Integer wordLength, List<String> letters);

    List<String> buildWords(List<String> letters) throws IOException;

    List<String> removeBlanks(List<String> letters);

    List<String> buildAllWords(List<String> letters) throws IOException;

    List<String> toLowercase(List<String> letters);

    List<String> prepareLetters(List<String> letters);
}