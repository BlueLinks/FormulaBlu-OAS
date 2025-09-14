package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateEvent422Response;
import com.formulablu.api.model.CreateEventRequest;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.Event;
import com.formulablu.api.model.UpdateEventRequest;

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
   * Create a new event
   * @param createEventRequest  (required)
   * @return Event
   */
  @RequestLine("POST /api/events")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Event createEvent(@jakarta.annotation.Nonnull CreateEventRequest createEventRequest);

  /**
   * 
   * Similar to <code>createEvent</code> but it also returns the http response headers .
   * Create a new event
   * @param createEventRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/events")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Event> createEventWithHttpInfo(@jakarta.annotation.Nonnull CreateEventRequest createEventRequest);



  /**
   * 
   * Delete event
   * @param id  (required)
   */
  @RequestLine("DELETE /api/events/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteEvent(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteEvent</code> but it also returns the http response headers .
   * Delete event
   * @param id  (required)
   */
  @RequestLine("DELETE /api/events/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteEventWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get event by ID
   * @param id  (required)
   * @return Event
   */
  @RequestLine("GET /api/events/{id}")
  @Headers({
    "Accept: application/json",
  })
  Event getEvent(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getEvent</code> but it also returns the http response headers .
   * Get event by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/events/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Event> getEventWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update event
   * @param id  (required)
   * @param updateEventRequest  (required)
   * @return Event
   */
  @RequestLine("PUT /api/events/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Event updateEvent(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateEventRequest updateEventRequest);

  /**
   * 
   * Similar to <code>updateEvent</code> but it also returns the http response headers .
   * Update event
   * @param id  (required)
   * @param updateEventRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/events/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Event> updateEventWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateEventRequest updateEventRequest);


}
