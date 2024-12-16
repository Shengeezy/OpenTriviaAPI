## Getting Started

### Prerequisites

- Java 17 installed
- Gradle installed
- Node.js 21.x

### Backend Setup

1. **Clone the repository**

   ```bash
   git clone https://github.com/Shengeezy/OpenTriviaAPI
   cd <repo-folder>
   git submodule sync
   git submodule update --init --recursive
   cd demo

2. **Build the backend**

To build the Spring Boot application using Gradle, run:

    
    ./gradlew clean build


3. **Run the backend**

To start the Spring Boot backend server, run:

    ./gradlew bootRun
The backend server should run at http://localhost:8080.


### Frontend Setup

1. **Navigate to the frontend folder**


    cd <repo-folder>/angularclient

2. **Install dependencies**

Install all required packages using npm:

    npm install

3. **Build the Angular application**

To build the Angular project for production:

    ng build

4. **Run the frontend**

To start the Angular frontend:

    ng serve --open
The UI will be available at http://localhost:4200 and a window should automatically open in your browser.

### Integration
Ensure both the frontend and backend servers are running. The frontend uses the backend's endpoints on http://localhost:8080 to fetch questions from the OpenTrivia API and to verify the user's submitted answers.
