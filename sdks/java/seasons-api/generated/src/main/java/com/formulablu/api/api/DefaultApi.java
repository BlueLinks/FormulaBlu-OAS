package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateSeason422Response;
import com.formulablu.api.model.CreateSeasonRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Season;
import com.formulablu.api.model.UpdateSeasonRequest;

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
   * Create a new season
   * @param createSeasonRequest  (required)
   * @return Season
   */
  @RequestLine("POST /api/seasons")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Season createSeason(@jakarta.annotation.Nonnull CreateSeasonRequest createSeasonRequest);

  /**
   * 
   * Similar to <code>createSeason</code> but it also returns the http response headers .
   * Create a new season
   * @param createSeasonRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seasons")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Season> createSeasonWithHttpInfo(@jakarta.annotation.Nonnull CreateSeasonRequest createSeasonRequest);



  /**
   * 
   * Delete season
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seasons/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteSeason(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteSeason</code> but it also returns the http response headers .
   * Delete season
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seasons/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteSeasonWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get season by ID
   * @param id  (required)
   * @return Season
   */
  @RequestLine("GET /api/seasons/{id}")
  @Headers({
    "Accept: application/json",
  })
  Season getSeason(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getSeason</code> but it also returns the http response headers .
   * Get season by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seasons/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Season> getSeasonWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update season
   * @param id  (required)
   * @param updateSeasonRequest  (required)
   * @return Season
   */
  @RequestLine("PUT /api/seasons/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Season updateSeason(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateSeasonRequest updateSeasonRequest);

  /**
   * 
   * Similar to <code>updateSeason</code> but it also returns the http response headers .
   * Update season
   * @param id  (required)
   * @param updateSeasonRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/seasons/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Season> updateSeasonWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateSeasonRequest updateSeasonRequest);


}
