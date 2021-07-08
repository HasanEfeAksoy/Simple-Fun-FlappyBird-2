import java.awt.*;

public class Pipe {

    // random -350.0f , -110.0f
    // (Math.random() * ((max - (-350.0f)) + 1)) + (-350.0f)
    float x = 400.0f, y = (float) ((Math.random() * (((-110.0f) - (-350.0f)) + 1)) + (-350.0f)), w = 20.0f, h = 400.0f;

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // draw
        g2d.setColor(Color.blue);
        g2d.fillRect((int)this.x, (int)this.y, (int)this.w, (int)this.h);
        g2d.fillRect((int)this.x, (int)this.y + 480, (int)this.w, (int)this.h);

        g2d.drawRect((int)this.x, (int)this.y, (int)this.w, (int)this.h);
        g2d.drawRect((int)this.x, (int)this.y + 480, (int)this.w, (int)this.h);
    }

    public void update() {
        this.x --;
    }
}
