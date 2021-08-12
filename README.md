# Videocity

Spring microservice project.

## Installation

Not implemented yet.

## Usage

Not implemented yet.

## About

The project is basically a video sharing platform. Using the Youtube Data API V3, youtube videos are embedded in the presentation layer, and their corresponding information. There is also a video page, where we can add, delete and edit comments based to our liking.

## Structure

The project is modularized into a layered architecture design. The frontend is designed with react and communicates with the backend. The backend is a mixture of Spring Boot and Spring Cloud frameworks. The requests are forwarded to the appropriate service, however the authentication is served through the authentication server, which in turn communicates with the user server. The security is implemented in the gateway server, using Spring Cloud's built-in security manager with JWT tokens.
