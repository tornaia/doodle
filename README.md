#### Maven, Spring Boot

I know them quite well and there is a time pressure right now. I don't want to play with anything new or fancy that is outside my comfort zone.
This stack is widely used and it is easy to find someone for such projects.

#### H2

- Do not struggle with heavy stuff
- Try to avoid the provider (Oracle, MariaDB, etc) specific queries and tricks or at least ask yourself: "Why do I need such a special stuff here? Maybe I should fix it by changing my data model..." It is also good since you waste less time to set up your local-dev environment.

#### How to

Start app
```
docker-compose up --build
```

Access APIs

- List all polls created by a user (listPollsByInitiator)
```
curl -X GET http://localhost:8080/api/poll/v1/list/initiator/123456
```
- List all polls created after a certain date (listPollsByInitiatedGreaterThan)
```
curl -X GET http://localhost:8080/api/poll/v1/list/initiated/1595082717000
```
- Search polls by its title (listPollsByTitle)
```
curl -H "Content-Type: application/json" -X POST -d '{"text":"whatever"}' http://localhost:8080/api/poll/v1/list/title
```

Note: for the curls above use Git Bash on Windows!

#### Left out

- User/Identity related services are not implemented but polls depend on them - since there is a need for Initiator. Unfortunately this make the test code a bit ugly
- ClockService: I would add here a test implementation so date/time related logics can be nicely tested
- Reset schema between tests (so no more overlap or interference between then and it is not a problem if the same id (email, name) is reused. It makes the tests much more reliable
- The DB lookups are a bit suboptimal, since there are multiple db queries for each http request. What is do avg load? Are there any spikes? What is good enough? Need more information to implement something better
- The DoodleApplicationIntTest has a few test cases, but the asserts are too basic and the testing pyramid is also strange. No real unit tests or real API tests, just some integration ones
- The API-s do not return all the information listed in the polls.json: I decided not to add all of them to save some time
- SonarQube integration: this a static source code analyzer could find plenty of little issues (at least I think so)
- Transactions to keep DB consistent (but there are no write operations atm so its not an issue right now)
- Modularization: one module is responsible for users/identity and polls. For medium or bigger apps its not optimal for various reasons (scalability, maintainability)
- General exception handler: by using Spring's @ControllerAdvice and @ExceptionHandler(Exception.class) I would handle all the uncaught exceptions and return something general. Beside this it would 1. properly log all exceptions (no uncaught exceptions should be thrown) 2. hide maybe sensitive information (stack traces, framework versions etc) 
- PollRestController.listPollsByTitle should be a GET but passing "strange" characters (accents, Chinese, escape characters etc) as URL parameters are a bit tricky so I decided to go with POST + simple JSON-ish request body. If numbers and only alphanumerical (English) characters are passed then path parameters and request parameters are fine. (Note: there are problems with extremely long urls, see https://stackoverflow.com/questions/417142/what-is-the-maximum-length-of-a-url-in-different-browsers for more)

#### Idea

GraphQL would be worth a try if there are many lookups/search criterias, etc - however I have some bad feelings here about the performance, and I have to admin I have no experience with it.
