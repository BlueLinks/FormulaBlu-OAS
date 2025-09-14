// Shared Response Models for FormulaBlu APIs
// This file contains common response definitions used across all APIs

import "@typespec/http";
import "./models.tsp";

using Http;

// Common HTTP Responses
@doc("Bad Request response")
model BadRequestResponse {
  @statusCode
  statusCode: 400;
  @body
  body: Error;
}

@doc("Unauthorized response")
model UnauthorizedResponse {
  @statusCode
  statusCode: 401;
  @body
  body: Error;
}

@doc("Forbidden response")
model ForbiddenResponse {
  @statusCode
  statusCode: 403;
  @body
  body: Error;
}

@doc("Not Found response")
model NotFoundResponse {
  @statusCode
  statusCode: 404;
  @body
  body: Error;
}

@doc("Conflict response")
model ConflictResponse {
  @statusCode
  statusCode: 409;
  @body
  body: Error;
}

@doc("Unprocessable Entity response")
model UnprocessableEntityResponse {
  @statusCode
  statusCode: 422;
  @body
  body: {
    code: string;
    message: string;
    errors: ValidationError[];
    timestamp: utcDateTime;
  };
}

@doc("Internal Server Error response")
model InternalServerErrorResponse {
  @statusCode
  statusCode: 500;
  @body
  body: Error;
}

// Common Success Responses
@doc("Created response")
model ApiCreatedResponse<T> {
  @statusCode
  statusCode: 201;
  @body
  body: T;
}

@doc("OK response")
model ApiOkResponse<T> {
  @statusCode
  statusCode: 200;
  @body
  body: T;
}

@doc("No Content response")
model ApiNoContentResponse {
  @statusCode
  statusCode: 204;
}

@doc("List OK response")
model ApiListOkResponse<T> {
  @statusCode
  statusCode: 200;
  @body
  body: ListResponse<T>;
}