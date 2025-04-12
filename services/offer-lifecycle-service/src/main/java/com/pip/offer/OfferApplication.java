package com.pip.offer;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class OfferApplication extends Application<Configuration> {
    @Override
    public void run(Configuration configuration, Environment environment) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");

        final OfferDAO offerDAO = jdbi.onDemand(OfferDAO.class);
        environment.jersey().register(new OfferResource(offerDAO));
    }

    public static void main(String[] args) throws Exception {
        new OfferApplication().run(args);
    }
}
