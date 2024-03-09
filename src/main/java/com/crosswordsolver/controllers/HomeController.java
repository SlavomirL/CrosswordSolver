package com.crosswordsolver.controllers;

import com.crosswordsolver.services.CrosswordServiceImpl;
import com.crosswordsolver.services.SolverServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/words-solver")
public class HomeController {

    private final CrosswordServiceImpl crosswordServiceImpl;
    private final SolverServiceImpl solverServiceImpl;

    @GetMapping("/home")
    public String displayCrosswordSolverHomePage() {
        return "crossword-view";
    }

    @PostMapping("/crossword")
    public String selectWordLength(@RequestParam(name = "wordLength", required = false) Integer wordLength,
                                   @RequestParam(name = "letters") List<String> letters, Model model) throws IOException {

        List<String> result = solverServiceImpl.solveCrossword(wordLength, letters);

        model.addAttribute("resultWords", result);

        return "crossword-view";
    }

}