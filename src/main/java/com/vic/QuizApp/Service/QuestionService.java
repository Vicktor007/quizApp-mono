package com.vic.QuizApp.Service;

import com.vic.QuizApp.Dao.QuestionDao;
import com.vic.QuizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity< List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
       return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionsByCategory(String category) {

        return questionDao.findQuestionByCategory(category);
    }


    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public void deleteQuestion(Integer id) {
       questionDao.deleteById(id);
    }

//    public String updateQuestion(Integer id) {
//        return questionDao.save(id);
//    }
}
//@PutMapping("update/{id}")
//public ResponseEntity<String> updateQuestion(@PathVariable Integer id) {
//    boolean isUpdated = questionService.updateQuestion(id);
//    if (isUpdated) {
//        return ResponseEntity.ok("Question updated successfully");
//    } else {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
//    }
//}
//
//// In your service layer
//public boolean updateQuestion(Integer id) {
//    Optional<Question> question = questionDao.findById(id);
//    if (question.isPresent()) {
//        questionDao.save(question.get());
//        return true;
//    } else {
//        return false;
//    }
//}
