# TransferServiceAPI
Simple Spring boot application which provide RESTful API for money transfer

### Prerequisite
- Maven
- JDK 1.8+
### Project Structure
```bash
TransferServiceAPI
├── src
│   ├── main
│   │   ├── java\com\example\demo
│   │   └── resources
│   └── test
│       ├── java\com\example\demo
│       └── resources
├── .gitignore
├── pom.xml
└── README.md
```
###  Build and Run application
```
_GOTO >_ **~/absolute-path-to-directory/TransferServiceAPI**  
and try below command in terminal
> **```mvn spring-boot:run```** it will run application as spring boot application

or
> **```mvn clean install```** it will build application and create **jar** file under target directory 

Run jar file from below path with given command
> **```java -jar ~/path-to-TransferServiceAPI/target/TransferAPI-0.0.1-SNAPSHOT.jar```**

Or
> run main method from `MoneyTransferApplication.java` as spring boot application.  

```
### Data
Initial data (src\main\resources\data.sql) will be loaded in the H2 database when application start.
> INSERT INTO ACCOUNTS (ACCOUNTID, BALANCE) VALUES
> (1, 100),
> (2, 100);
### Basic API Information
| Method | Path | Usage |
| --- | --- | --- |
| POST | /v1/transaction | create transaction/ trnasfer money |

  Request Body  
    ```
    {
	"accountFromId": 1,
	"accountToId":2,
	"amount":10
    }
    ``` 
### Error Code
| Code | Description |
| --- | --- |
| ERR_CLIENT_001 | used when error due to client's input or business logic |
| ERR_CLIENT_002 | used when error related to account logic |
### Library used
| Library | Usage |
| --- | --- |
| spring boot | for spring boot application |
| spring data jpa | for ORM and DB operation purpose |
| H2 | in-memory database  |
