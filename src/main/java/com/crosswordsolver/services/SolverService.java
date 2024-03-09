package com.crosswordsolver.services;

import java.util.List;

public interface SolverService {

    List<String> solveCrossword(Integer wordLength, List<String> letters);

}