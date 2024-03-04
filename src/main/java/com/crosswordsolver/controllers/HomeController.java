package com.crosswordsolver.controllers;

import com.crosswordsolver.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/crossword-solver")
public class HomeController {

    private final CrosswordService crosswordService;

    @GetMapping("/home")
    public String displayCrosswordSolverHomePage() {
        return "home-view";
    }

    @PostMapping("/home")
    public String selectWordLength(@RequestParam(name = "wordLength", required = false) Integer wordLength,
                                   @RequestParam(name = "letters") List<String> letters, Model model) throws IOException {

        String[] wordList = crosswordService.loadFileContent();
        String inputString = crosswordService.buildString(letters);

        int lowerIndex = crosswordService.findLowerIndex(wordList, wordLength, 0, crosswordService.loadFileContent().length - 1);
        int upperIndex = crosswordService.findUpperIndex(wordList, wordLength, 0, crosswordService.loadFileContent().length - 1);

        List<String> result = crosswordService.findWords(wordList, lowerIndex, upperIndex, inputString);

        model.addAttribute("resultWords", result);

        return "home-view";
    }

}