import javax.swing.*;
import java.awt.*;
import java.lang.Thread;
import java.util.ArrayList;

public class Main extends JFrame {

    Bird bird = new Bird();
    ArrayList<Pipe> pipes = new ArrayList<>();
    int score = 0;
    int frameCount = 1;

    public Main() {
        super("Flappy Bird");
        getContentPane().setBackground(Color.green);
        setSize(400, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        this.addKeyListener(new KeyController(bird));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        bird.draw(g);
        bird.update(pipes);

        score = bird.score(this.score, pipes);

        for (int i = 0; i < pipes.size(); i++) {
            pipes.get(i).update();
            pipes.get(i).draw(g);
            if (pipes.get(i).x <= -150) {
                pipes.remove(0);
            }
        }
        if (frameCount % 100 == 0) {
            frameCount = 1;
            pipes.add(new Pipe());
        }

        g.setColor(Color.white);
        g.setFont(new Font("Consolas", Font.PLAIN, 50));
        g.drawString(Integer.toString(score), 50, 100);

        try {
            frameCount++;
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Main main = new Main();
            }
        });
    }
}
