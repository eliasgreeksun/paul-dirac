# paul-dirac

# Security
## To add security for actuator endpoints
These will protect your API and Actuator endpoints. This can be further fine-tuned using:

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain security(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic();
        return http.build();
    }
}

Use the following environment variables
ACTUATOR_NAME=something1;ACTUATOR_SYKRET=something2

# Building package and run
## With Maven
In terminal
export ACTUATOR_NAME=something1
export ACTUATOR_SYKRET=something2
note here something1 and something2 do not really matter, since you will be passing those values to the .jar file explicitly when running it. 

mvn clean package
and then run with a command
ACTUATOR_NAME=something1 ACTUATOR_SYKRET=something2 java -jar ./target/pauldirac-0.0.1-SNAPSHOT.jar

## With Maven wrapper (mvnw)
./mvnw package
ACTUATOR_NAME=something1 ACTUATOR_SYKRET=something2 java -jar ./target/pauldirac-0.0.1-SNAPSHOT.jar

## Connect to datasource
In config, set the following env variables:
DATASOURCE_NAME=something3
DATASOURCE_SYKRET=something4
DATASOURCE_DB_NAME=something5
These needed to be added to the 'mvn clean package' and when running .jar file as well.

## Run configuration
pass env settings as such
ACTUATOR_NAME=something1;ACTUATOR_SYKRET=something2;DATASOURCE_NAME=something3;DATASOURCE_SYKRET=something4;DATASOURCE_DB_NAME=something5
Alternatively you could add these to .env file.

# DB Required
## Install MySQL
Install MySQL with Brew.
Start MySQL: brew services start mysql
Stop MySQL: brew services stop mysql
Check if MySQL is running: brew services list
Check if MySQL is running: ps aux | grep mysqld

## Setup root user
Optionaly run this command to create root creds: mysql_secure_installation
Test root connection: mysql -u root -p
Test to see root user exists: SELECT user, host FROM mysql.user;
Exit or quit: quit

## Create paul-dirac user
log as root user and
create paul_dirac user: CREATE USER 'paul_dirac'@'localhost' IDENTIFIED BY '123something';
exit and log in as root user to giver privileges to paul_dirac
give paul dirac all privileges to manage tables: GRANT ALL PRIVILEGES ON *.* TO 'paul_dirac'@'localhost' WITH GRANT OPTION;
mysql> SELECT user, host FROM mysql.user;
+------------------+-----------+
| user             | host      |
+------------------+-----------+
| mysql.infoschema | localhost |
| mysql.session    | localhost |
| mysql.sys        | localhost |
| paul_dirac       | localhost |
| root             | localhost |
+------------------+-----------+

This means you have a root and paul_dirac users you can connect as.

## Create Database
sign in as paul_dirac: mysql -u paul_dirac -p

and create a database: CREATE DATABASE paul_dirac;
give all privileges to paul_dirac on this database: GRANT ALL PRIVILEGES ON paul_dirac.* TO 'paul_dirac'@'localhost';
flush privileges for good measure: FLUSH PRIVILEGES;
Test DB access: USE paul_dirac;
check database is there: SHOW DATABASES;
mysql> SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| paul_dirac         |
| performance_schema |
| sys                |
+--------------------+

## Connect through DB_Beaver
Add a connection to MySQL. You may need to:
Edit Connection
Click Driver Properties tab
Find allowPublicKeyRetrieval <--- set this to TRUE

## Create Tables and Data
Now that you are connected you can run the following SQL script to create tables
1) student related: schema-student.sql, data-student.sql
2) employee related: schema-employee.sql, data-employee.sql
3) attorney related: schema-attorney.sql, data-attorney.sql

### Student
Student data is intended to practice the most manual implementation of JPA/Hibernate.
Here we will rely on the manual set up of the following Cmponents:
1) StudentRestController
2) Student DAO Interface and Implementation (Repository)
3) Student Entity (Map of the DB Tables)
4) Student DTO (Isolating Entity from Services)
Key element here is an Entity Manager which we inject as a dependency. All the find, create, etc calls are implemented with Entity Manager.
