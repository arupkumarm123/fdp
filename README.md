# fdp

## config-service 
This service is used by all the services to do config lookup. Ideally the config service is backed by some kind of database to store application configuration (host , port , flags etc)


## discovery-service
Eureka server for registering all the services endpoint. Client side lookup is done by calling the discovery service

## gateway-service
API Gateway , all service routes are defined


## fi-service
Fi onboarding and object definition

## figw-service
Realtime integration component for FDP

## user-management
User onboarding and account management . This should be extended to form the user dashboard service


## Build 

```
  mvn clean install
```


## Run the service instance locally

```
java -jar target/config-service-1.0-SNAPSHOT.jar &
java -jar target/discovery-service-1.0-SNAPSHOT.jar &
java -jar target/gateway-service-1.0-SNAPSHOT.jar &
java -jar target/fd-service-1.0-SNAPSHOT.jar &
java -jar target/figw-1.0-SNAPSHOT.jar &
java -jar target/user-service-1.0-SNAPSHOT.jar &

```
