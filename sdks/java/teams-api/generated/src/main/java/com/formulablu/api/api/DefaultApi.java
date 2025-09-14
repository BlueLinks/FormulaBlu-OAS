package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateTeam422Response;
import com.formulablu.api.model.CreateTeamRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Team;
import com.formulablu.api.model.UpdateTeamRequest;

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
   * Create a new team
   * @param createTeamRequest  (required)
   * @return Team
   */
  @RequestLine("POST /api/teams")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Team createTeam(@jakarta.annotation.Nonnull CreateTeamRequest createTeamRequest);

  /**
   * 
   * Similar to <code>createTeam</code> but it also returns the http response headers .
   * Create a new team
   * @param createTeamRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/teams")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Team> createTeamWithHttpInfo(@jakarta.annotation.Nonnull CreateTeamRequest createTeamRequest);



  /**
   * 
   * Delete team
   * @param id  (required)
   */
  @RequestLine("DELETE /api/teams/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteTeam(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteTeam</code> but it also returns the http response headers .
   * Delete team
   * @param id  (required)
   */
  @RequestLine("DELETE /api/teams/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteTeamWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get team by ID
   * @param id  (required)
   * @return Team
   */
  @RequestLine("GET /api/teams/{id}")
  @Headers({
    "Accept: application/json",
  })
  Team getTeam(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getTeam</code> but it also returns the http response headers .
   * Get team by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/teams/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Team> getTeamWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update team
   * @param id  (required)
   * @param updateTeamRequest  (required)
   * @return Team
   */
  @RequestLine("PUT /api/teams/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Team updateTeam(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateTeamRequest updateTeamRequest);

  /**
   * 
   * Similar to <code>updateTeam</code> but it also returns the http response headers .
   * Update team
   * @param id  (required)
   * @param updateTeamRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/teams/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Team> updateTeamWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateTeamRequest updateTeamRequest);


}
