Restful-Booker API Automation Framework  
=================================
## 📌 Overview

- The Restful-Booker API Automation Framework is a Java-based test-only automation project built to validate the Restful-Booker API.


- It demonstrates how to design a maintainable REST API test framework using REST Assured and TestNG, with clear separation of concerns, reusable components, and CI integration against a Dockerised System Under Test (SUT).  


- The project also integrates Allure for rich test reporting.
---
## 🧱 Architecture & Design Principles

The framework follows a layered test architecture, with all implementation living under src/test (since this is a test framework, not an application).

- `core`        → Configuration & token management  
- `specs`       → REST Assured request specifications  
- `services`    → API endpoint interaction logic  
- `models`      → Request & response POJOs  
- `data`        → Test payload builders  
- `validators`  → Reusable assertions  
- `tests`       → TestNG test classes
---
## ✅ Key Design Decisions

- **Service layer** encapsulates all API calls (tests contain no HTTP logic)

- **POJOs** handle JSON serialization/deserialization

- **Validators** centralize assertions and reduce duplication

- **RequestSpecFactory** centralizes base URI, headers, and authentication

- **TestNG groups** control which tests run in CI vs locally
---
## 🛠 Tech Stack

| Technology             |
|------------------------|
| Java 21                 |
| REST Assured            |
| TestNG                  |
| Maven                   |
| Docker & Docker Compose |
| GitHub Actions (CI)     |
|Allure Reports|

## 📂 Project Structure  
````
restful-booker-api-automation/  
├── pom.xml  
├── testng-smoke.xml  
├── src  
│   └── test  
│       ├── java  
│       │   ├── core  
│       │   │   ├── BaseTest.java  
│       │   │   ├── ConfigReader.java  
│       │   │   └── TokenManager.java  
│       │   ├── data  
│       │   │   └── PayloadFactory.java  
│       │   ├── models  
│       │   │   ├── requests  
│       │   │   │   ├── Booking.java  
│       │   │   │   └── BookingDates.java  
│       │   │   └── responses  
│       │   │       └── CreateBookingResponse.java  
│       │   ├── services  
│       │   │   ├── AuthService.java  
│       │   │   ├── BookingService.java  
│       │   │   └── PingService.java  
│       │   ├── specs  
│       │   │   └── RequestSpecFactory.java  
│       │   ├── validators  
│       │   │   └── CommonValidators.java  
│       │   └── tests  
│       │       ├── AuthTests.java  
│       │       └── BookingTests.java  
│       └── resources  
│           └── config.properties
`````
---
## ⚙️ Configuration

**Configuration is handled via:**

`src/test/resources/config.properties`


**Example**:

`base.url=http://localhost:3001`

`auth.username=admin `

`auth.password=password123`

**The base URL can be overridden at runtime:**

```
mvn test -Dbase.url=http://localhost:3001
```
---
## ▶️ Running Tests Locally  
**1️⃣ Start the System Under Test (SUT)** 

**This framework uses a forked version of Restful-Booker, where the Node.js version in the Dockerfile was adjusted for stability.**

Clone the forked SUT repository:


```
git clone https://github.com/KariimMagdyy/restful-booker
cd restful-booker
docker compose up -d
```

The API will be available at:

`http://localhost:3001
`

**Wait until:**

    GET /ping → 201

**2️⃣ Run Smoke Tests**  
```
mvn test -Dsurefire.suiteXmlFiles=testng-smoke.xml
```

**3️⃣ Run Full Test Suite**  
```
mvn test
```
---
## 🧪 Test Strategy  
**Test Groups**

- `Smoke` → Core happy-path scenarios (CI gate)

- `Negative` → Validation & error-handling scenarios

**CI Behavior**

- CI runs Smoke tests only

- Negative tests are intentionally excluded from CI gating

- Ensures stable pipelines while retaining full coverage
---
**📊 Reporting (Allure)**

- Allure is integrated using allure-testng.

**Generate & View Report Locally**  
```
mvn test  
allure serve target/allure-results
```

**CI**:

- Allure results are uploaded as GitHub Actions artifacts

- Reports can be downloaded from the workflow run
---
## 🔁 Continuous Integration

**The GitHub Actions workflow:**

- Checks out the framework repository

- Sets up Java 21 and Maven cache

- Clones the Restful-Booker SUT

- Builds and starts the SUT via Docker Compose

- Waits for /ping readiness

- Executes the Smoke TestNG suite

- Uploads Surefire and Allure artifacts

---

## ✍️ Writing New Tests

- Add `request/response` models under `models`

- Add `endpoint` logic in a `services` class

- Build `payloads` using `PayloadFactory`

- Assert `responses` using `CommonValidators`

- Tag `tests` with TestNG groups `(Smoke, Negative)`

- Place `test classes` under `tests`
---
## 📎 Author

Karim Magdy  
Software Quality Engineer | API Automation | CI/CD
---
## 📄 License

This project is provided for educational and portfolio purposes.  
Feel free to use it as a template for your own API automation projects.