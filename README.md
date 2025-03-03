# Hospital Management System - Spring Boot Web

## Overview
This is a **Spring Boot Web** project designed for a **Hospital Management System**. The system allows patients to book appointments, doctors to provide prescriptions, and administrators to manage hospital operations efficiently. The project follows **MVC architecture**, using **Spring Boot** for the backend and integrates with a database to store patient and doctor records.

## Features
### For Patients:
- Register and login securely.
- Book appointments with available doctors.
- View appointment status and history.
- Receive prescriptions from doctors.

### For Doctors:
- Manage patient appointments.
- Provide prescriptions to patients.
- View patient medical history.

### For Admins:
- Manage doctors and their schedules.
- Approve or reject patient registrations.
- View system analytics and reports.

## Tech Stack
- **Backend**: Spring Boot, Spring MVC, Spring Security, JPA/Hibernate
- **Frontend**: Thymeleaf, HTML, CSS, Bootstrap
- **Database**: MySQL / PostgreSQL
- **Build Tool**: Maven

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/hospital-management-system.git
   ```
2. Navigate to the project directory:
   ```sh
   cd hospital-management-system
   ```
3. Configure the database in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   ```
4. Build and run the project:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
5. Open `http://localhost:8080` in your browser.

## API Endpoints (if applicable)
- `POST /patients/register` - Register a new patient
- `POST /doctors/add` - Add a new doctor (Admin only)
- `GET /appointments/{id}` - Fetch appointment details
- `POST /prescriptions/create` - Doctor issues a prescription

## Contributors
- [adil7616](https://github.com/adil7616)

## License
This project is licensed under the **MIT License**.



