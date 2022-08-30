package com.day11.unittestingspring;

import org.testcontainers.containers.PostgreSQLContainer;

public class AbstractContainerBaseTest {

    static final PostgreSQLContainer POSTGRE_SQL_CONTAINER;

    static {
        POSTGRE_SQL_CONTAINER = new PostgreSQLContainer("postgres:latest");
        POSTGRE_SQL_CONTAINER.start();

        //info about the container
        //System.out.println(postgreSQLContainer.getDatabaseName());
        //System.out.println(postgreSQLContainer.getDatabaseName());
        //System.out.println(postgreSQLContainer.getPassword());
        //System.out.println(postgreSQLContainer.getJdbcUrl());
    }
}
