package com.example.helloworld.db;

import com.example.helloworld.api.TensorConfiguration;
import com.example.helloworld.core.Person;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class TensorConfigurationDAO extends AbstractDAO<TensorConfiguration> {
    public TensorConfigurationDAO(SessionFactory factory) {
        super(factory);
    }

    public Optional<TensorConfiguration> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public TensorConfiguration create(TensorConfiguration tc) {
        return persist(tc);
    }

    public List<TensorConfiguration> findAll() {
        return list(namedQuery("com.example.helloworld.core.api.TensorConfiguration.findAll"));
    }

    public TensorConfiguration update(TensorConfiguration tc) {
        return persist(tc);
    }
}
