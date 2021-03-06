package com.lmo.springboot.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lmo.springboot.configuration.BasicConfigurations;
import com.lmo.springboot.model.Question;
import com.lmo.springboot.model.Survey;
import com.lmo.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	@Autowired
	private BasicConfigurations configService;

	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveServeyQuestions(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addSurveyQuestions(@PathVariable String surveyId, @RequestBody Question newQuestion) {
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		if (question == null)
			return ResponseEntity.noContent().build();
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(question.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/surveys")
	public List<Survey> retrieveAllServeys() {
		return surveyService.retrieveAllSurveys();
	}

	@GetMapping("/surveys/{surveyId}/questions/{id}")
	public Question retrieveQuestion(@PathVariable String surveyId, @PathVariable("id") String questionId) {
		return surveyService.retrieveQuestion(surveyId, questionId);
	}

	@GetMapping("/dynamic-configs")
	public Map<String, Object> getDynamicConfigs() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", configService.getId());
		map.put("flag", configService.getFlag());
		map.put("value", configService.getValue());

		return map;
	}

}
