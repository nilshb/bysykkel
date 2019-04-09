# bysykkel

Bysykkel consists of two modules:
- bysykkel-client, an api for accessing oslobysykkel.
- bysykkel-server, a service with a REST endpoint that exposes a list of bike stations with available locks and bikes.

Read each modules README for more info.

Build
--
To build everything: `mvn clean install`.

Start service
--
Set api key in environment and run jar in bysykkel-server/target.

Example:
```
 export CLIENT_IDENTIFIER=supersecretkey
 java -jar bysykkel-server/target/bysykkel-server-1.0.0.jar
```


