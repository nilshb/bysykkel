# bysykkel-server

Bysykkel-server fetches data from oslobysykkel.no and exposes a rest
endpoint that gives you a list of bike stations with available bikes
and locks.

It is based on Java 1.8 and Spring Boot 2.0.  

Authentication
--
The following environment variable needs to be set with your api-key: `CLIENT_IDENTIFIER`

Dependencies
--
The service depends on bysykkel-client. Make sure you have done `mvn clean install` from parent
or from the bysykkel-client module. 

Build
--
`mvn clean package`

Run
--
Example
```
export CLIENT_IDENTIFIER=supersecretkey
java -jar target/bysykkel-server-1.0.0.jar
```
The service starts on port 8080.

Endpoint(s)
--
List station properties: `v1/stationproperties`

Example: `http://localhost:8080/v1/stationproperties`

Actuator
--
The service can be monitored on `/actuator/health`

Example: `http://localhost:8080/actuator/health`
