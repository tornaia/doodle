#### Maven, Spring Boot

I know them quite well and there is a time pressure right now. I don't want to play with anything new or fancy that is outside my comfort zone.
This stack is widely used and it is easy to find someone for such projects.

#### H2

- Do not struggle with heavy stuff
- Try to avoid the provider (Oracle, MariaDB, etc) specific queries and tricks or at least ask yourself: "Why do I need such a special stuff here? Maybe I should fix it by changing my data model..." It is also good since you waste less to set up your local-dev environment.

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