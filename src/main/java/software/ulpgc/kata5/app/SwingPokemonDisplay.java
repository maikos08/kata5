package software.ulpgc.kata5.app;

import software.ulpgc.kata5.arquitecture.model.Pokemon;
import software.ulpgc.kata5.arquitecture.view.PokemonDisplay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.function.BiConsumer;


public class SwingPokemonDisplay extends JPanel implements PokemonDisplay {

    public static final int WIDTH = 250;
    public static final int HEIGHT = 250;
    private final JPanel normalPanel = new JPanel();
    private final JPanel shinyPanel = new JPanel();
    private final JLabel pokemonNameLabel = new JLabel("", SwingConstants.CENTER);

    public SwingPokemonDisplay() {
        setLayout(new BorderLayout(10, 10));

        pokemonNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(pokemonNameLabel, BorderLayout.NORTH);

        JPanel splitPanel = new JPanel();
        splitPanel.setLayout(new GridLayout(1, 2, 10, 10));

        addSplitPanel(normalPanel, "NORMAL FORM", splitPanel);
        addSplitPanel(shinyPanel, "SHINY FORM", splitPanel);

        add(splitPanel, BorderLayout.CENTER);
    }

    private void addSplitPanel(JPanel panel, String title, JPanel splitPanel) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        splitPanel.add(panel);
    }


    @Override
    public void show(Pokemon pokemon) {
        pokemonNameLabel.setText(pokemon.name());
        shinyPanel.removeAll();
        normalPanel.removeAll();

        BiConsumer<byte[], JPanel> addSpritePanel = (sprite, panel) -> {
            if (spriteExist(sprite)) {
                panel.add(getSpritePanel(sprite));
            }
        };

        addSpritePanel.accept(pokemon.frontSpriteDefault(), normalPanel);
        addSpritePanel.accept(pokemon.backSpriteDefault(), normalPanel);

        addSpritePanel.accept(pokemon.frontSpriteShiny(), shinyPanel);
        addSpritePanel.accept(pokemon.backSpriteShiny(), shinyPanel);

        revalidate();
        repaint();

    }

    private boolean spriteExist(byte[] sprite) {
        return !(Arrays.equals(sprite, new byte[0]));
    }


    private JPanel getSpritePanel(byte[] sprite) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel imageLabel = new JLabel();

        setImageToLabel(imageLabel, sprite);

        panel.add(imageLabel, BorderLayout.CENTER);
        return panel;
    }

    private void setImageToLabel(JLabel label, byte[] sprite) {
        try {
            Image image = ImageIO.read(new ByteArrayInputStream(sprite));
            if (image != null)
                label.setIcon(new ImageIcon(image.getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH)));
            else
                label.setText("Image not available");

        } catch (Exception e) {
            label.setText("Image not available");
            e.printStackTrace();
        }
    }

}
