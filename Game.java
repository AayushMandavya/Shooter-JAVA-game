package FirstGame;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import java.io.File;

public class Game {
    private static JFrame window;
    private static GamePanel gamePanel;
    public Clip clip;
    public Game() {
    }
    public void main() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File("backgroundMusic.wav")));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
//        JFrame window = new JFrame("Shooting Game");
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        window.pack();
//        window.setContentPane(new GamePanel());
//        window.setResizable(false);
//        window.setVisible(true);
//        window.pack();
        window = new JFrame("Shooting Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel(this, window, clip);  // Pass the Game instance to the GamePanel
        window.setContentPane(gamePanel);
        window.setResizable(false);
        window.pack();
        window.setVisible(true);

    }
    // Method to restart the game

}
