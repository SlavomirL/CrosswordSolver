package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolverServiceImpl implements SolverService {

    private final CrosswordServiceImpl crosswordServiceImpl;

    @Override
    public List<String> solveCrossword(Integer wordLength, List<String> letters) {
        String inputString = crosswordServiceImpl.buildString(letters);
        int lowerIndex = crosswordServiceImpl.findLowerIndex(wordLength);
        int upperIndex = crosswordServiceImpl.findUpperIndex(wordLength);
        return crosswordServiceImpl.findWords(lowerIndex, upperIndex, inputString);
    }

}