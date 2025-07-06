FROM postgres:14

ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=Postgres0026
ENV POSTGRES_DB=clientdb

COPY init.sql /docker-entrypoint-initdb.d/
