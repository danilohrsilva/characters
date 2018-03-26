package com.example.drodrigues.heroespoc.infrastructure.factory;

import com.example.drodrigues.heroespoc.gateway.network.MarvelIntegrator;

public final class IntegratorFactory {

    private static final IntegratorFactory ourInstance = new IntegratorFactory();

    private IntegratorFactory() { }

    public static IntegratorFactory getInstance() {
        return ourInstance;
    }

    public MarvelIntegrator marvelIntegrator() {
        return new MarvelIntegrator();
    }


}
