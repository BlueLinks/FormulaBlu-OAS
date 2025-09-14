package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateResult422Response;
import com.formulablu.api.model.CreateResultRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Result;
import com.formulablu.api.model.UpdateResultRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface DefaultApi extends ApiClient.Api {


  /**
   * 
   * Create a new result
   * @param createResultRequest  (required)
   * @return Result
   */
  @RequestLine("POST /api/results")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Result createResult(@jakarta.annotation.Nonnull CreateResultRequest createResultRequest);

  /**
   * 
   * Similar to <code>createResult</code> but it also returns the http response headers .
   * Create a new result
   * @param createResultRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/results")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Result> createResultWithHttpInfo(@jakarta.annotation.Nonnull CreateResultRequest createResultRequest);



  /**
   * 
   * Delete result
   * @param id  (required)
   */
  @RequestLine("DELETE /api/results/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteResult(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteResult</code> but it also returns the http response headers .
   * Delete result
   * @param id  (required)
   */
  @RequestLine("DELETE /api/results/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteResultWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get result by ID
   * @param id  (required)
   * @return Result
   */
  @RequestLine("GET /api/results/{id}")
  @Headers({
    "Accept: application/json",
  })
  Result getResult(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getResult</code> but it also returns the http response headers .
   * Get result by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/results/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Result> getResultWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update result
   * @param id  (required)
   * @param updateResultRequest  (required)
   * @return Result
   */
  @RequestLine("PUT /api/results/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Result updateResult(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateResultRequest updateResultRequest);

  /**
   * 
   * Similar to <code>updateResult</code> but it also returns the http response headers .
   * Update result
   * @param id  (required)
   * @param updateResultRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/results/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Result> updateResultWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateResultRequest updateResultRequest);


}
