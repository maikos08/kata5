package software.ulpgc.kata5.arquitecure.model;

public record Pokemon(
        String name,
        byte[] frontSpriteDefault,
        byte[] backSpriteDefault,
        byte[] frontSpriteShiny,
        byte[] backSpriteShiny
) {
}