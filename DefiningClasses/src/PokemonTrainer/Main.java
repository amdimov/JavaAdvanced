package PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Trainer> pokemonMap = new LinkedHashMap<>();
        String[] tokens = scanner.readLine().split("\\s+");

        while (!tokens[0].equals("Tournament")){
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Trainer trainer = pokemonMap.get(trainerName);
            if (trainer == null){
                trainer = new Trainer(trainerName, new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            }else {
                trainer.addNewPokemon(new Pokemon(pokemonName, pokemonElement, pokemonHealth));
            }
            pokemonMap.put(trainerName, trainer);
            tokens = scanner.readLine().split("\\s+");
        }

        String elementLine = scanner.readLine();

        while (!elementLine.equals("End")){
            for (Map.Entry<String, Trainer> trainerEntry : pokemonMap.entrySet()) {
                boolean isElementFound = false;
                for (Pokemon pokemon : trainerEntry.getValue().getPokemons()) {
                    if (pokemon.getPokemonElement().equals(elementLine)){
                        trainerEntry.getValue().increseBadge();
                        isElementFound = true;
                        break;
                    }
                }
                if (!isElementFound){
                    trainerEntry.getValue().reduceHealth();
                    trainerEntry.getValue().removePokemon();
                }
            }
            elementLine = scanner.readLine();
        }
        pokemonMap.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue().getBadges(), a.getValue().getBadges()))
                .forEach(e -> System.out.println(e.getValue()));
    }
}












