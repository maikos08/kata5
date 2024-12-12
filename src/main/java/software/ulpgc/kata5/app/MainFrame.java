package software.ulpgc.kata5.app;

import software.ulpgc.kata5.arquitecture.control.Command;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private final Map<String, Command> commands;
    private final SwingPokemonDisplay display;

    public MainFrame() {
        commands = new HashMap<>();
        setLayout(new BorderLayout());
        setTitle("Kata_5");
        setSize(900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(BorderLayout.CENTER, display = new SwingPokemonDisplay());
        add(BorderLayout.SOUTH, button());
    }

    private Component button() {
        JButton button = new JButton("Generate a Pokemon");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (commands.containsKey("toggle"))
                    commands.get("toggle").execute();
            }
        });
        return button;
    }

    public SwingPokemonDisplay getDisplay() {
        return display;
    }

    public void put(String key, Command value) {
        commands.put(key, value);
    }
}
