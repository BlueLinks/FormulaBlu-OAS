// Shared Parameters for FormulaBlu APIs
// This file contains common query parameters used across all APIs

import "@typespec/http";

using Http;

// Simple query parameters
@doc("Search parameter")
model SearchParam {
  @query
  @doc("Search term")
  search?: string;
}

@doc("Active status filter parameter")
model ActiveParam {
  @query
  @doc("Filter by active status")
  isActive?: boolean;
}