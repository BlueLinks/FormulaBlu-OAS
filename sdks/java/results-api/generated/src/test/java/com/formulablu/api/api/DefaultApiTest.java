package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.model.CreateResult422Response;
import com.formulablu.api.model.CreateResultRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Result;
import com.formulablu.api.model.UpdateResultRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

/**
 * API tests for DefaultApi
 */
class DefaultApiTest {

    private DefaultApi api;

    @BeforeEach
    public void setup() {
        api = new ApiClient().buildClient(DefaultApi.class);
    }

    
    /**
     * 
     *
     * Create a new result
     */
    @Test
    void createResultTest() {
        CreateResultRequest createResultRequest = null;
        // Result response = api.createResult(createResultRequest);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Delete result
     */
    @Test
    void deleteResultTest() {
        String id = null;
        // api.deleteResult(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Get result by ID
     */
    @Test
    void getResultTest() {
        String id = null;
        // Result response = api.getResult(id);

        // TODO: test validations
    }

    
    /**
     * 
     *
     * Update result
     */
    @Test
    void updateResultTest() {
        String id = null;
        UpdateResultRequest updateResultRequest = null;
        // Result response = api.updateResult(id, updateResultRequest);

        // TODO: test validations
    }

    
}
