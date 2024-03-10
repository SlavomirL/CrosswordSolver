package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolverServiceImpl implements SolverService {

    private final CrosswordService crosswordService;
    private final WordBuilderService wordBuilderService;

    @Override
    public List<String> solveCrossword(Integer wordLength, List<String> letters) {
        String inputString = crosswordService.buildString(letters);
        int lowerIndex = crosswordService.findLowerIndex(wordLength);
        int upperIndex = crosswordService.findUpperIndex(wordLength);
        return crosswordService.findWords(lowerIndex, upperIndex, inputString);
    }

    @Override
    public List<String> buildWord(List<String> letters) {
        System.out.println("this is invoked");
        System.out.println(letters.toString());
        return wordBuilderService.findWords(letters);
    }

}