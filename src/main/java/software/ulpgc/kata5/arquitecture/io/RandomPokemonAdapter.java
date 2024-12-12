package software.ulpgc.kata5.arquitecture.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import software.ulpgc.kata5.arquitecture.io.pojos.RandomPokemonGetResponse;
import software.ulpgc.kata5.arquitecture.model.Pokemon;

import java.io.IOException;

public class RandomPokemonAdapter implements PokemonAdapter{
    @Override
    public Pokemon adapt(Object o) {
        RandomPokemonGetResponse response = (RandomPokemonGetResponse) o;
        try {
            return adaptResponse(response);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Pokemon adaptResponse(RandomPokemonGetResponse response) throws IOException {
        return new Pokemon(
                response.name(),
                arrayBytesOf(response.sprites().front_default()),
                arrayBytesOf(response.sprites().back_default()),
                arrayBytesOf(response.sprites().front_shiny()),
                arrayBytesOf(response.sprites().back_shiny())
        );
    }

    private byte[] arrayBytesOf(String imageUrl) throws IOException {
        if (imageUrl == null) return new byte[0];

        return Jsoup.connect(imageUrl)
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute()
                .bodyAsBytes();
    }
}
