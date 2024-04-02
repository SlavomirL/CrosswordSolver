package com.crosswordsolver.controllers;

import com.crosswordsolver.services.SolverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final SolverService solverService;

    @GetMapping({"/home", "/"})
    public String displayCrosswordSolverHomePage() {
        return "home-view";
    }

    @GetMapping("/crossword")
    public String getCrosswordView() {
        return "crossword-view";
    }

    @PostMapping("/crossword")
    public String crosswordWordLength(@RequestParam(name = "wordLength", required = false) Integer wordLength,
                                      @RequestParam(name = "letters") List<String> letters, Model model) {
        List<String> crosswordResult = solverService.solveCrossword(wordLength, letters);

        model.addAttribute("crosswordResult", crosswordResult);

        return "crossword-view";
    }

    @GetMapping("/word-builder")
    public String getBuilderView() {
        return "word-builder-view";
    }

    @PostMapping("/word-builder")
    public String wordBuilderWordLength(@RequestParam(name = "letters") List<String> letters, Model model) throws IOException {
        List<String> builderResult = solverService.buildWords(letters);

        model.addAttribute("builderResult", builderResult);

        return "word-builder-view";
    }

    @GetMapping("/all-word-builder")
    public String getAllBuilderView() {
        return "all-word-builder-view";
    }

    @PostMapping("/all-word-builder")
    public String allWordBuilderWordLength(@RequestParam(name = "letters") List<String> letters, Model model) throws IOException {
        List<String> builderResult = solverService.buildAllWords(letters);

        model.addAttribute("builderResult", builderResult);

        return "all-word-builder-view";
    }

}