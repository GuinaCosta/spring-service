## Reference Links

- https://www.jrebel.com/blog/making-gradle-builds-faster
- https://codefresh.io/docs/docs/learn-by-example/java/gradle/
- https://spring.io/guides/gs/spring-boot-docker/
- https://www.marcusvieira.tech/monitoring/how-configure-new-relic-in-spring-boot
- https://www.split.io/blog/monitor-your-java-application-with-new-relic/

## Running Docker-Compose Apps

- Clone https://github.com/GuinaCosta/ASPNETCore3.1_StackExchange.Redis on the same root directory of this repo
- Follow the setup on README of the ASPNET App
- Copy https://github.com/GuinaCosta/spring-service/blob/main/newrelic/newrelic.yml.exemple#L16 as newrelic.yml and fill your NewRelic license key
- Just run docker-compose up

`docker-compose up --build`
