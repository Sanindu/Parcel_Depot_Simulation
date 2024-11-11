
---

# Parcel Depot Simulation

This Java-based project simulates a parcel collection system, where customers collect parcels from a depot. Developed as a collaborative project, the application integrates concepts of **Object-Oriented Programming (OOP)**, **Test-Driven Development (TDD)**, **Multithreading**, and **Design Patterns**.

## Project Overview

![](https://github.com/Sanindu/Parcel_Depot_Simulation/blob/main/depot.gif)

The system processes a queue of customers collecting parcels from a depot, calculating collection fees based on each parcel's attributes dimensions, weight, and days in storage. Stage 1 involved setting up the core functionalities and unit tests, while Stage 2 extended the application with a graphical user interface (GUI) and added concurrent processing capabilities.

## Features

### Stage 1: Core System
- **Parcel and Customer Management**: Reads parcel and customer data from text files and maintains in-memory lists.
- **Fee Calculation**: Calculates collection fees based on parcel attributes.
- **Report Generation**: Outputs details of collected and uncollected parcels to a text file.
- **Unit Testing**: Utilises JUnit for testing key components, especially those involved in calculations.

### Stage 2: Extended System with GUI and Multithreading
- **Multithreading**: Implements separate threads for processing customers and updating the queue.
- **GUI Implementation**: Developed using JavaFX and SceneBuilder, with GUI elements to display the current parcel queue, customer queue, and processing status. 
- **Singleton Pattern**: Used in a Log class to record every event in the application (e.g., customer joins queue, customer is removed from queue, processing details displayed).
- **MVC Pattern**: Applied in GUI components to separate business logic from the interface, ensuring a scalable and maintainable structure.

## Technologies and Tools Used
- **Java**: Main programming language used for system logic, GUI, and multithreading.
- **JavaFX & SceneBuilder**: Designed and implemented the graphical user interface.
- **JUnit**: Unit testing framework to ensure reliability and correctness.
- **JIRA**: Managed project tasks and backlog in JIRA. You can view our backlog [here](https://csym026group05.atlassian.net/jira/software/projects/SCRUM/boards/1/backlog).
- **Git & GitHub**: Version control and collaboration.
- **Eclipse**: Development environment.

## Installation

1. Clone the repository:
2. Import the project into your IDE.
3. Run `Main.java` to start the application.

## Usage

1. Ensure input text files (`parcels.txt` and `customers.txt`) are populated with data.
2. Execute the application, which will process the parcel queue.
3. For GUI mode (Stage 2), adjust settings (e.g., processing speed) via GUI controls.

## Development Methodologies

- **TDD**: Followed TDD principles in Stage 1, focusing on writing test cases before developing each feature.
- **Agile**: Adopted an agile, incremental approach in Stage 2, integrating multithreading and GUI features iteratively.

## License

This project is licensed under the MIT License.

---


