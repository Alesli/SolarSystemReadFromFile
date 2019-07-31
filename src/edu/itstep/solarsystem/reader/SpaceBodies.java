package edu.itstep.solarsystem.reader;

import edu.itstep.solarsystem.config.FileConfig;
import edu.itstep.solarsystem.model.impl.Planet;
import edu.itstep.solarsystem.model.impl.Satellite;
import edu.itstep.solarsystem.model.impl.Sun;

import java.util.ArrayList;
import java.util.List;

public class SpaceBodies {

    private ReadFile readFile = new ReadFile();

    public List<Sun> getSunList() {
        List<String> lines = readFile.getLines(FileConfig.SUN_FILE);
        List<Sun> suns = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] array = line.split(";");

                int order = Integer.parseInt(array[0].trim());
                String name = array[1].trim();
                Sun sun = new Sun();
                sun.setOrder(order);
                sun.setName(name);
                suns.add(sun);
//      // короткий вариант:  suns.add(new Sun(order, name));
            }

        return suns;
    }

    public List<Planet> getPlanetList() {
        List<String> lines = readFile.getLines(FileConfig.PLANET_FILE);
        List<Planet> planets = new ArrayList<>(lines.size());
        for (String line : lines) {
            String[] array = line.split(";");
            if (!array[2].trim().equalsIgnoreCase("null")) {
                planets.add(
                        new Planet(Integer.parseInt(array[0].trim()),
                                Integer.parseInt(array[1].trim()),
                                array[2].trim(), array[3].trim(),
                                Boolean.parseBoolean(array[4].trim()),
                                Long.parseLong(array[5].trim())));
            }
        }
        return planets;

    }

    public List<Satellite> getSatellitesList() {
        List<String> lines = readFile.getLines(FileConfig.SATELLITE_FILE);
        List<Satellite> satellites = new ArrayList<>(lines.size());   // чтобы не было перераспределения памяти
        for (String line : lines) {
            String[] array = line.split(";");
            if (!array[2].trim().equalsIgnoreCase("null")) {
                satellites.add(new Satellite(Integer.parseInt(array[0].trim()),
                        Integer.parseInt(array[1].trim()), array[2].trim()));
            }
        }
        return satellites;
    }

}
