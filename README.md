# Parking Management 

<div style="display: flex; justify-content: space-evenly; align-items: center; gap:5px; margin-bottom: 10px">
  <img src="https://camo.githubusercontent.com/bea90da226e09b503e6c8fde824f4816b98dcf30cd31e803006bf6335af06890/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d2532334544384230302e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6f70656e6a646b266c6f676f436f6c6f723d7768697465" alt="Java" />
  <img src="https://camo.githubusercontent.com/9ee242f2c2b1eb587f7e42704b3a0629082aac88f66fff96d34723f777b07775/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f737072696e672d2532333644423333462e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d737072696e67266c6f676f436f6c6f723d7768697465" alt="Spring" />
  <img src="https://camo.githubusercontent.com/544022edf8369d944e68802fc043b0268484709e334d23db2882590aeae296cb/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706f7374677265732d2532333331363139322e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d706f737467726573716c266c6f676f436f6c6f723d7768697465" alt="PostgreSQL" />
</div>

A demo application built with Spring Boot for managing parking lots. This project was developed as part of a challenge and demonstrates the use of technologies such as Spring Data JPA and Spring Web to create a robust and scalable API. It was built following Clean Architecture principles, ensuring a clear separation of concerns and maintainability.

## Features
- Vehicle entry and exit management
- Parking space registration and control
- CRUD operations for vehicles and reservations (if applicable)

## Technologies Used
- Java 21
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web
- PostgreSQL
- Lombok
- Maven

## Getting Started
- Java 21 installed
- Maven installed (or use the included Maven Wrapper)
- PostgreSQL

## Installation
  ### 1 - Clone the repository:
  ```bash
  git clone https://github.com/PatrickAraujoD/parking-management-challeng.git
  ```
  ### 2 - Navigate to the project folder:
  ```bash
  cd parking-management-challeng
  ```
  ### 3 - Database Configuration
  Configure your PostgreSQL connection by editing the `src/main/resources/application.`properties file with your database settings.

  ```bash
  spring.datasource.url=jdbc:postgresql://{host}:{port}/{database}
  spring.datasource.password={your_password}
  spring.datasource.username={your_username_db}
  ```
## Usage
- The application will start on port 8080 by default.
- Access the API at: `http://localhost:8080`

## License 
This project is licensed under the [MIT License](https://opensource.org/license/mit)


## Contact

For questions, suggestions, or feedback, please contact:

Patrick Araujo