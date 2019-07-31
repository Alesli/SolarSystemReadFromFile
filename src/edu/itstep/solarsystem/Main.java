package edu.itstep.solarsystem;

import edu.itstep.solarsystem.model.impl.Sun;
import edu.itstep.solarsystem.writer.WriteFile;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Sun> suns = new SolarSystem().getSolarSystem();
        suns.forEach(System.out::println);
        new WriteFile().writeFile(suns);
    }
}
