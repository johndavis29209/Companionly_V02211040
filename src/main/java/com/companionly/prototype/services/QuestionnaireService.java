package com.companionly.prototype.services;

import com.companionly.prototype.models.Questionnaire;
import com.companionly.prototype.data.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireService {

    @Autowired
    private QuestionnaireRepository repository;

    public List<Questionnaire> getAllQuestions() {
        return repository.findAll();
    }
}