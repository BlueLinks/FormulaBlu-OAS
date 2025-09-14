#!/usr/bin/env node

const fs = require('fs-extra');
const path = require('path');
const { execSync } = require('child_process');
const chalk = require('chalk');

console.log(chalk.blue('🚀 Generating FormulaBlu Java Feign Client SDKs...'));

// Ensure directories exist
const generatedDir = path.join(__dirname, '..', 'generated');
const sdksDir = path.join(__dirname, '..', 'sdks');

if (!fs.existsSync(sdksDir)) {
  fs.mkdirSync(sdksDir, { recursive: true });
}

// API configurations with versioning information
const apis = [
  {
    name: 'drivers-api',
    title: 'Drivers API',
    version: '1.0.0',
    description: 'API for managing Formula 1 drivers, their career information, and statistics',
    feignClientVersion: '1.0.0',
    color: '#007bff',
    icon: 'fas fa-user-tie'
  },
  {
    name: 'teams-api',
    title: 'Teams API',
    version: '1.0.0',
    description: 'API for managing Formula 1 teams (constructors), their information, and statistics',
    feignClientVersion: '1.0.0',
    color: '#17a2b8',
    icon: 'fas fa-users'
  },
  {
    name: 'tracks-api',
    title: 'Tracks API',
    version: '1.0.0',
    description: 'API for managing Formula 1 tracks (circuits), their information, and statistics',
    feignClientVersion: '1.0.0',
    color: '#ffc107',
    icon: 'fas fa-route'
  },
  {
    name: 'races-api',
    title: 'Races API',
    version: '1.0.0',
    description: 'API for managing Formula 1 races, their information, and statistics',
    feignClientVersion: '1.0.0',
    color: '#dc3545',
    icon: 'fas fa-flag-checkered'
  },
  {
    name: 'seasons-api',
    title: 'Seasons API',
    version: '1.0.0',
    description: 'API for managing Formula 1 seasons, their information, and statistics',
    feignClientVersion: '1.0.0',
    color: '#28a745',
    icon: 'fas fa-trophy'
  },
  {
    name: 'events-api',
    title: 'Events API',
    version: '1.0.0',
    description: 'API for managing Formula 1 events (race weekends) and sessions',
    feignClientVersion: '1.0.0',
    color: '#6c757d',
    icon: 'fas fa-calendar-alt'
  },
  {
    name: 'results-api',
    title: 'Results API',
    version: '1.0.0',
    description: 'API for managing Formula 1 results, lap times, and championship standings',
    feignClientVersion: '1.0.0',
    color: '#343a40',
    icon: 'fas fa-chart-line'
  }
];

// SDK generation configurations - Java Feign Client only
const sdkConfigs = [
  {
    name: 'java',
    generator: 'java',
    packageName: 'com.formulablu.api',
    groupId: 'com.formulablu',
    artifactId: 'formulablu-api-client',
    version: '1.0.0',
    description: 'Java Feign client SDK for FormulaBlu APIs',
    additionalProperties: {
      'dateLibrary': 'java8',
      'library': 'feign',
      'useFeign': 'true',
      'useFeign10': 'true',
      'feignVersion': '10.12',
      'feignClientVersion': '1.0.0',
      'useBeanValidation': 'true',
      'useJakartaEe': 'true',
      'performBeanValidation': 'true',
      'useSpringBoot3': 'true',
      'useSpringCloudOpenFeign': 'true',
      'openApiNullable': 'false',
      'serializationLibrary': 'jackson',
      'bigDecimalAsString': 'true',
      'useGzipFeature': 'true',
      'useAbstractionForFiles': 'true',
      'hideGenerationTimestamp': 'true',
      'useOneOfInterfaces': 'true',
      'legacyDiscriminatorBehavior': 'false',
      'disallowAdditionalPropertiesIfNotPresent': 'false',
      'useSingleRequestParameter': 'true',
      'useTags': 'true',
      'interfaceOnly': 'true'
    }
  }
];

// Generate SDK for a specific API and language
async function generateSDK(api, sdkConfig) {
  const yamlFile = path.join(generatedDir, 'apis', `${api.name}.yaml`);
  
  if (!fs.existsSync(yamlFile)) {
    console.log(chalk.yellow(`⚠️  Skipping ${api.title} - YAML file not found`));
    return;
  }

  const sdkDir = path.join(sdksDir, sdkConfig.name, api.name);
  const outputDir = path.join(sdkDir, 'generated');

  console.log(chalk.blue(`📦 Generating ${sdkConfig.name} SDK for ${api.title}...`));

  try {
    // Ensure output directory exists
    await fs.ensureDir(outputDir);

    // Build OpenAPI Generator command
    const command = [
      'npx @openapitools/openapi-generator-cli generate',
      `-i "${yamlFile}"`,
      `-g ${sdkConfig.generator}`,
      `-o "${outputDir}"`,
      `--package-name "${sdkConfig.packageName}"`,
      `--api-package "${sdkConfig.packageName}.api"`,
      `--model-package "${sdkConfig.packageName}.model"`,
      `--additional-properties=${Object.entries(sdkConfig.additionalProperties || {})
        .map(([key, value]) => `${key}=${value}`)
        .join(',')}`,
      '--skip-validate-spec',
      '--remove-operation-id-prefix'
    ].join(' ');

    // Execute the command
    execSync(command, { stdio: 'pipe' });

    // Generate package.json for Node.js SDKs
    if (sdkConfig.name === 'typescript') {
      const packageJson = {
        name: sdkConfig.packageName,
        version: sdkConfig.version,
        description: sdkConfig.description,
        main: 'dist/index.js',
        types: 'dist/index.d.ts',
        scripts: {
          build: 'tsc',
          test: 'jest',
          lint: 'eslint src/**/*.ts',
          'lint:fix': 'eslint src/**/*.ts --fix'
        },
        dependencies: {
          'node-fetch': '^3.3.0',
          'form-data': '^4.0.0'
        },
        devDependencies: {
          '@types/node': '^18.0.0',
          'typescript': '^4.9.0',
          'jest': '^29.0.0',
          '@types/jest': '^29.0.0',
          'eslint': '^8.0.0',
          '@typescript-eslint/eslint-plugin': '^5.0.0',
          '@typescript-eslint/parser': '^5.0.0'
        },
        keywords: ['formula1', 'api', 'client', 'sdk'],
        author: 'FormulaBlu Team',
        license: 'MIT',
        repository: {
          type: 'git',
          url: 'https://github.com/FormulaBlu/FormulaBlu-OAS.git'
        }
      };

      await fs.writeJson(path.join(outputDir, 'package.json'), packageJson, { spaces: 2 });
    }

    // Generate pom.xml for Java SDKs
    if (sdkConfig.name === 'java') {
      const pomXml = `<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>${sdkConfig.groupId}</groupId>
    <artifactId>${sdkConfig.artifactId}-${api.name}</artifactId>
    <version>${sdkConfig.version}</version>
    <packaging>jar</packaging>

    <name>${api.title} Client SDK</name>
    <description>${api.description}</description>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <feign.version>10.12</feign.version>
        <jackson.version>2.15.2</jackson.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-core</artifactId>
            <version>\${feign.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-jackson</artifactId>
            <version>\${feign.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.openfeign</groupId>
            <artifactId>feign-okhttp</artifactId>
            <version>\${feign.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>\${jackson.version}</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.datatype</groupId>
            <artifactId>jackson-datatype-jsr310</artifactId>
            <version>\${jackson.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.11.0</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-source-plugin</artifactId>
                <version>3.2.1</version>
                <executions>
                    <execution>
                        <id>attach-sources</id>
                        <goals>
                            <goal>jar</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>`;

      await fs.writeFile(path.join(outputDir, 'pom.xml'), pomXml);
    }

    // Generate README for the SDK
    const readme = `# ${api.title} Client SDK

${api.description}

## Version Information

- **API Version**: ${api.version}
- **SDK Version**: ${sdkConfig.version}
- **Feign Client Version**: ${api.feignClientVersion}
- **Generated**: ${new Date().toISOString()}

## Installation

\`\`\`bash
# For Java (Maven)
<dependency>
    <groupId>${sdkConfig.groupId || 'com.formulablu'}</groupId>
    <artifactId>${sdkConfig.artifactId || 'formulablu-api-client'}-${api.name}</artifactId>
    <version>${sdkConfig.version}</version>
</dependency>

# For TypeScript (npm)
npm install ${sdkConfig.packageName}

# For Python (pip)
pip install ${sdkConfig.packageName}

# For C# (NuGet)
dotnet add package ${sdkConfig.packageName}

# For Go (go get)
go get ${sdkConfig.packageName}
\`\`\`

## Usage

\`\`\`${sdkConfig.name === 'java' ? 'java' : sdkConfig.name === 'typescript' ? 'typescript' : sdkConfig.name === 'python' ? 'python' : sdkConfig.name === 'csharp' ? 'csharp' : 'go'}
// Example usage will be available after SDK generation
\`\`\`

## API Endpoints

This SDK provides access to the following ${api.title} endpoints:

- \`GET /api/drivers\` - List drivers
- \`POST /api/drivers\` - Create driver
- \`GET /api/drivers/{id}\` - Get driver by ID
- \`PUT /api/drivers/{id}\` - Update driver
- \`DELETE /api/drivers/{id}\` - Delete driver
- \`GET /api/drivers/search\` - Search drivers
- \`GET /api/drivers/{id}/statistics\` - Get driver statistics
- \`GET /api/drivers/{id}/career\` - Get driver career

## Versioning

This SDK is compatible with API version ${api.version}. The SDK version follows semantic versioning and is designed to work with the corresponding API version.

## Support

For support and questions:
- **Issues**: Create an issue in the FormulaBlu-OAS repository
- **Documentation**: Check the API documentation at https://formulablu.github.io/FormulaBlu-OAS
- **API Reference**: Available at /swagger-ui.html for each service

## License

This project is licensed under the MIT License - see the LICENSE file for details.
`;

    await fs.writeFile(path.join(sdkDir, 'README.md'), readme);

    console.log(chalk.green(`✅ Generated ${sdkConfig.name} SDK for ${api.title}`));

  } catch (error) {
    console.error(chalk.red(`❌ Error generating ${sdkConfig.name} SDK for ${api.title}:`, error.message));
  }
}

// Generate all SDKs
async function generateAllSDKs() {
  console.log(chalk.blue('🔄 Starting Java Feign client SDK generation for all APIs...'));

  for (const api of apis) {
    for (const sdkConfig of sdkConfigs) {
      await generateSDK(api, sdkConfig);
    }
  }

  // Generate unified SDK documentation
  await generateUnifiedSDKDocs();

  console.log(chalk.green('🎉 SDK generation complete!'));
  console.log(chalk.blue('📁 SDK files created in ./sdks/'));
  console.log(chalk.blue('📚 Check individual README files for usage instructions'));
}

// Generate unified SDK documentation
async function generateUnifiedSDKDocs() {
  const docsDir = path.join(sdksDir, 'docs');
  await fs.ensureDir(docsDir);

  const unifiedReadme = `# FormulaBlu Client SDKs

This directory contains client SDKs for all FormulaBlu APIs, generated from OpenAPI specifications.

## Available SDKs

### APIs

${apis.map(api => `- **${api.title}** (${api.name}) - ${api.description}`).join('\n')}

### Languages

${sdkConfigs.map(sdk => `- **${sdk.name.toUpperCase()}** - ${sdk.description}`).join('\n')}

## Quick Start

1. **Choose your language** from the available SDKs
2. **Select the API** you want to use
3. **Follow the installation instructions** in the specific SDK README
4. **Start using the API** with type-safe client code

## Version Compatibility

All SDKs are generated from API version 1.0.0 and are designed to work together. The SDK versions follow semantic versioning and are compatible with the corresponding API versions.

## Directory Structure

\`\`\`
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
\`\`\`

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
`;

  await fs.writeFile(path.join(docsDir, 'README.md'), unifiedReadme);
  console.log(chalk.green('✅ Generated unified SDK documentation'));
}

// Main execution
if (require.main === module) {
  generateAllSDKs().catch(error => {
    console.error(chalk.red('❌ Error generating SDKs:', error.message));
    process.exit(1);
  });
}

module.exports = { generateAllSDKs, generateSDK, apis, sdkConfigs };
