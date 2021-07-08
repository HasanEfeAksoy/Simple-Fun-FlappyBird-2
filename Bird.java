import java.awt.*;
import java.util.ArrayList;

public class Bird {

    float x = 50.0f, y = 200.0f, r = 20.0f, gravity = 0.6f, velocity = 0.0f, jumpForce = 12.0f;
    float R = this.r + (this.r / 3);
    int score = 0;

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // draw
        g2d.setColor(Color.red);
        g2d.fillOval((int)this.x, (int)this.y, (int)this.r, (int)this.r);
        g2d.drawOval((int)this.x, (int)this.y, (int)this.r, (int)this.r);
    }

    public void update(ArrayList<Pipe> pipes) {
        this.velocity += this.gravity;
        this.velocity *= 0.9f;
        this.y += this.velocity;
        if (this.y - R <= 0 || this.y + R >= 400) {
            this.y = 200;
            pipes.clear();
            this.score = 0;
        }
        for (int i = 0; i < pipes.size(); i++) {
            if ((this.x + this.r >= pipes.get(i).x && this.x <= pipes.get(i).x + pipes.get(i).w) && ((this.y <= pipes.get(i).y + pipes.get(i).h) || (this.y + this.r >= pipes.get(i).y + 480))) {
                this.y = 200;
                pipes.clear();
                this.score = 0;
            }
        }
    }

    public int score(int score, ArrayList<Pipe> pipes) {
        for (int i = 0; i < pipes.size(); i++) {
            if (pipes.get(i).x == this.x) {
                this.score ++;
            }
        }
        return this.score;
    }


    public void jump() {
        this.velocity -= this.jumpForce;
    }
}
