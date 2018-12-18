package com.capillary.graphqlresolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlResolverApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(GraphqlResolverApplication.class);

	public static void main(String[] args) {
        LOGGER.info("comment resolver createdBy");
        SpringApplication.run(GraphqlResolverApplication.class, args);
	}

}

