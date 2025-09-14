import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Races API",
  version: "1.0.0",
  description: "API for managing Formula 1 races"
})
@server("http://localhost:8085", "Development server")
namespace RacesApi {
  
  @doc("Formula 1 Race")
  model Race {
    id: UUID;
    name: string;
    seasonId: UUID;
    trackId: UUID;
    raceDate: utcDateTime;
    isCompleted: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create race request")
  model CreateRaceRequest {
    @minLength(1)
    @maxLength(100)
    name: string;
    
    seasonId: UUID;
    trackId: UUID;
    
    raceDate: utcDateTime;
  }

  @doc("Update race request")
  model UpdateRaceRequest {
    @minLength(1)
    @maxLength(100)
    name?: string;
    
    seasonId?: UUID;
    trackId?: UUID;
    
    raceDate?: utcDateTime;
    isCompleted?: boolean;
  }

  @doc("Get race by ID")
  @get
  @route("/api/races/{id}")
  op getRace(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Race;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new race")
  @post
  @route("/api/races")
  op createRace(
    @body body: CreateRaceRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Race;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update race")
  @put
  @route("/api/races/{id}")
  op updateRace(
    @path id: UUID,
    @body body: UpdateRaceRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Race;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete race")
  @delete
  @route("/api/races/{id}")
  op deleteRace(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}