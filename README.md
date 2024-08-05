# Profile Management REST API

This project is a Spring Boot application designed to manage user profiles through a set of RESTful API endpoints. The API allows for CRUD operations on profile data, including lifestyle, family details, career details, profile visits, interests, and profile images. It is built using Spring Boot, Spring Data JPA, and Hibernate, providing a robust and scalable architecture for handling complex profile data.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
- [Installation](#installation)
- [Usage](#usage)
- [Entities](#entities)

## Features

- **Profile Management**: Create, read, update, and delete profiles using unique profile IDs.
- **Lifestyle Data**: Manage lifestyle information associated with profiles.
- **Family Details**: Handle family-related data for each profile.
- **Career Details**: Store and update career information for profiles.
- **Profile Visits**: Track which profiles have visited other profiles and show recent visitors.
- **Interests Tracking**: Manage interests expressed between profiles, and identify profiles with the most and fewest received interests.
- **Profile Images**: Upload, retrieve, and delete profile images.
  
## Getting Started

To get started with this project, you will need to have Java, Maven, and a compatible IDE installed on your machine. Follow these instructions to set up the project locally.

### Prerequisites

- Java 17 or later
- Maven 3.8.1 or later
- IDE such as IntelliJ IDEA or Eclipse
- PostgreSQL or any other supported database

## Entities
The application manages several entities:

ProfileInfo: Contains basic profile information such as name, email, etc.
Lifestyle: Represents lifestyle data linked to a profile.
FamilyDetails: Contains family-related information for a profile.
CareerDetails: Represents career data for a profile.
ProfileVisits: Tracks profile visits between users.
InterestsTrack: Manages interests expressed between profiles.
ProfileImages: Manages images uploaded for each profile.
