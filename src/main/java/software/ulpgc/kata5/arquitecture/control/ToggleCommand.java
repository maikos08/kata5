package software.ulpgc.kata5.arquitecture.control;

import software.ulpgc.kata5.arquitecture.io.PokemonLoader;
import software.ulpgc.kata5.arquitecture.view.PokemonDisplay;

public class ToggleCommand implements Command{
    private final PokemonDisplay display;
    private final PokemonLoader loader;

    public ToggleCommand(PokemonDisplay display, PokemonLoader loader) {
        this.display = display;
        this.loader = loader;
    }

    @Override
    public void execute() {
        display.show(loader.load());
    }
}
