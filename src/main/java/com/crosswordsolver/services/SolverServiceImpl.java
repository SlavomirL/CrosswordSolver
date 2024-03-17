package com.crosswordsolver.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolverServiceImpl implements SolverService {

    private final CrosswordService crosswordService;
    private final WordBuilderService wordBuilderService;

    @Override
    public List<String> solveCrossword(Integer wordLength, List<String> letters) {
        List<String> allLowercase = lettersToLowerCase(letters);
        String inputString = crosswordService.buildString(allLowercase);
        int lowerIndex = crosswordService.findLowerIndex(wordLength);
        int upperIndex = crosswordService.findUpperIndex(wordLength);
        List<String> unfinishedResult = crosswordService.findWords(lowerIndex, upperIndex, inputString);
        return prepareOutput(unfinishedResult);
    }

    @Override
    public List<String> buildWords(List<String> letters) throws IOException {
        List<String> onlyLetters = prepareInput(letters);
        List<String> unfinishedResult = wordBuilderService.findWords(onlyLetters);
        return prepareOutput(unfinishedResult);
    }

    @Override
    public List<String> buildAllWords(List<String> letters) throws IOException {
        List<String> onlyLetters = prepareInput(letters);
        List<String> unfinishedResult = wordBuilderService.findAllWords(onlyLetters);
        return prepareOutput(unfinishedResult);
    }

    @Override
    public List<String> removeBlanks(List<String> letters) {
        Iterator<String> iterator = letters.iterator();
        while (iterator.hasNext()) {
            String letter = iterator.next();
            if (letter.isBlank()) {
                iterator.remove();
            }
        }
        return letters;
    }

    @Override
    public List<String> lettersToLowerCase(List<String> letters) {
        letters.replaceAll(String::toLowerCase);
        return letters;
    }

    @Override
    public List<String> prepareInput(List<String> letters) {
        List<String> noBlanks = removeBlanks(letters);
        return lettersToLowerCase(noBlanks);
    }

    @Override
    public List<String> prepareOutput(List<String> words) {
        return sortOutput(wordsToUpperCase(words));
    }

    @Override
    public List<String> wordsToUpperCase(List<String> words) {
        words.replaceAll(String::toUpperCase);
        return words;
    }

    @Override
    public List<String> sortOutput(List<String> words) {
        words.sort(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()));
        return words;
    }

}