package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateTrack422Response;
import com.formulablu.api.model.CreateTrackRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Track;
import com.formulablu.api.model.UpdateTrackRequest;

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
   * Create a new track
   * @param createTrackRequest  (required)
   * @return Track
   */
  @RequestLine("POST /api/tracks")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Track createTrack(@jakarta.annotation.Nonnull CreateTrackRequest createTrackRequest);

  /**
   * 
   * Similar to <code>createTrack</code> but it also returns the http response headers .
   * Create a new track
   * @param createTrackRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/tracks")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Track> createTrackWithHttpInfo(@jakarta.annotation.Nonnull CreateTrackRequest createTrackRequest);



  /**
   * 
   * Delete track
   * @param id  (required)
   */
  @RequestLine("DELETE /api/tracks/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteTrack(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteTrack</code> but it also returns the http response headers .
   * Delete track
   * @param id  (required)
   */
  @RequestLine("DELETE /api/tracks/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteTrackWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get track by ID
   * @param id  (required)
   * @return Track
   */
  @RequestLine("GET /api/tracks/{id}")
  @Headers({
    "Accept: application/json",
  })
  Track getTrack(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getTrack</code> but it also returns the http response headers .
   * Get track by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/tracks/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Track> getTrackWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update track
   * @param id  (required)
   * @param updateTrackRequest  (required)
   * @return Track
   */
  @RequestLine("PUT /api/tracks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Track updateTrack(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateTrackRequest updateTrackRequest);

  /**
   * 
   * Similar to <code>updateTrack</code> but it also returns the http response headers .
   * Update track
   * @param id  (required)
   * @param updateTrackRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/tracks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Track> updateTrackWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateTrackRequest updateTrackRequest);


}
