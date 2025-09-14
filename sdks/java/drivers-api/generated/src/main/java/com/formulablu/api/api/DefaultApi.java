package com.formulablu.api.api;

import com.formulablu.api.ApiClient;
import com.formulablu.api.EncodingUtils;
import com.formulablu.api.model.ApiResponse;

import com.formulablu.api.model.CreateDriver422Response;
import com.formulablu.api.model.CreateDriverRequest;
import com.formulablu.api.model.Driver;
import com.formulablu.api.model.Error;
import com.formulablu.api.model.UpdateDriverRequest;

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
   * Create a new driver
   * @param createDriverRequest  (required)
   * @return Driver
   */
  @RequestLine("POST /api/drivers")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Driver createDriver(@jakarta.annotation.Nonnull CreateDriverRequest createDriverRequest);

  /**
   * 
   * Similar to <code>createDriver</code> but it also returns the http response headers .
   * Create a new driver
   * @param createDriverRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/drivers")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Driver> createDriverWithHttpInfo(@jakarta.annotation.Nonnull CreateDriverRequest createDriverRequest);



  /**
   * 
   * Delete driver
   * @param id  (required)
   */
  @RequestLine("DELETE /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteDriver(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>deleteDriver</code> but it also returns the http response headers .
   * Delete driver
   * @param id  (required)
   */
  @RequestLine("DELETE /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Get driver by ID
   * @param id  (required)
   * @return Driver
   */
  @RequestLine("GET /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  Driver getDriver(@Param("id") @jakarta.annotation.Nonnull String id);

  /**
   * 
   * Similar to <code>getDriver</code> but it also returns the http response headers .
   * Get driver by ID
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Driver> getDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id);



  /**
   * 
   * Update driver
   * @param id  (required)
   * @param updateDriverRequest  (required)
   * @return Driver
   */
  @RequestLine("PUT /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  Driver updateDriver(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateDriverRequest updateDriverRequest);

  /**
   * 
   * Similar to <code>updateDriver</code> but it also returns the http response headers .
   * Update driver
   * @param id  (required)
   * @param updateDriverRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: application/json",
  })
  ApiResponse<Driver> updateDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull String id, @jakarta.annotation.Nonnull UpdateDriverRequest updateDriverRequest);


}
