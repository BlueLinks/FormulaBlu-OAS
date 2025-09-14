#!/usr/bin/env node

const fs = require('fs');
const path = require('path');
const { execSync } = require('child_process');

console.log('🚀 Generating FormulaBlu API Documentation...');

// Ensure directories exist
const docsDir = path.join(__dirname, '..', 'docs');
const generatedDir = path.join(__dirname, '..', 'generated');

if (!fs.existsSync(docsDir)) {
  fs.mkdirSync(docsDir, { recursive: true });
}

// API configurations
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

// Generate unified Swagger UI
function generateUnifiedSwaggerUI() {
  const swaggerConfig = {
    urls: apis.map(api => ({
      url: `./${api.name}.yaml`,
      name: api.title
    }))
  };

  const swaggerHTML = `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>FormulaBlu API Documentation</title>
  <link rel="stylesheet" type="text/css" href="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui.css" />
  <style>
    .swagger-ui .topbar { display: none; }
    .swagger-ui .info { margin: 20px 0; }
    .swagger-ui .info .title { color: #667eea; }
    .custom-header {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      padding: 2rem 0;
      text-align: center;
      margin-bottom: 2rem;
    }
    .custom-header h1 {
      margin: 0;
      font-size: 2.5rem;
      font-weight: bold;
    }
    .custom-header p {
      margin: 0.5rem 0 0 0;
      font-size: 1.2rem;
      opacity: 0.9;
    }
    .api-selector {
      margin: 20px 0;
      text-align: center;
    }
    .api-selector select {
      padding: 10px 20px;
      font-size: 16px;
      border: 2px solid #667eea;
      border-radius: 5px;
      background: white;
      color: #333;
    }
  </style>
</head>
<body>
  <div class="custom-header">
    <h1><i class="fas fa-flag-checkered"></i> FormulaBlu API Documentation</h1>
    <p>Comprehensive Formula 1 data APIs built with TypeSpec and OpenAPI 3.0</p>
    <p><strong>Version 1.0.0</strong> | <strong>SDK Compatible</strong> | <strong>Feign Client Ready</strong></p>
  </div>
  
  <div class="api-selector">
    <select id="api-selector" onchange="switchAPI()">
      <option value="">Select an API to view documentation</option>
      ${apis.map(api => `<option value="${api.name}">${api.title}</option>`).join('')}
    </select>
  </div>

  <div id="swagger-ui"></div>

  <script src="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui-bundle.js"></script>
  <script src="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui-standalone-preset.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
  <script>
    const apis = ${JSON.stringify(apis)};
    
    function switchAPI() {
      const selector = document.getElementById('api-selector');
      const selectedAPI = selector.value;
      
      if (selectedAPI) {
        const api = apis.find(a => a.name === selectedAPI);
        if (api) {
          SwaggerUIBundle({
            url: \`./\${selectedAPI}.yaml\`,
            dom_id: '#swagger-ui',
            presets: [
              SwaggerUIBundle.presets.apis,
              SwaggerUIStandalonePreset
            ],
            layout: "StandaloneLayout",
            deepLinking: true,
            showExtensions: true,
            showCommonExtensions: true,
            docExpansion: "list",
            filter: true,
            tryItOutEnabled: true
          });
        }
      }
    }
    
    // Initialize with first API
    if (apis.length > 0) {
      document.getElementById('api-selector').value = apis[0].name;
      switchAPI();
    }
  </script>
</body>
</html>`;

  fs.writeFileSync(path.join(docsDir, 'swagger-ui.html'), swaggerHTML);
  console.log('✅ Generated unified Swagger UI');
}

// Generate individual API documentation
function generateIndividualDocs() {
  apis.forEach(api => {
    const yamlFile = path.join(generatedDir, 'apis', `${api.name}.yaml`);
    
    if (fs.existsSync(yamlFile)) {
      console.log(`📝 Generating documentation for ${api.title}...`);
      
      try {
        // Create individual API directory
        const apiDocsDir = path.join(docsDir, api.name);
        if (!fs.existsSync(apiDocsDir)) {
          fs.mkdirSync(apiDocsDir, { recursive: true });
        }
        
        // Copy YAML file
        fs.copyFileSync(yamlFile, path.join(apiDocsDir, `${api.name}.yaml`));
        
        // Generate HTML documentation
        const htmlContent = `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${api.title} - FormulaBlu API</title>
  <link rel="stylesheet" type="text/css" href="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui.css" />
  <style>
    .swagger-ui .topbar { display: none; }
    .swagger-ui .info { margin: 20px 0; }
    .swagger-ui .info .title { color: ${api.color}; }
    .custom-header {
      background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
      color: white;
      padding: 2rem 0;
      text-align: center;
      margin-bottom: 2rem;
    }
    .custom-header h1 {
      margin: 0;
      font-size: 2.5rem;
      font-weight: bold;
    }
    .custom-header p {
      margin: 0.5rem 0 0 0;
      font-size: 1.2rem;
      opacity: 0.9;
    }
    .back-link {
      position: absolute;
      top: 20px;
      left: 20px;
      color: white;
      text-decoration: none;
      font-size: 1.1rem;
    }
    .back-link:hover {
      color: #ccc;
    }
  </style>
</head>
<body>
  <div class="custom-header">
    <a href="../index.html" class="back-link">
      <i class="fas fa-arrow-left"></i> Back to APIs
    </a>
    <h1><i class="${api.icon}"></i> ${api.title}</h1>
    <p>${api.description}</p>
    <p><strong>API Version:</strong> ${api.version} | <strong>Feign Client Version:</strong> ${api.feignClientVersion}</p>
  </div>

  <div id="swagger-ui"></div>

  <script src="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui-bundle.js"></script>
  <script src="https://unpkg.com/swagger-ui-dist@5.9.0/swagger-ui-standalone-preset.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
  <script>
    SwaggerUIBundle({
      url: './${api.name}.yaml',
      dom_id: '#swagger-ui',
      presets: [
        SwaggerUIBundle.presets.apis,
        SwaggerUIStandalonePreset
      ],
      layout: "StandaloneLayout",
      deepLinking: true,
      showExtensions: true,
      showCommonExtensions: true,
      docExpansion: "list",
      filter: true,
      tryItOutEnabled: true
    });
  </script>
</body>
</html>`;

        fs.writeFileSync(path.join(apiDocsDir, 'index.html'), htmlContent);
        console.log(`✅ Generated documentation for ${api.title}`);
        
      } catch (error) {
        console.error(`❌ Error generating docs for ${api.title}:`, error.message);
      }
    } else {
      console.log(`⚠️  Skipping ${api.title} - YAML file not found`);
    }
  });
}

// Main execution
try {
  // Generate unified Swagger UI
  generateUnifiedSwaggerUI();
  
  // Generate individual API documentation
  generateIndividualDocs();
  
  console.log('🎉 Documentation generation complete!');
  console.log('📁 Documentation files created in ./docs/');
  console.log('🌐 Open docs/index.html in your browser to view the documentation');
  
} catch (error) {
  console.error('❌ Error generating documentation:', error.message);
  process.exit(1);
}
