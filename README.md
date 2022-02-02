# <p align=center>Toy REST</p>
<div style="text-align: center">
<img src="https://github.com/qbicsoftware/spring-boot-rest-service-template/actions/workflows/build_package.yml/badge.svg">
<img src="https://github.com/qbicsoftware/spring-boot-rest-service-template/actions/workflows/run_tests.yml/badge.svg">
<img src="https://github.com/qbicsoftware/spring-boot-rest-service-template/actions/workflows/codeql-analysis.yml/badge.svg">
<img alt="GitHub release (latest SemVer including pre-releases)" src="https://img.shields.io/github/v/release/qbicsoftware/spring-boot-rest-service-template?include_prereleases">
<img alt="GitHub" src="https://img.shields.io/github/license/qbicsoftware/spring-boot-rest-service-template">
<img src="https://img.shields.io/badge/language-java-blue.svg">
<img src="https://img.shields.io/badge/framework-spring-blue.svg">
</div>

A minimal functional example for a http REST service created with [Spring Boot](https://spring.io/projects/spring-boot). 

Since this is a [Github repository template](https://docs.github.com/en/repositories/creating-and-managing-repositories/creating-a-repository-from-a-template), 
create a new application based on this repo and start your project directly.

## How to run

First compile the project and build an executable java archive:

```
mvn clean package
```

The JAR file will be created in the ``/target`` folder:

```
|-target
|---spring-boot-rest-template-1.0.0-SNAPSHOT.jar
|---...
```

Just change into the folder and run the REST service app with:

```
java -jar spring-boot-rest-template-1.0.0-SNAPSHOT.jar
```

The default configuration of the app binds to the local port 8080 to the systems localhost:

```
http://localhost:8080
```

If you want to change the server port, let's say `8085`, you can configure it by setting the
`server.port` property explicitly:

```
java -jar -Dserver.port=8085 spring-boot-rest-template-1.0.0-SNAPSHOT.jar
```

## How to use

The application provides only one endpoint that you can query with a simple GET HTTP request. Just
call the endpoint with the project ID `QTEST` and see what happens:

```
curl -v http://localhost:8081/projects/QTEST
```

This will give you the following terminal output:

```
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8081 (#0)
> GET /projects/QTEST HTTP/1.1
> Host: localhost:8081
> User-Agent: curl/7.64.1
> Accept: */*
>
< HTTP/1.1 200
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Wed, 02 Feb 2022 14:03:42 GMT
<
* Connection #0 to host localhost left intact
{"code":"QTEST","title":"Test project","description":"Just a test project"}* Closing connection 0
```

Checkout the ``200`` HTTP response code for `OK` and the content of the response body, which is a
JSON representation of a simple project resource match.

### Endpoints

Currently, there is only one HTTP GET endpoint to query different project resources:

```
/projects/{id}
```

Working project identifiers are `QTEST` and `QABCD`.
