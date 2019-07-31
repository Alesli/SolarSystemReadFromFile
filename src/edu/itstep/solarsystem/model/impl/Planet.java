package edu.itstep.solarsystem.model.impl;

import edu.itstep.solarsystem.model.SpaceBody;

import java.util.List;

public class Planet extends SpaceBody {
    private int sun;
    private String type;
    private boolean habitable;
    private long population;
    private List<Satellite> satellites;

    public Planet() {
    }

    public Planet(int sun, int order, String name, String type, boolean habitable, long population) {
        super(order, name);
        this.sun = sun;
        this.type = type;
        this.habitable = habitable;
        this.population = population;
    }

    public Planet(int sun, int order, String name, String type, boolean habitable, long population, List<Satellite> satellites) {
        super(order, name);
        this.sun = sun;
        this.type = type;
        this.habitable = habitable;
        this.population = population;
        this.satellites = satellites;
    }

    public int getSun() {
        return sun;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHabitable() {
        return habitable;
    }

    public void setHabitable(boolean habitable) {
        this.habitable = habitable;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public List<Satellite> getSatellites() {
        return satellites;
    }

    public void setSatellites(List<Satellite> satellites) {
        this.satellites = satellites;
    }

    @Override
    public String toString() {
        String people = habitable ? "обитаема, популяция: " + population : "необитаема";
        StringBuilder sb = new StringBuilder("    Спутников нет");
        if (!satellites.isEmpty()) {
            sb.setLength(0);
            satellites.forEach(e -> sb.append("      " + e + "\n"));
        }
        return sun + " " + super.toString() + " " + type + " " + people + "\n" + sb;
    }
}
