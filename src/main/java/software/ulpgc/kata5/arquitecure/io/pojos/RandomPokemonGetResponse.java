package software.ulpgc.kata5.arquitecure.io.pojos;

public record RandomPokemonGetResponse(
        String name,
        Sprite sprites
) {
    public record Sprite(
            String front_default,
            String back_default,
            String front_shiny,
            String back_shiny
    ) {
    }
}
