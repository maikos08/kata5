package software.ulpgc.kata5.arquitecture.io;

import software.ulpgc.kata5.arquitecture.model.Pokemon;

public class PokemonLoader {
    private final PokemonDeserializer deserializer;
    private final PokemonAdapter adapter;
    private final PokemonReader reader;

    public PokemonLoader(PokemonDeserializer deserializer, PokemonAdapter adapter, PokemonReader reader) {
        this.deserializer = deserializer;
        this.adapter = adapter;
        this.reader = reader;
    }

    public Pokemon load() {
        return adapter.adapt(deserializer.deserialize(reader.read()));
    }
}
