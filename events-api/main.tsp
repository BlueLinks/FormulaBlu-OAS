import "@typespec/http";
import "@typespec/openapi3";
import "../shared/models.tsp";
import "../shared/responses.tsp";
import "../shared/parameters.tsp";

using Http;

@service({
  title: "Events API",
  version: "1.0.0",
  description: "API for managing Formula 1 events"
})
@server("http://localhost:8087", "Development server")
namespace EventsApi {
  
  @doc("Formula 1 Event")
  model Event {
    id: UUID;
    name: string;
    seasonId: UUID;
    trackId: UUID;
    eventDate: utcDateTime;
    eventType: string;
    isCompleted: boolean;
    metadata: EntityMetadata;
  }

  @doc("Create event request")
  model CreateEventRequest {
    @minLength(1)
    @maxLength(100)
    name: string;
    
    seasonId: UUID;
    trackId: UUID;
    
    eventDate: utcDateTime;
    
    @minLength(1)
    @maxLength(50)
    eventType: string;
  }

  @doc("Update event request")
  model UpdateEventRequest {
    @minLength(1)
    @maxLength(100)
    name?: string;
    
    seasonId?: UUID;
    trackId?: UUID;
    
    eventDate?: utcDateTime;
    
    @minLength(1)
    @maxLength(50)
    eventType?: string;
    isCompleted?: boolean;
  }

  @doc("Get event by ID")
  @get
  @route("/api/events/{id}")
  op getEvent(
    @path id: UUID
  ): {
    @statusCode statusCode: 200;
    @body body: Event;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;

  @doc("Create a new event")
  @post
  @route("/api/events")
  op createEvent(
    @body body: CreateEventRequest
  ): {
    @statusCode statusCode: 201;
    @body body: Event;
  } | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Update event")
  @put
  @route("/api/events/{id}")
  op updateEvent(
    @path id: UUID,
    @body body: UpdateEventRequest
  ): {
    @statusCode statusCode: 200;
    @body body: Event;
  } | global.NotFoundResponse | global.BadRequestResponse | global.UnprocessableEntityResponse | global.InternalServerErrorResponse;

  @doc("Delete event")
  @delete
  @route("/api/events/{id}")
  op deleteEvent(
    @path id: UUID
  ): {
    @statusCode statusCode: 204;
  } | global.NotFoundResponse | global.BadRequestResponse | global.InternalServerErrorResponse;
}