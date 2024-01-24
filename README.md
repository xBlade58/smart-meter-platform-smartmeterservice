# smart-meter-platform-smartmeterservice

This `Smartmeter` microservice is responsible for manging data related to smart meters and meter readings as part for our [Smart Meter Platform](https://github.com/xBlade58/smart-meter-platform). To view the entire documentation of this service, please naviagte to our [page](https://github.com/xBlade58/smart-meter-platform-page).

## How to start and test locally

1. Run `docker-compose up` to set up TimescaleDB and Redis. It requires you to create a docker network called `my-bridge-network`.
    ```sh
    docker network create -d bridge my-bridge-network
    ```

 We didn't use the default network, which is automatically created when spinning up containers with docker-compose, because we wanted to test across multiple docker-compose files. Otherwise, the concentrator-component wouldn't be able to publish to EMQX-Broker in the Cloud, for example.

2. Run the spring-boot project with the following environment variables.

    ```
        TIMESCALEDB_USERNAME="adnim"
        TIMESCALEDB_PASSWORD="adnim"
        TIMESCALEDB_DB="timescaledb"
        TIMESCALEDB_URL="jdbc:postgresql://localhost:5432/${TIMESCALEDB_DB}"
        MQTT_BROKER_URL="tcp://localhost:1884"
        REDIS_HOST="localhost"
    ```

If you want to query for meter readings, you can use our Swagger UI under `localhost:8080/swagger-ui/index.html`.

If you want to **observe the database tables**, we recommend to use pgAdmin. For example:

```sh
docker run -p "8081:80" --network="my-bridge-network" -e "PGADMIN_DEFAULT_EMAIL=admin@example.com" -e "PGADMIN_DEFAULT_PASSWORD=admin" -v "pg_admin_data:/var/lib/pgadmin" dpage/pgadmin4:6.1
```

If you want to **observe the redis streams**, there is a Redis Insights container already running. Just visit `localhost:8001` and add the existing redis instance (`hostname = redis`).
