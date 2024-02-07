package FirstGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartScreen extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton startButton;
    private JButton exitButton;
    private JPanel panel;
    private Game game;
    private Clip clip;

    public StartScreen() {
        setTitle("Space Shooter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the space background image
                Image spaceImg = new ImageIcon("space.jpg").getImage();
                g.drawImage(spaceImg, 0, 0, getWidth(), getHeight(), this);

                // Draw the game title
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 32));
                g.drawString("Space Shooter", 150, 100);
            }
        };

        startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to start your game and close the StartScreen
                startGame();
                dispose();
            }
        });

        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Terminate the program when the exit button is clicked
            }
        });

        panel.setLayout(null);
        startButton.setBounds(200, 200, 100, 50);
        exitButton.setBounds(200, 260, 100, 50);
        panel.add(startButton);
        panel.add(exitButton);
        add(panel);
        setVisible(true);

        // Load the background music
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("backgroundMusic.wav")));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private void startGame() {
        // Initialize your game object
        Game game = new Game();
        game.main();

        // Stop the background music when the game starts
        clip.stop();
    }

    public static void main(String[] args) {
        new StartScreen();
    }
}
