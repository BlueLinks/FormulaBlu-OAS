import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Drivers API",
  version: "1.0.0",
  description: "API for managing Formula 1 drivers"
})
@server("http://localhost:8082", "Development server")
namespace DriversApi {
  
  @doc("Formula 1 Driver")
  model Driver {
    id: UUID;
    firstName: string;
    lastName: string;
    nationality: string;
    dateOfBirth: utcDateTime;
    isActive: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create driver request")
  model CreateDriverRequest {
    @minLength(1)
    @maxLength(50)
    firstName: string;
    
    @minLength(1)
    @maxLength(50)
    lastName: string;
    
    @minLength(2)
    @maxLength(3)
    nationality: string;
    
    dateOfBirth: utcDateTime;
  }

  @doc("Update driver request")
  model UpdateDriverRequest {
    @minLength(1)
    @maxLength(50)
    firstName?: string;
    
    @minLength(1)
    @maxLength(50)
    lastName?: string;
    
    @minLength(2)
    @maxLength(3)
    nationality?: string;
    
    dateOfBirth?: utcDateTime;
    isActive?: boolean;
  }

  @doc("Get driver by ID")
  @get
  @route("/api/drivers/{id}")
  op getDriver(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Driver;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new driver")
  @post
  @route("/api/drivers")
  op createDriver(
    @body body: CreateDriverRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Driver;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update driver")
  @put
  @route("/api/drivers/{id}")
  op updateDriver(
    @path id: UUID,
    @body body: UpdateDriverRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Driver;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete driver")
  @delete
  @route("/api/drivers/{id}")
  op deleteDriver(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}