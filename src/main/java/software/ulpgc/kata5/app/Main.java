package software.ulpgc.kata5.app;

import software.ulpgc.kata5.arquitecture.control.ToggleCommand;
import software.ulpgc.kata5.arquitecture.io.PokemonLoader;
import software.ulpgc.kata5.arquitecture.io.RandomPokemonAdapter;
import software.ulpgc.kata5.arquitecture.io.RandomPokemonDeserializer;
import software.ulpgc.kata5.arquitecture.io.RandomPokemonReader;

public class Main {

    public static void main(String[] args) {
        PokemonLoader loader = new PokemonLoader(
                new RandomPokemonDeserializer(),
                new RandomPokemonAdapter(),
                new RandomPokemonReader()
        );

        MainFrame mainFrame = new MainFrame();
        mainFrame.put("toggle",
                new ToggleCommand(
                        mainFrame.getDisplay(),
                        loader
                ));
        mainFrame.setVisible(true);
    }
}
