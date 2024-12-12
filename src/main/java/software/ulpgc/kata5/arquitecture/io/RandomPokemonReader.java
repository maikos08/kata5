package software.ulpgc.kata5.arquitecture.io;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.Random;

public class RandomPokemonReader implements PokemonReader{
    private final Random random = new Random();


    @Override
    public String read() {
        try {
            int randomPokemonNumber = random.nextInt(1025) + 1;
            String url = "https://pokeapi.co/api/v2/pokemon/" + randomPokemonNumber;
            return read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String read(String url) throws IOException {
        Connection.Response response = Jsoup.connect(url)
                .header("accept", "text/*")
                .ignoreContentType(true)
                .method(Connection.Method.GET)
                .execute();

        return response.body();
    }
}
