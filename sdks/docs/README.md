# FormulaBlu Client SDKs

This directory contains client SDKs for all FormulaBlu APIs, generated from OpenAPI specifications.

## Available SDKs

### APIs

- **Drivers API** (drivers-api) - API for managing Formula 1 drivers, their career information, and statistics
- **Teams API** (teams-api) - API for managing Formula 1 teams (constructors), their information, and statistics
- **Tracks API** (tracks-api) - API for managing Formula 1 tracks (circuits), their information, and statistics
- **Races API** (races-api) - API for managing Formula 1 races, their information, and statistics
- **Seasons API** (seasons-api) - API for managing Formula 1 seasons, their information, and statistics
- **Events API** (events-api) - API for managing Formula 1 events (race weekends) and sessions
- **Results API** (results-api) - API for managing Formula 1 results, lap times, and championship standings

### Languages

- **JAVA** - Java Feign client SDK for FormulaBlu APIs

## Quick Start

1. **Choose your language** from the available SDKs
2. **Select the API** you want to use
3. **Follow the installation instructions** in the specific SDK README
4. **Start using the API** with type-safe client code

## Version Compatibility

All SDKs are generated from API version 1.0.0 and are designed to work together. The SDK versions follow semantic versioning and are compatible with the corresponding API versions.

## Directory Structure

```
sdks/
├── java/                    # Java SDKs
│   ├── drivers-api/
│   ├── teams-api/
│   └── ...
├── typescript/              # TypeScript SDKs
│   ├── drivers-api/
│   ├── teams-api/
│   └── ...
├── python/                  # Python SDKs
│   ├── drivers-api/
│   ├── teams-api/
│   └── ...
├── csharp/                  # C# SDKs
│   ├── drivers-api/
│   ├── teams-api/
│   └── ...
├── go/                      # Go SDKs
│   ├── drivers-api/
│   ├── teams-api/
│   └── ...
└── docs/                    # This documentation
```

## Feign Client Integration

For Java microservices using Feign clients, each API includes:

- **Feign Client Interfaces** - Ready-to-use Feign client interfaces
- **Model Classes** - Type-safe request/response models
- **Configuration Classes** - Spring Boot auto-configuration
- **Version Compatibility** - Ensures compatibility with API versions

## Support

For support and questions:
- **Issues**: Create an issue in the FormulaBlu-OAS repository
- **Documentation**: Check the API documentation at https://formulablu.github.io/FormulaBlu-OAS
- **API Reference**: Available at /swagger-ui.html for each service

## License

This project is licensed under the MIT License - see the LICENSE file for details.
