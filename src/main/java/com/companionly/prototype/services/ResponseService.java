package com.companionly.prototype.services;

import com.companionly.prototype.models.Response;
import com.companionly.prototype.data.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepository responseRepository;

    public void saveResponses(List<Response> responses) {
        responseRepository.saveAll(responses);
    }

    public List<Response> getResponsesByUser(String username) {
        return responseRepository.findByUsername(username);
    }
}
