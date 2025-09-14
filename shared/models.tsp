// Shared Models for FormulaBlu APIs
// This file contains common models used across all APIs

import "@typespec/http";
import "@typespec/openapi3";

using Http;

// UUID type alias for consistency
alias UUID = string;

// Common Response Models
@doc("List response")
model ListResponse<T> {
  data: T[];
  metadata: {
    totalCount: int32;
    timestamp: utcDateTime;
  };
}

@doc("Entity metadata")
model EntityMetadata {
  createdAtTimestamp: utcDateTime;
  modifiedAtTimestamp: utcDateTime;
}

@doc("Error response model")
model Error {
  code: string;
  message: string;
  timestamp: utcDateTime;
}

@doc("Validation error details")
model ValidationError {
  code: string;
  message: string;
  field: string;
  rejectedValue?: string;
}

@doc("Timestamped entity base")
model TimestampedEntity {
  createdAt: utcDateTime;
  updatedAt: utcDateTime;
}