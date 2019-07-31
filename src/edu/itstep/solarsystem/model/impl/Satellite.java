package edu.itstep.solarsystem.model.impl;

import edu.itstep.solarsystem.model.SpaceBody;

public class Satellite extends SpaceBody {
    private int planet;

    public Satellite() {
    }

    public Satellite(int planet, int order, String name) {
        super(order, name);
        this.planet = planet;
    }

    public int getPlanet() {
        return planet;
    }

    public void setPlanet(int planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return planet + " " + super.toString();
    }
}
