# FormulaBlu OpenAPI Specifications (OAS)

This repository contains the TypeSpec-based OpenAPI specifications for all FormulaBlu microservices, enabling model-driven development across the entire API ecosystem.

## 🎯 Purpose

This repository serves as the **single source of truth** for all API models and specifications used across FormulaBlu microservices. It enables:

-   **Consistent models** across all APIs
-   **Type-safe code generation** for Java microservices
-   **Automatic documentation** generation
-   **Client SDK generation** for multiple languages
-   **Feign client compatibility** for microservices
-   **Contract testing** and validation
-   **Version control** for API evolution

## 📁 Repository Structure

```
FormulaBlu-OAS/
├── shared/                          # Shared components
│   ├── models.tsp                   # Common data models
│   ├── responses.tsp                # Common response definitions
│   └── parameters.tsp               # Common query parameters
├── drivers-api/                     # Drivers API
│   ├── main.tsp                     # Main API definition
│   ├── models.tsp                   # Driver-specific models
│   ├── requests.tsp                 # Request models
│   └── responses.tsp                # Response models
├── teams-api/                       # Teams API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
├── tracks-api/                      # Tracks API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
├── races-api/                       # Races API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
├── seasons-api/                     # Seasons API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
├── events-api/                      # Events API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
├── results-api/                     # Results API
│   ├── main.tsp
│   ├── models.tsp
│   ├── requests.tsp
│   └── responses.tsp
└── README.md                        # This file
```

## 🚀 Quick Start

### Prerequisites

-   Node.js 18+
-   TypeSpec compiler (`npm install -g @typespec/compiler`)

### Development

1. **Install dependencies:**

    ```bash
    npm install
    ```

2. **Compile TypeSpec to OpenAPI:**

    ```bash
    # Compile all APIs
    tsp compile .

    # Compile specific API
    tsp compile drivers-api/main.tsp
    ```

3. **Generate documentation and SDKs:**

    ```bash
    # Generate OpenAPI documentation
    npm run build:docs

    # Generate client SDKs
    npm run generate:sdks

    # Generate everything
    npm run build:all
    ```

## 🔧 API Versioning & SDK Generation

### Versioning Strategy

All APIs use **semantic versioning** (1.0.0) for:

-   **API Compatibility**: Ensures consistent behavior across versions
-   **SDK Generation**: Each API version generates compatible client SDKs
-   **Feign Client Integration**: Microservices use version-specific Feign clients

### Client SDK Generation

The repository automatically generates client SDKs for multiple languages:

-   **Java** - Feign client ready for microservices
-   **TypeScript** - Node.js and browser compatible
-   **Python** - Full-featured Python client
-   **C#** - .NET compatible client
-   **Go** - Native Go client library

### Feign Client Integration

Each API includes:

-   **Feign Client Interfaces** - Ready-to-use Feign client interfaces
-   **Model Classes** - Type-safe request/response models
-   **Configuration Classes** - Spring Boot auto-configuration
-   **Version Compatibility** - Ensures compatibility with API versions

## 📋 API Services

### Core APIs

-   **Drivers API** - Driver master data and career information
-   **Teams API** - Constructor information and team stats
-   **Tracks API** - Circuit information and venue details
-   **Races API** - Race information and scheduling
-   **Seasons API** - Championship years, rules, and regulations
-   **Events API** - Race weekends, sessions (Practice, Qualifying, Race)
-   **Results API** - Race results, qualifying results, lap times, points

### API Features

Each API includes:

-   **Simple CRUD Operations** - Create, Read, Update, Delete
-   **Advanced Search** - Multi-criteria search with relevance scoring
-   **Statistics** - Comprehensive statistics and analytics
-   **Pagination** - Efficient data pagination
-   **Filtering** - Multiple filter options
-   **Sorting** - Flexible sorting capabilities

## 🔧 TypeSpec Structure

### Shared Components

The `shared/` directory contains common models and definitions used across all APIs:

-   **models.tsp** - Common data models (Error, Pagination, Country, UUID, etc.)
-   **responses.tsp** - Standard HTTP response definitions
-   **parameters.tsp** - Common query parameters

### UUID Usage

All entities use UUIDs for identifiers, providing several benefits:

-   **Global Uniqueness** - No ID conflicts across microservices
-   **Security** - Non-sequential IDs are harder to guess
-   **Scalability** - No coordination needed for ID generation
-   **Consistency** - Uniform identifier format across all APIs

### API Structure

Each API follows a consistent structure:

-   **main.tsp** - Main API definition with endpoints and interfaces
-   **models.tsp** - Core data models for the API
-   **requests.tsp** - Request models for API operations
-   **responses.tsp** - Response models for API operations

### Key Features

-   **Type Safety** - Strong typing throughout
-   **UUID Identifiers** - All entities use UUIDs for better microservices architecture
-   **Reusability** - Shared models across APIs
-   **Consistency** - Standardized patterns
-   **Documentation** - Comprehensive inline documentation
-   **Validation** - Built-in validation rules

## 🛠️ Development Workflow

### 1. Update Models

Edit the relevant `.tsp` files in the appropriate API directory:

```typescript
// Example: Adding a new field to Driver model
model Driver extends TimestampedEntity {
  // ... existing fields
  newField?: string; // New field
}
```

### 2. Compile and Test

```bash
# Compile the changes
tsp compile drivers-api/main.tsp

# Check for errors
tsp compile drivers-api/main.tsp --no-emit
```

### 3. Generate OpenAPI

```bash
# Generate OpenAPI specification
tsp compile drivers-api/main.tsp --emit @typespec/openapi3
```

### 4. Update Microservices

The generated OpenAPI specifications are automatically consumed by the FormulaBlu microservices through the Git submodule integration.

## 📊 Model Relationships

### Core Entities

-   **Driver** - Individual Formula 1 drivers
-   **Team** - Constructor teams
-   **Track** - Racing circuits
-   **Race** - Individual races
-   **Season** - Championship seasons
-   **Event** - Race weekends
-   **Result** - Race/session results

### Relationships

```
Season (1) -> (N) Race
Race (1) -> (1) Event
Event (1) -> (N) Session
Session (1) -> (N) Result
Result (N) -> (1) Driver
Result (N) -> (1) Team
Race (N) -> (1) Track
```

## 🔍 API Endpoints

### Standard CRUD Operations

Each API provides standard CRUD operations:

-   `GET /api/{resource}` - List resources with pagination
-   `POST /api/{resource}` - Create new resource
-   `GET /api/{resource}/{id}` - Get resource by ID
-   `PUT /api/{resource}/{id}` - Update resource
-   `DELETE /api/{resource}/{id}` - Delete resource

### Advanced Operations

-   `GET /api/{resource}/search` - Advanced search
-   `GET /api/{resource}/{id}/statistics` - Get statistics
-   `GET /api/{resource}/{id}/history` - Get history (where applicable)

## 🚀 Integration with Microservices

This repository is integrated with FormulaBlu microservices as a **Git submodule**:

1. **Model Generation** - TypeSpec compiles to OpenAPI specifications
2. **Code Generation** - Gradle generates Java models from OpenAPI specs
3. **Type Safety** - Generated models ensure type safety across services
4. **Consistency** - Shared models maintain consistency across APIs

## 📚 Best Practices

### Model Design

1. **Use shared models** for common entities (Country, Error, etc.)
2. **Extend base models** when appropriate (TimestampedEntity)
3. **Use enums** for fixed value sets
4. **Document everything** with `@doc` annotations
5. **Validate inputs** with appropriate constraints

### API Design

1. **Follow REST conventions** for endpoint naming
2. **Use consistent response patterns** (ApiResponse, PagedResponse)
3. **Provide comprehensive filtering** options
4. **Include search capabilities** for all list endpoints
5. **Support pagination** for large datasets

### Error Handling

1. **Use standard error codes** from shared models
2. **Provide detailed error messages**
3. **Include validation errors** with field-specific details
4. **Use appropriate HTTP status codes**

## 🔧 Configuration

### TypeSpec Configuration

Create a `tspconfig.yaml` file in the root directory:

```yaml
emit:
    - "@typespec/openapi3"
    - "@typespec/json-schema"
outputDir: "./generated"
```

### Compilation Options

```bash
# Compile with specific options
tsp compile . --emit @typespec/openapi3 --output-dir ./generated

# Watch mode for development
tsp compile . --watch

# Generate specific format
tsp compile . --emit @typespec/openapi3 --emit @typespec/json-schema
```

## 📈 Monitoring and Validation

### Validation

```bash
# Validate TypeSpec files
tsp compile . --no-emit

# Check for specific issues
tsp compile . --diagnostic-level error
```

### Documentation

```bash
# Generate comprehensive documentation
tsp compile . --emit @typespec/openapi3 --emit @typespec/markdown
```

## 🤝 Contributing

### Development Guidelines

1. **Follow TypeSpec conventions** for naming and structure
2. **Update documentation** when adding new models
3. **Test compilation** before committing changes
4. **Use meaningful commit messages**
5. **Update version numbers** for breaking changes

### Pull Request Process

1. **Fork the repository**
2. **Create a feature branch**
3. **Make your changes**
4. **Test compilation**
5. **Update documentation**
6. **Submit pull request**

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🆘 Support

For support and questions:

-   **Issues** - Create an issue in this repository
-   **Discussions** - Use GitHub Discussions for questions
-   **Documentation** - Check the TypeSpec documentation

---

**FormulaBlu OpenAPI Specifications** - Type-safe, model-driven API development for Formula 1 microservices.
