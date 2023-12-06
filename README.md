# smart-meter-platform

## How to start

1. Run `docker-compose up`
2. Run the spring-boot project

For the updates in the schemas.sql to take effect, deleting and re-starting the timescaledb container is helpful.
If you want to observe the content of the timescaledb, you can use pgadmin. Just run `docker run -p "8081:80" --network="my-bridge-network" -e "PGADMIN_DEFAULT_EMAIL=admin@example.com" -e "PGADMIN_DEFAULT_PASSWORD:admin" -v "pg_admin_data:/var/lib/pgadmin" dpage/pgadmin4:6.1`

https://www.baeldung.com/spring-boot-data-sql-and-schema-sql#:~:text=3.%20The%C2%A0schema.sql%C2%A0File
