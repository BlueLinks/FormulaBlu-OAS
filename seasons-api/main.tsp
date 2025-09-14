import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Seasons API",
  version: "1.0.0",
  description: "API for managing Formula 1 seasons"
})
@server("http://localhost:8086", "Development server")
namespace SeasonsApi {
  
  @doc("Formula 1 Season")
  model Season {
    id: UUID;
    year: int32;
    name: string;
    startDate: utcDateTime;
    endDate: utcDateTime;
    isActive: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create season request")
  model CreateSeasonRequest {
    @minValue(1950)
    @maxValue(2030)
    year: int32;
    
    @minLength(1)
    @maxLength(100)
    name: string;
    
    startDate: utcDateTime;
    endDate: utcDateTime;
  }

  @doc("Update season request")
  model UpdateSeasonRequest {
    @minValue(1950)
    @maxValue(2030)
    year?: int32;
    
    @minLength(1)
    @maxLength(100)
    name?: string;
    
    startDate?: utcDateTime;
    endDate?: utcDateTime;
    isActive?: boolean;
  }

  @doc("Get season by ID")
  @get
  @route("/api/seasons/{id}")
  op getSeason(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Season;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new season")
  @post
  @route("/api/seasons")
  op createSeason(
    @body body: CreateSeasonRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Season;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update season")
  @put
  @route("/api/seasons/{id}")
  op updateSeason(
    @path id: UUID,
    @body body: UpdateSeasonRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Season;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete season")
  @delete
  @route("/api/seasons/{id}")
  op deleteSeason(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}