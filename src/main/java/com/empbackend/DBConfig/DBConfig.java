package com.empbackend.DBConfig;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

public class DBConfig extends AbstractR2dbcConfiguration {
    @Override
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get("r2dbc:postgresql://localhost:5432/empdb");
    }

    @Bean
    public ConnectionFactoryInitializer connectionFactoryInitializer(ConnectionFactory connectionFactory){
        var init=new ConnectionFactoryInitializer();
        init.setConnectionFactory(connectionFactory);
        var dbPopulator=new CompositeDatabasePopulator();
        dbPopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));
       //dbPopulator.addPopulators(new ResourceDatabasePopulator(new ClassPathResource("data.sql")));
        init.setDatabasePopulator(dbPopulator);
        return init;
    }
}
