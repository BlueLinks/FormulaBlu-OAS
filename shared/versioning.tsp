// Shared Versioning Configuration for FormulaBlu APIs
// This file defines versioning strategies and constants used across all APIs

import "@typespec/rest";

// Current API version
const API_VERSION = "1.0.0";

// Version information for OpenAPI specs and SDK generation
@doc("API version information for client SDK generation")
model ApiVersion {
  @doc("API version number (semantic versioning)")
  version: "1.0.0";
  
  @doc("Major version number")
  major: 1;
  
  @doc("Minor version number")
  minor: 0;
  
  @doc("Patch version number")
  patch: 0;
  
  @doc("API release date")
  releaseDate: "2024-01-15";
  
  @doc("API status")
  status: "stable";
  
  @doc("SDK generation compatibility")
  sdkCompatible: true;
  
  @doc("Feign client version")
  feignClientVersion: "1.0.0";
  
  @doc("Deprecation date (if applicable)")
  deprecationDate?: string;
  
  @doc("Sunset date (if applicable)")
  sunsetDate?: string;
}

// Version header for responses
@doc("API version header for client SDK compatibility")
model VersionHeader {
  @header("API-Version")
  apiVersion: "1.0.0";
  
  @header("API-Major-Version")
  apiMajorVersion: 1;
  
  @header("SDK-Version")
  sdkVersion: "1.0.0";
}

// Versioned response wrapper
@doc("Versioned API response")
model VersionedResponse<T> {
  ...VersionHeader;
  data: T;
  version: ApiVersion;
}

// Versioned error response
@doc("Versioned error response")
model VersionedErrorResponse {
  ...VersionHeader;
  error: Error;
  version: ApiVersion;
}

// Versioned paginated response
@doc("Versioned paginated response")
model VersionedPagedResponse<T> {
  ...VersionHeader;
  data: T[];
  pagination: Pagination;
  version: ApiVersion;
}

// Version compatibility information
@doc("API version compatibility matrix")
model VersionCompatibility {
  @doc("Supported API versions")
  supportedVersions: string[];
  
  @doc("Current stable version")
  currentStable: "1.0.0";
  
  @doc("Deprecated versions")
  deprecatedVersions: string[];
  
  @doc("Sunset versions")
  sunsetVersions: string[];
  
  @doc("Version compatibility notes")
  compatibilityNotes: string[];
}