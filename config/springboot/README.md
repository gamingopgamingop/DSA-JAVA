# Spring Boot Configuration for DSA Java Project

This directory contains comprehensive Spring Boot configuration files for creating a modern, feature-rich REST API backend for the DSA Java Application. It provides complete setup for algorithm management, data structure operations, user authentication, and API documentation.

## 📁 Directory Structure

```
config/springboot/
├── spring-boot-build.gradle           # Spring Boot build configuration
├── templates/                        # Application templates
│   ├── DsaJavaApplication.java     # Main Spring Boot application
│   ├── controllers/                # REST API controllers
│   │   └── AlgorithmController.java # Algorithm management controller
│   ├── services/                   # Business logic services
│   │   └── AlgorithmService.java    # Algorithm service implementation
│   ├── repositories/              # Data access repositories
│   │   └── AlgorithmRepository.java # Algorithm JPA repository
│   ├── config/                     # Configuration classes
│   │   └── SecurityConfig.java     # Security configuration
│   └── entities/                   # JPA entities (to be created)
├── application.properties              # Application properties
└── README.md                         # This file
```

## 🚀 Quick Start

### 1. Apply Spring Boot Build Configuration

Add the Spring Boot build configuration to your `build.gradle`:

```gradle
apply from: 'config/springboot/spring-boot-build.gradle'
```

### 2. Run the Spring Boot Application

```bash
./gradlew bootRun
```

### 3. Build Executable JAR

```bash
./gradlew bootJar
```

### 4. Run Tests

```bash
./gradlew test
./gradlew integrationTest
```

## 🔧 Configuration Details

### Build Configuration (`spring-boot-build.gradle`)

- **Spring Boot Version**: 3.2.0
- **Java Version**: 17
- **Dependencies**: Web, Data JPA, Security, Validation, Actuator, Caching
- **Testing**: JUnit 5, TestContainers, Mockito
- **Documentation**: OpenAPI 3.0 (Swagger)
- **Monitoring**: Micrometer Prometheus
- **Security**: Spring Security with JWT
- **Database**: H2 (dev), MySQL/PostgreSQL (prod)
- **Code Quality**: Checkstyle, PMD, SpotBugs, JaCoCo, SonarQube

### Application Properties (`application.properties`)

- **Server Configuration**: Port 8080, context path `/api/v1`
- **Database**: H2 in-memory for development, configurable for production
- **Security**: JWT authentication with role-based access control
- **Caching**: Redis with configurable TTL
- **Logging**: Comprehensive logging configuration with Logback
- **API Documentation**: OpenAPI 3.0 with Swagger UI
- **Actuator**: Health checks, metrics, and monitoring endpoints
- **Profiles**: dev, test, prod, integration-test, performance-test
- **Performance**: Thread pools, connection pools, caching optimization

### Application Templates

#### Main Application Class (`DsaJavaApplication.java`)
- **Spring Boot 3.2** application with comprehensive configuration
- **Component Scanning**: Automatic component discovery
- **Caching**: Enable caching and JPA auditing
- **Async Processing**: Enable async and scheduled tasks
- **Profile Management**: Automatic profile detection and configuration
- **JavaFX Compatibility**: Proper headless configuration for GUI integration

#### REST API Controllers

##### Algorithm Controller (`AlgorithmController.java`)
- **Complete CRUD Operations**: Create, read, update, delete algorithms
- **Advanced Features**: Search, filtering, pagination, sorting
- **Execution Management**: Algorithm execution and result tracking
- **Analysis Features**: Performance and complexity analysis
- **Caching**: Intelligent caching for frequently accessed data
- **Security**: Role-based access control
- **Documentation**: Comprehensive OpenAPI documentation
- **Error Handling**: Proper exception handling and HTTP status codes

#### Service Classes

##### Algorithm Service (`AlgorithmService.java`)
- **Business Logic**: Complete algorithm management business logic
- **Data Transformation**: Entity to DTO conversion
- **Validation**: Input validation and error handling
- **Caching**: Multi-level caching strategy
- **Analytics**: Algorithm statistics and popularity tracking
- **Complexity Analysis**: Automatic complexity scoring
- **Search**: Full-text search capabilities
- **Statistics**: Comprehensive analytics and reporting

#### Data Repositories

##### Algorithm Repository (`AlgorithmRepository.java`)
- **JPA Repository**: Spring Data JPA repository interface
- **Custom Queries**: 50+ custom query methods
- **Performance**: Optimized queries with proper indexing
- **Search**: Full-text search and filtering capabilities
- **Analytics**: Statistical query methods
- **Pagination**: Efficient pagination support
- **Data Integrity**: Constraint checking and validation
- **Audit Trail**: Automatic timestamping and versioning

#### Security Configuration

##### Security Config (`SecurityConfig.java`)
- **Spring Security 6.x**: Modern security configuration
- **JWT Authentication**: Token-based authentication system
- **Authorization**: Role-based access control (RBAC)
- **CORS**: Cross-origin resource sharing configuration
- **Headers Security**: Security headers configuration
- **Session Management**: Stateless session configuration
- **Filter Chain**: Custom security filters
- **Endpoint Protection**: Method-level security annotations

## 🎯 Features

### REST API Features
- **Algorithm Management**: Complete CRUD operations for algorithms
- **Data Structure Management**: CRUD operations for data structures
- **Execution Engine**: Algorithm execution with real-time tracking
- **Analysis Tools**: Performance and complexity analysis
- **Search & Filtering**: Advanced search and filtering capabilities
- **Pagination**: Efficient pagination for large datasets
- **Sorting**: Multi-field sorting support
- **Caching**: Intelligent caching for improved performance

### Security Features
- **JWT Authentication**: Secure token-based authentication
- **Role-Based Access Control**: Granular permission management
- **Password Security**: Strong password policies
- **CORS Support**: Cross-origin resource sharing
- **Security Headers**: Comprehensive security headers
- **Session Management**: Stateless session configuration
- **API Rate Limiting**: Request rate limiting
- **Input Validation**: Comprehensive input validation

### Performance Features
- **Caching**: Multi-level caching with Redis
- **Database Optimization**: Connection pooling and batch operations
- **Async Processing**: Asynchronous task execution
- **Monitoring**: Real-time performance metrics
- **Profiling**: Application profiling support
- **Compression**: Response compression
- **Connection Pooling**: Optimized database connections

### Monitoring & Observability
- **Actuator Endpoints**: Health checks and metrics
- **Prometheus Metrics**: Comprehensive metrics export
- **Custom Metrics**: Application-specific metrics
- **Health Checks**: Database, cache, and service health
- **Logging**: Structured logging with multiple appenders
- **Tracing**: Request/response tracing
- **Error Tracking**: Comprehensive error reporting

### Development Features
- **Hot Reload**: Automatic application reloading
- **DevTools**: Development tools integration
- **Live Reload**: Live browser reloading
- **Debug Support**: Enhanced debugging capabilities
- **Testing**: Comprehensive test suite
- **Documentation**: Auto-generated API documentation
- **Profiling**: Performance profiling tools

## 🛠️ Development

### Setting Up Development Environment

1. **Prerequisites**:
   - Java 17 or higher
   - Gradle 8.5 or higher
   - Docker (optional, for containerized deployment)

2. **Database Setup**:
   - H2 (included) for development
   - MySQL/PostgreSQL for production (optional)

3. **IDE Configuration**:
   - IntelliJ IDEA or Eclipse with Spring Boot support
   - VS Code with Spring Boot extensions

4. **Environment Variables**:
   ```bash
   export JAVA_HOME=/path/to/java17
   export SPRING_PROFILES_ACTIVE=dev
   export DATABASE_URL=jdbc:h2:mem:testdb
   ```

### Running the Application

#### Development Mode
```bash
./gradlew bootRun
```

#### Production Mode
```bash
./gradlew bootJar
java -jar build/libs/dsa-java-spring-boot.jar --spring.profiles.active=prod
```

#### Testing
```bash
./gradlew test
./gradlew integrationTest
./gradlew performanceTest
```

### Database Migration

#### Development
```bash
./gradlew migrateDatabase
```

#### Production
```bash
java -jar build/libs/dsa-java-spring-boot.jar --spring.profiles.active=migration
```

## 📊 API Documentation

### Accessing API Documentation

Once the application is running, access the Swagger UI at:
- **Local**: http://localhost:8080/swagger-ui.html
- **Production**: https://your-domain.com/api/v1/swagger-ui.html

### API Endpoints

#### Algorithm Management
- `GET /api/v1/algorithms` - Get all algorithms (paginated)
- `GET /api/v1/algorithms/{id}` - Get algorithm by ID
- `POST /api/v1/algorithms` - Create new algorithm
- `PUT /api/v1/algorithms/{id}` - Update algorithm
- `DELETE /api/v1/algorithms/{id}` - Delete algorithm
- `GET /api/v1/algorithms/search` - Search algorithms
- `GET /api/v1/algorithms/category/{category}` - Get algorithms by category
- `GET /api/v1/algorithms/popular` - Get popular algorithms
- `GET /api/v1/algorithms/statistics` - Get algorithm statistics

#### Algorithm Operations
- `POST /api/v1/algorithms/{id}/execute` - Execute algorithm
- `GET /api/v1/algorithms/execution/{executionId}` - Get execution results
- `POST /api/v1/algorithms/{id}/analyze` - Analyze algorithm performance
- `GET /api/v1/algorithms/analysis/{analysisId}` - Get analysis results

#### System Management
- `GET /api/v1/health` - Health check
- `GET /api/v1/metrics` - Application metrics
- `GET /api/v1/info` - Application information
- `GET /api/v1/configprops` - Configuration properties

## 🔒 Testing

### Unit Tests
- **Service Layer**: Business logic testing
- **Repository Layer**: Data access testing
- **Controller Layer**: API endpoint testing
- **Configuration**: Configuration validation testing

### Integration Tests
- **API Integration**: End-to-end API testing
- **Database Integration**: Database operation testing
- **Security Testing**: Authentication and authorization testing
- **Performance Testing**: Load and stress testing

### Test Execution
```bash
# Run all tests
./gradlew test

# Run integration tests
./gradlew integrationTest

# Run performance tests
./gradlew performanceTest

# Run tests with coverage report
./gradlew test jacocoTestReport
```

## 🚀 Deployment

### Docker Deployment

#### Dockerfile Example
```dockerfile
FROM openjdk:17-jre-slim
COPY build/libs/dsa-java-spring-boot.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

#### Docker Compose
```yaml
version: '3.8'
services:
  dsa-java-app:
    build: .
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
      - DATABASE_URL=jdbc:postgresql://postgres:5432/dsajavadb
      - DATABASE_USERNAME=dsa_user
      - Traditional Chinese
      - DATABASE_PASSWORD=secure_password
    depends_on:
      - postgres
  postgres:
    image: postgres:15
    environment:
      - POSTGRES_DB=dsajavadb
      - POSTGRES_USER=dsa_user
      - POSTGRES_PASSWORD=secure_password
      - Traditional Chinese
    volumes:
      - postgres_data:/var/lib/postgresql/data
    ports:
      - "5432:5432"
```

### Kubernetes Deployment

#### Kubernetes Deployment
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: dsa-java-app
spec:
  replicas: 3
  selector:
    matchLabels:
      app: dsa-java-app
  template:
    metadata:
      labels:
        app: dsa-java-app
    spec:
      containers:
      - name: dsa-java-app
        image: dsa-java/spring-boot-app:latest
        ports:
        - containerPort: 8080
        env:
        - name: SPRING_PROFILES_ACTIVE
          value: "prod"
        - name: DATABASE_URL
          valueFrom:
            secretKeyRef:
              name: database-url
        - name: DATABASE_USERNAME
          valueFrom:
            secretKeyRef:
              name: database-username
        - name: DATABASE_PASSWORD
          valueFrom:
            secretKeyRef:
              name: database-password
        resources:
          limits:
            memory: "512Mi"
            cpu: "500m"
        livenessProbe:
          httpGet:
            path: /api/v1/health
            initialDelaySeconds: 30
            periodSeconds: 10
        readinessProbe:
          httpGet:
            path: /api/v1/health
            initialDelaySeconds: 5
            periodSeconds: 5
```

## 🔍 Monitoring & Observability

### Health Checks
- **Database Health**: Database connectivity and performance
- **Cache Health**: Redis connectivity and performance
- **Disk Space**: Available disk space monitoring
- **Memory Health**: JVM memory usage monitoring
- **Thread Health**: Thread pool status monitoring

### Metrics Collection
- **Application Metrics**: Custom application metrics
- **JVM Metrics**: JVM memory, garbage collection, threads
- **Database Metrics**: Connection pool usage, query performance
- **HTTP Metrics**: Request/response statistics
- **Cache Metrics**: Cache hit rates and performance

### Alerting
- **Health Check Failures**: Automatic alerting on health check failures
- **Performance Degradation**: Alerting on performance issues
- **Error Rate**: Alerting on high error rates
- **Resource Exhaustion**: Alerting on resource exhaustion

## 🔧 Configuration Management

### Profile-Based Configuration
- **Development**: Optimized for development experience
- **Test**: Optimized for testing environments
- **Production**: Optimized for production performance
- **Integration Test**: Optimized for integration testing
- **Performance Test**: Optimized for performance testing

### Environment Variables
- **Database Configuration**: Database connection settings
- **Security Settings**: Security configuration
- **Logging Configuration**: Logging level and output settings
- **Performance Tuning**: Performance optimization settings
- **Feature Flags**: Feature toggle configuration

### Configuration Validation
- **Schema Validation**: Database schema validation
- **Property Validation**: Application property validation
- **Dependency Validation**: Dependency compatibility validation
- **Security Validation**: Security configuration validation

## 🤝 Troubleshooting

### Common Issues

#### Database Connection Issues
```bash
# Check database connectivity
curl http://localhost:8080/api/v1/health

# Check database logs
docker logs dsa-java-app
```

#### Security Issues
```bash
# Check JWT token generation
curl -X POST http://localhost:8080/api/v1/auth/login \
  -H "Content-Type: application/json" \
  -d '{"username":"admin","password":"admin"}'

# Check security headers
curl -I http://localhost:8080/api/v1/algorithms
```

#### Performance Issues
```bash
# Check application metrics
curl http://localhost:8080/api/v1/metrics

# Check thread pool status
curl http://localhost:8080/api/v1/actuator/threaddump
```

### Debug Mode
```bash
# Enable debug mode
./gradlew bootRun --debug

# Enable SQL logging
./gradlew bootRun --spring.jpa.show-sql=true
```

### Common Errors

#### Application Startup Failures
1. **Port Conflicts**: Check if port 8080 is available
2. **Database Issues**: Verify database connection settings
3. **Memory Issues**: Increase heap size if needed
4. **Dependency Issues**: Check dependency compatibility

#### Authentication Failures
1. **Token Issues**: Verify JWT configuration
2. **Credential Issues**: Check user credentials
3. **Permission Issues**: Verify role assignments
4. **Token Expiration**: Check token expiration settings

#### Performance Issues
1. **Slow Queries**: Check database query performance
2. **Memory Leaks**: Check for memory leaks
3. **Thread Contention**: Check thread pool configuration
4. **Cache Issues**: Check cache configuration

## 📚 Documentation

### API Documentation
- **Swagger UI**: Interactive API documentation
- **OpenAPI Specification**: Machine-readable API specification
- **Postman Collection**: Ready-to-use Postman collection
- **API Examples**: Comprehensive API usage examples

### Developer Guide
- **Setup Guide**: Development environment setup
- **Architecture Overview**: System architecture documentation
- **Coding Standards**: Coding conventions and best practices
- **Testing Guide**: Testing strategies and best practices
- **Deployment Guide**: Deployment procedures and best practices

### Operations Guide
- **Monitoring Setup**: Monitoring configuration
- **Alerting Setup**: Alert configuration
- **Backup Procedures**: Backup and recovery procedures
- **Troubleshooting**: Common issues and solutions
- **Performance Tuning**: Performance optimization guide

## 🔄 Version History

### v1.0.0 (Current)
- **Initial Release**: Complete Spring Boot application
- **Core Features**: Algorithm and data structure management
- **Security**: JWT-based authentication
- **API Documentation**: Complete OpenAPI documentation
- **Testing**: Comprehensive test suite
- **Monitoring**: Actuator endpoints and metrics
- **Performance**: Optimized for production use

### Future Releases
- **v1.1.0**: Enhanced visualization features
- **v1.2.0**: Advanced analytics and reporting
- **v1.3.0**: Microservices architecture
- **v2.0.0**: Cloud-native deployment

## 🤝 Contributing

### Development Setup
1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new features
5. Submit a pull request

### Code Standards
- **Java**: Follow Google Java Style Guide
- **Spring**: Follow Spring Boot best practices
- **Testing**: Write comprehensive tests
- **Documentation**: Document all public APIs
- **Security**: Follow security best practices

### Testing Requirements
- **Unit Tests**: 80% minimum coverage
- **Integration Tests**: All major workflows tested
- **Performance Tests**: Load and stress testing
- **Security Tests**: Authentication and authorization testing

### Code Review Process
- **Pull Request**: All PRs require code review
- **Quality Gates**: Automated quality checks
- **Security Review**: Security-focused code review
- **Performance Review**: Performance impact assessment

## 📄 License

This project is licensed under the MIT License. See `LICENSE` file for details.

## 🔗 Related Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [OpenAPI Specification](https://swagger.io/specification/)
- [Docker Documentation](https://docs.docker.com/)
- [Kubernetes Documentation](https://kubernetes.io/docs/)

---

*Last updated: 2024-04-27*  
*Maintained by: DSA Java Project Team*
