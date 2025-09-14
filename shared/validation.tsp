// Shared Validation Constants for FormulaBlu APIs
// This file contains validation rules and constants used across all APIs

import "@typespec/rest";

// Formula 1 Historical Constants
@doc("Formula 1 championship started in 1950")
const F1_FIRST_SEASON = 1950;

@doc("Maximum reasonable year for future seasons")
const F1_MAX_FUTURE_YEAR = 2100;

@doc("Minimum driver age for F1 (FIA regulations)")
const F1_MIN_DRIVER_AGE = 18;

@doc("Maximum reasonable driver age")
const F1_MAX_DRIVER_AGE = 60;

@doc("Minimum team founding year")
const F1_MIN_TEAM_YEAR = 1950;

@doc("Maximum race round per season")
const F1_MAX_ROUNDS_PER_SEASON = 30;

@doc("Minimum track length in meters")
const F1_MIN_TRACK_LENGTH = 3000;

@doc("Maximum track length in meters")
const F1_MAX_TRACK_LENGTH = 10000;

@doc("Minimum race distance in kilometers")
const F1_MIN_RACE_DISTANCE = 200;

@doc("Maximum race distance in kilometers")
const F1_MAX_RACE_DISTANCE = 500;

@doc("Minimum lap time in seconds")
const F1_MIN_LAP_TIME = 60;

@doc("Maximum lap time in seconds")
const F1_MAX_LAP_TIME = 300;

// Common Validation Patterns
@doc("ISO country code pattern")
const ISO_COUNTRY_CODE_PATTERN = "^[A-Z]{2,3}$";

@doc("Hex color code pattern")
const HEX_COLOR_PATTERN = "^#[0-9A-Fa-f]{6}$";

@doc("F1 driver number pattern (1-99)")
const F1_DRIVER_NUMBER_PATTERN = "^([1-9]|[1-9][0-9])$";

@doc("F1 position pattern (1-20+)")
const F1_POSITION_PATTERN = "^([1-9]|[1-2][0-9]|[3-9][0-9])$";

@doc("F1 lap time pattern (MM:SS.mmm)")
const F1_LAP_TIME_PATTERN = "^([0-5]?[0-9]):([0-5][0-9])\\.([0-9]{3})$";

@doc("F1 race time pattern (HH:MM:SS.mmm)")
const F1_RACE_TIME_PATTERN = "^([0-9]{1,2}):([0-5][0-9]):([0-5][0-9])\\.([0-9]{3})$";

@doc("F1 gap time pattern (+MM:SS.mmm or +LAP)")
const F1_GAP_TIME_PATTERN = "^(\\+([0-5]?[0-9]):([0-5][0-9])\\.([0-9]{3})|\\+[0-9]+LAP)$";

@doc("F1 status pattern")
const F1_STATUS_PATTERN = "^(Finished|DNF|DSQ|DNS|DNQ|DNPQ|DNP|WD|EX|NC)$";