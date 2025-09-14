package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateRace422Response;
import com.formulablu.api.model.CreateRaceRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Race;
import com.formulablu.api.model.UpdateRaceRequest;

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
   * Create a new race
   * @param createRaceRequest  (required)
   * @return Race
   */
  @RequestLine("POST /api/races")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Race createRace(@jakarta.annotation.Nonnull CreateRaceRequest createRaceRequest);

  /**
   * 
   * Similar to <code>createRace</code> but it also returns the http response headers .
   * Create a new race
   * @param createRaceRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/races")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Race> createRaceWithHttpInfo(@jakarta.annotation.Nonnull CreateRaceRequest createRaceRequest);



  /**
   * 
   * Delete race
   * @param id  (required)
   */
  @RequestLine("DELETE /api/races/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteRace(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteRace</code> but it also returns the http response headers .
   * Delete race
   * @param id  (required)
   */
  @RequestLine("DELETE /api/races/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteRaceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get race by ID
   * @param id  (required)
   * @return Race
   */
  @RequestLine("GET /api/races/{id}")
  @Headers({
    "Accept: application/json",
  })
  Race getRace(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getRace</code> but it also returns the http response headers .
   * Get race by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/races/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Race> getRaceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update race
   * @param id  (required)
   * @param updateRaceRequest  (required)
   * @return Race
   */
  @RequestLine("PUT /api/races/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Race updateRace(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateRaceRequest updateRaceRequest);

  /**
   * 
   * Similar to <code>updateRace</code> but it also returns the http response headers .
   * Update race
   * @param id  (required)
   * @param updateRaceRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/races/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Race> updateRaceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateRaceRequest updateRaceRequest);


}
