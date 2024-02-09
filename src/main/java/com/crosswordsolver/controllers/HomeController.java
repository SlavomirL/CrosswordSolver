package com.crosswordsolver.controllers;

import com.crosswordsolver.services.CrosswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                                   @RequestParam(name = "letters") List<String> letters, RedirectAttributes redirectAttributes) {

        String concatenatedString = crosswordService.testMethodConcat(letters);
        System.out.println("concatenatedString = " + concatenatedString);
        redirectAttributes.addFlashAttribute("stringToShow", concatenatedString);


        return "redirect:/crossword-solver/home";
    }

}