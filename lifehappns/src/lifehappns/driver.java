package lifehappns;

import java.util.ArrayList;
import java.util.Arrays;

public class driver {

	public static void main(String[] args) {
		ArrayList<String> animals = new ArrayList<String>(Arrays.asList("snake","snake","babycat","cat","dog","dog","dog"));
        lifeHappens(animals);
        System.out.println(animals);

	}

	private static void lifeHappens(ArrayList<String> animals) {
        ArrayList<String> newGeneration = new ArrayList<>();

        for (int i = 0; i < animals.size(); i++) {
            String currentAnimal = animals.get(i);

            if (i < animals.size() - 1 && currentAnimal.equals(animals.get(i + 1))) {
                // Two same animals are next to each other, they make a baby
                newGeneration.add("baby " + currentAnimal);
                i++; // Skip the next animal, as babies don't reproduce
            } else {
                newGeneration.add(currentAnimal);
            }
        }

        // Aging up all babies
        for (int i = 0; i < newGeneration.size(); i++) {
            String currentAnimal = newGeneration.get(i);

            if (currentAnimal.startsWith("baby")) {
                // Remove "baby" prefix and age up
                newGeneration.set(i, currentAnimal.replace("baby ", "") + " (aged up)");
            }
        }
}
