package PokemonTrainer;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String trainerName;
    private int badges;
    private HashSet<Pokemon> pokemons;

    public Trainer(String trainerName, Pokemon pokemon) {
        this.trainerName = trainerName;
        this.badges = 0;
        this.pokemons = new HashSet<>();
        this.pokemons.add(pokemon);
    }
    public void addNewPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void removePokemon(){
        pokemons.removeIf(pokemon -> pokemon.getPokemonHealth() <= 0);
    }
    public void reduceHealth(){
        for (Pokemon pokemon : pokemons) {
            pokemon.setPokemonHealth();
        }
    }
    public void increseBadge(){
        this.badges++;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public HashSet<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(HashSet<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
    public boolean checkIfCardIsDead(){
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getPokemonHealth() <= 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getTrainerName(), this.getBadges(), this.getPokemons().size());
    }
}
