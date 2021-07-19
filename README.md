## Structure:
- `app/` - Main application
- `app/test/` - Unit tests
- `app/androidTest/` - Instrumentation tests

## Install Application
- To install the application execute:

``` sh
./gradlew app:installDebug
```

## Running Tests

### Running Instrumentation Tests

#### From command-line via Gradle
- To run the Instrumentation tests execute:

``` sh
./gradlew app:connectedAndroidTest
```

### Running Unit Tests
- To run all the local unit tests execute:

```
./gradlew app:test
```
