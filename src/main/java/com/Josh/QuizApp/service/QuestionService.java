package com.Josh.QuizApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Josh.QuizApp.dao.QuestionDao;
import com.Josh.QuizApp.support.Question;

@Service
public class QuestionService {
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
		return new ResponseEntity<> (questionDao.findAll(), HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCateory(String category) {
		try {
			return new ResponseEntity<> (questionDao.findByCategory(category), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.OK) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		try {
			questionDao.deleteById(id);
			return new ResponseEntity<>("Success", HttpStatus.OK) ;
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(Integer id, Question newQuestionData) {
		try {
	        Optional<Question> optionalQuestion = questionDao.findById(id);
	        if (optionalQuestion.isPresent()) {
	            Question existingQuestion = optionalQuestion.get();
	            
	            // Update only the fields that are provided in the newQuestionData
	            if (newQuestionData.getQuestionTitle() != null) {
	                existingQuestion.setQuestionTitle(newQuestionData.getQuestionTitle());
	            }
	            if (newQuestionData.getOption1() != null) {
	                existingQuestion.setOption1(newQuestionData.getOption1());
	            }
	            if (newQuestionData.getOption2() != null) {
	                existingQuestion.setOption2(newQuestionData.getOption2());
	            }
	            if (newQuestionData.getOption3() != null) {
	                existingQuestion.setOption3(newQuestionData.getOption3());
	            }
	            if (newQuestionData.getOption4() != null) {
	                existingQuestion.setOption4(newQuestionData.getOption4());
	            }
	            if (newQuestionData.getRightAnswer() != null) {
	                existingQuestion.setRightAnswer(newQuestionData.getRightAnswer());
	            }
	            if (newQuestionData.getDifficultyLevel() != null) {
	                existingQuestion.setDifficultyLevel(newQuestionData.getDifficultyLevel());
	            }
	            if (newQuestionData.getCategory() != null) {
	                existingQuestion.setCategory(newQuestionData.getCategory());
	            }
	            
	            questionDao.save(existingQuestion);
	            return new ResponseEntity<>("Question updated successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Question not found", HttpStatus.NOT_FOUND);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}

}
