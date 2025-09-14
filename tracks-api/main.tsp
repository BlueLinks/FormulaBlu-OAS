import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Tracks API",
  version: "1.0.0",
  description: "API for managing Formula 1 tracks"
})
@server("http://localhost:8084", "Development server")
namespace TracksApi {
  
  @doc("Formula 1 Track")
  model Track {
    id: UUID;
    name: string;
    country: string;
    city: string;
    length: float32;
    isActive: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create track request")
  model CreateTrackRequest {
    @minLength(1)
    @maxLength(100)
    name: string;
    
    @minLength(2)
    @maxLength(100)
    country: string;
    
    @minLength(1)
    @maxLength(100)
    city: string;
    
    @minValue(0.1)
    length: float32;
  }

  @doc("Update track request")
  model UpdateTrackRequest {
    @minLength(1)
    @maxLength(100)
    name?: string;
    
    @minLength(2)
    @maxLength(100)
    country?: string;
    
    @minLength(1)
    @maxLength(100)
    city?: string;
    
    @minValue(0.1)
    length?: float32;
    isActive?: boolean;
  }

  @doc("Get track by ID")
  @get
  @route("/api/tracks/{id}")
  op getTrack(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Track;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new track")
  @post
  @route("/api/tracks")
  op createTrack(
    @body body: CreateTrackRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Track;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update track")
  @put
  @route("/api/tracks/{id}")
  op updateTrack(
    @path id: UUID,
    @body body: UpdateTrackRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Track;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete track")
  @delete
  @route("/api/tracks/{id}")
  op deleteTrack(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}