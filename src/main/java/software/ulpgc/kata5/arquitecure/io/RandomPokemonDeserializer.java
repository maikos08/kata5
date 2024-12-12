package software.ulpgc.kata5.arquitecure.io;

import com.google.gson.Gson;
import software.ulpgc.kata5.arquitecure.io.pojos.RandomPokemonGetResponse;

public class RandomPokemonDeserializer implements PokemonDeserializer{
    @Override
    public Object deserialize(String json) {
        return new Gson().fromJson(json, RandomPokemonGetResponse.class);
    }
}
