import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Teams API",
  version: "1.0.0",
  description: "API for managing Formula 1 teams"
})
@server("http://localhost:8083", "Development server")
namespace TeamsApi {
  
  @doc("Formula 1 Team")
  model Team {
    id: UUID;
    name: string;
    nationality: string;
    foundedYear?: int32;
    isActive: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create team request")
  model CreateTeamRequest {
    @minLength(1)
    @maxLength(100)
    name: string;
    
    @minLength(2)
    @maxLength(3)
    nationality: string;
    
    foundedYear?: int32;
  }

  @doc("Update team request")
  model UpdateTeamRequest {
    @minLength(1)
    @maxLength(100)
    name?: string;
    
    @minLength(2)
    @maxLength(3)
    nationality?: string;
    
    foundedYear?: int32;
    isActive?: boolean;
  }

  @doc("Get team by ID")
  @get
  @route("/api/teams/{id}")
  op getTeam(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Team;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new team")
  @post
  @route("/api/teams")
  op createTeam(
    @body body: CreateTeamRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Team;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update team")
  @put
  @route("/api/teams/{id}")
  op updateTeam(
    @path id: UUID,
    @body body: UpdateTeamRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Team;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete team")
  @delete
  @route("/api/teams/{id}")
  op deleteTeam(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}