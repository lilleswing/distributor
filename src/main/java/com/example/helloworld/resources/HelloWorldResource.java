package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.TensorConfiguration;
import com.example.helloworld.db.TensorConfigurationDAO;
import io.dropwizard.hibernate.UnitOfWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/get-work")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldResource.class);

    private final AtomicInteger counter;
    private final TensorConfigurationDAO tcDao;
    private final List<TensorConfiguration> configurations;

    public HelloWorldResource(TensorConfigurationDAO tcDao) {
        this.counter = new AtomicInteger();
        this.tcDao = tcDao;
        configurations = createConfigurations();
    }

    @GET
    @Path("/new-work")
    @Timed(name = "new-work")
    @UnitOfWork
    public TensorConfiguration getWork() {
        int index = counter.getAndIncrement();
        final TensorConfiguration tensorConfiguration = configurations.get(index);
        tensorConfiguration.setStatus("STARTED");
        return tcDao.create(tensorConfiguration);
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public void updateResults(@PathParam("id") long id,
                              @Valid TensorConfiguration tensorConfiguration) {
        tensorConfiguration.setStatus("COMPLETE");
        LOGGER.error("Received a tensorConfiguration: {}", tensorConfiguration);
        configurations.set((int) id, tensorConfiguration);
        tcDao.update(tensorConfiguration);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @UnitOfWork
    public List<TensorConfiguration> listConfigurations() {
        return tcDao.findAll();
    }

    private List<TensorConfiguration> createConfigurations() {
        final List<TensorConfiguration> configurations = new ArrayList<>();
        final List<String> datasets = new ArrayList<>();
        datasets.add("BORON");
        datasets.add("GABLE");
        for (int i = 20; i <= 60; i += 5) {
            for (final String dataSet : datasets) {
                final TensorConfiguration tensorConfiguration = new TensorConfiguration();
                tensorConfiguration.setNumAtoms(i);
                tensorConfiguration.setProjectData(dataSet);
                configurations.add(tensorConfiguration);
            }
        }
        return configurations;
    }
}
