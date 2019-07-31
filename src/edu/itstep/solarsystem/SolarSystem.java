package edu.itstep.solarsystem;

import edu.itstep.solarsystem.model.impl.Planet;
import edu.itstep.solarsystem.model.impl.Satellite;
import edu.itstep.solarsystem.model.impl.Sun;
import edu.itstep.solarsystem.reader.SpaceBodies;

import java.util.ArrayList;
import java.util.List;

public class SolarSystem {
    public List<Sun> getSolarSystem() {
        SpaceBodies spaceBodies = new SpaceBodies();
        List<Sun> suns = spaceBodies.getSunList();
        List<Sun> result = new ArrayList<>();
        for (Sun sun : suns) {
            List<Planet> planets = getPlanets(sun.getOrder());
            sun.setPlanets(planets);
            result.add(sun);
        }
        return result;
    }

    public List<Planet> getPlanets(int sunNumber) {
        SpaceBodies spaceBodies = new SpaceBodies();
        List<Planet> planets = spaceBodies.getPlanetList();
        List<Planet> result = new ArrayList<>();
        for (Planet planet : planets) {
            if (planet.getSun() == sunNumber) {
                List<Satellite> satellites = getSatellites(planet.getOrder());
                planet.setSatellites(satellites);
                result.add(planet);
            }
        }
        return result;
//       // вариант с лямбда-выражениями:
//             return planets
//                .stream()
//                .parallel()
//                .filter(planet -> planet.getSun() == sunNumber)
//                .collect(Collectors.toList());
    }

    public List<Satellite> getSatellites(int planetNumder) {
        SpaceBodies spaceBodies = new SpaceBodies();
        List<Satellite> Satellites = spaceBodies.getSatellitesList();
        List<Satellite> result = new ArrayList<>();
        for (Satellite satellite : Satellites) {
            if (satellite.getPlanet() == planetNumder) {
                result.add(satellite);
            }
        }
        return result;
    }
}
