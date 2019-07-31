package edu.itstep.solarsystem.model.impl;

import edu.itstep.solarsystem.model.SpaceBody;

import java.util.List;

public class Sun extends SpaceBody {

    private List<Planet> planets;

    public Sun() {
    }

    public Sun(int order, String name) {
        super(order, name);
    }

    public Sun(int order, String name, List<Planet> planets) {
        super(order, name);
        this.planets = planets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("    Планет нет");
        if (!planets.isEmpty()) {
            sb.setLength(0);
            planets.forEach(e -> sb.append("      ").append(e).append("\n"));
        }
        return super.toString() + "\n" + sb;
    }
}
