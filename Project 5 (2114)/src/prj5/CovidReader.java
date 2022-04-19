package prj5;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Daniel Yang (ydaniel21)

/**
 * Defines the ColonyReaderObject
 * 
 * 
 * @author Daniel Yang, ydaniel1
 * @version 4/14/22
 */
/**
 */

public class CovidReader {
    // private Planet[] planets;
    // private ArrayQueue<Person> queue;

    private SinglyLinkedList<State> states;

    /*
     * public CovidReader(String applicantFileName, String planetFileName)
     * throws ParseException,
     * SpaceColonyDataException {
     * queue = readQueueFile(applicantFileName);
     * 
     * planets = readPlanetFile(planetFileName);
     * 
     * @SuppressWarnings("unused")
     * SpaceWindow window = new SpaceWindow(new ColonyCalculator(queue,
     * planets));
     * }
     */

    public CovidReader(String dataFile) {
        states = readFile(dataFile);

        System.out.println(states.get(0).toString());
    }


    private SinglyLinkedList<State> readFile(String dataFile) {

        // Input.main(new String[] { "hi", "yes" });

        SinglyLinkedList<State> stateList = new SinglyLinkedList<State>();
        List<String[]> lines = new ArrayList<String[]>();

        try {
            File myObj = new File(dataFile);
            @SuppressWarnings("resource")
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                String data = myReader.nextLine();

                lines.add(data.split(","));

                // System.out.print(data + "\n");

            }

            String[][] array = new String[lines.size()][0];
            lines.toArray(array);

            for (int i = 1; i < array.length; i++) {
                SinglyLinkedList<Race> addRaces = new SinglyLinkedList<Race>();

                String stateName = array[i][0];
                for (int j = 1; j < array[0].length; j++) {
                    
                    if(array[i][j].equals("NA")) {
                        Race currentRace = new Race(array[0][j], 
                            array[i][j]);
                        addRaces.add(currentRace);
                    }else {
                    Race currentRace = new Race(array[0][j], Integer.parseInt(
                        array[i][j]));
                    addRaces.add(currentRace);
                    }
                    

                }
                State addState = new State(stateName, addRaces);
                stateList.add(addState);

            }

            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return stateList;

    }
}

/*
 * private Planet[] readPlanetFile(String fileName)
 * throws ParseException,
 * SpaceColonyDataException {
 * 
 * ArrayQueue<Planet> planets = new ArrayQueue<Planet>(3);
 * int count = 0;
 * 
 * try {
 * File myObj = new File(fileName);
 * 
 * @SuppressWarnings("resource")
 * Scanner myReader = new Scanner(myObj);
 * while (myReader.hasNextLine() && count < 3) {
 * String data = myReader.nextLine();
 * 
 * data = data.replaceAll(" ", "");
 * 
 * String[] planetInfo = data.split(",");
 * 
 * if (planetInfo.length != 5) {
 * throw new java.text.ParseException(
 * "not a 5 values split by commas", 0);
 * }
 * 
 * String name = planetInfo[0];
 * int agri = Integer.parseInt(planetInfo[1]);
 * int med = Integer.parseInt(planetInfo[2]);
 * int tech = Integer.parseInt(planetInfo[3]);
 * int cap = Integer.parseInt(planetInfo[4]);
 * 
 * if (!isInSkillRange(agri, med, tech)) {
 * throw new SpaceColonyDataException("not in skill range");
 * }
 * 
 * Planet currentPlanet = new Planet(name, agri, med, tech, cap);
 * planets.enqueue(currentPlanet);
 * count++;
 * 
 * }
 * myReader.close();
 * }
 * catch (FileNotFoundException e) {
 * System.out.println("An error occurred.");
 * e.printStackTrace();
 * }
 * 
 * if (planets.getSize() < 3) {
 * throw new SpaceColonyDataException("Less than 3 planets");
 * }
 * 
 * Planet[] finalPlanets = new Planet[3];
 * 
 * for (int i = 0; i < 3; i++) {
 * finalPlanets[i] = planets.dequeue();
 * }
 * 
 * return finalPlanets;
 */
