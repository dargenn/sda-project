package io.dargenn.quizhouse.survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SurveyController {
    private final SurveyService surveyService;

    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping(value = "/surveys")
    public String init(Model model) {
        model.addAttribute("surveys", surveyService.findAll());
        model.addAttribute("survey", new Survey());
        return "surveys";
    }

    @PostMapping(value = "/surveys/add")
    public String saveSurvey(Survey survey, Model model) {
        surveyService.save(survey);
        return init(model);
    }
}
