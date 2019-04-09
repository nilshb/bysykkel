# bysykkel-client

Bysykkel-client is a java (1.8) API for fetching data from oslobysykkel.no.
It can also be used from the command line to print a list of bike stations
with available bikes and locks to stdout. 

The projects depends on:
* gson
* okhttp

It uses Maven to build and handle dependencies. Building will produce two artifacts:
a runnable jar, and a library jar.

Authentication
--
The following environment variable needs to be set with your api-key: `CLIENT_IDENTIFIER`


Build
--
`mvn clean package`

Run
--
example
```
export CLIENT_IDENTIFIER=supersecretkey
java -jar target/bysykkel-client-1.0.0-jar-with-dependencies.jar
```

