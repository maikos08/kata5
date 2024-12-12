package software.ulpgc.kata5.app;

import software.ulpgc.kata5.arquitecure.io.PokemonLoader;
import software.ulpgc.kata5.arquitecure.io.RandomPokemonAdapter;
import software.ulpgc.kata5.arquitecure.io.RandomPokemonDeserializer;
import software.ulpgc.kata5.arquitecure.io.RandomPokemonReader;

public class Main {

    public static void main(String[] args) {
        PokemonLoader loader = new PokemonLoader(
                new RandomPokemonDeserializer(),
                new RandomPokemonAdapter(),
                new RandomPokemonReader()
        );

        for (int i = 0; i < 5; i++) {
            System.out.println(loader.load().name());
        }
    }
}
