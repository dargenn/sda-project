package io.dargenn.quizhouse.survey;

import io.dargenn.quizhouse.question.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
    private final SurveyService surveyService;
    private final QuestionService questionService;

    public SurveyController(SurveyService surveyService, QuestionService questionService) {
        this.surveyService = surveyService;
        this.questionService = questionService;
    }

    @GetMapping(value = "/surveys")
    public String init(Model model) {
        model.addAttribute("surveys", surveyService.findAll());
        model.addAttribute("survey", new Survey());
        model.addAttribute("questions", questionService.findAll());
        return "surveys";
    }

    @PostMapping(value = "/surveys/add")
    public String saveSurvey(Survey survey, Model model) {
        surveyService.save(survey);
        return init(model);
    }

    @PostMapping(value = "/surveys/addQuestion/{id}")
    public String addQuestionToSurvey(@PathVariable Long id, @RequestParam(value = "questionId") Long questionId, Model model) {
        Survey survey = surveyService.findById(id);
        survey.getQuestions().add(questionService.findById(questionId));
        surveyService.save(survey);
        return init(model);
    }
}
