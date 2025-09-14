import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Results API",
  version: "1.0.0",
  description: "API for managing Formula 1 race results"
})
@server("http://localhost:8088", "Development server")
namespace ResultsApi {
  
  @doc("Formula 1 Race Result")
  model Result {
    id: UUID;
    raceId: UUID;
    driverId: UUID;
    teamId: UUID;
    position: int32;
    points: float32;
    status: string;
    metadata: EntityMetadata;
  }

  @doc("Create result request")
  model CreateResultRequest {
    raceId: UUID;
    driverId: UUID;
    teamId: UUID;
    
    @minValue(1)
    position: int32;
    
    @minValue(0)
    points: float32;
    
    @minLength(1)
    @maxLength(50)
    status: string;
  }

  @doc("Update result request")
  model UpdateResultRequest {
    raceId?: UUID;
    driverId?: UUID;
    teamId?: UUID;
    
    @minValue(1)
    position?: int32;
    
    @minValue(0)
    points?: float32;
    
    @minLength(1)
    @maxLength(50)
    status?: string;
  }

  @doc("Get result by ID")
  @get
  @route("/api/results/{id}")
  op getResult(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Result;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new result")
  @post
  @route("/api/results")
  op createResult(
    @body body: CreateResultRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Result;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update result")
  @put
  @route("/api/results/{id}")
  op updateResult(
    @path id: UUID,
    @body body: UpdateResultRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Result;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete result")
  @delete
  @route("/api/results/{id}")
  op deleteResult(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}