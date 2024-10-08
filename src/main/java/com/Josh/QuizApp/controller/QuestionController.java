package com.Josh.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Josh.QuizApp.service.QuestionService;
import com.Josh.QuizApp.support.Question;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestons() {
		return questionService.getAllQuestions();
	}

	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCateory(category);
	}

	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);
	}

	@PutMapping("update/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question 	question) {
		return questionService.updateQuestion(id, question);
	}

}
