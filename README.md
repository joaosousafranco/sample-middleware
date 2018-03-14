# Overview
The goal of this repository is to proof that using dropwizard it is possible to dynamically inject REST endpoints to a running API

# Usage

- Open project wiht IntelliJ
- Use gradlew (Recomended)
- Open terminal 
- ./gradlew build
- Wait for gradle to download dependencies

- To refresh java-lib dependency (MacOSX)
	- Open terminal 
	- ./gradlew build --refresh-dependencies
	- gradle tool window / refresh

*Docker

sudo docker build -t sample-middleware:1.0.nightly .
sudo docker run -d --name=sample-middleware -p 8000:8000 -p 8001:8001 sample-middleware:1.0.nightly	
