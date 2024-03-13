package com.crosswordsolver.services;

import java.io.IOException;
import java.util.List;

public interface SolverService {

    List<String> solveCrossword(Integer wordLength, List<String> letters);

    List<String> buildWord(List<String> letters) throws IOException;

    List<String> removeBlanks(List<String> letters);

}