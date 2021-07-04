
import java.awt.*;
import java.applet.*;

public class Block {
    private int xC;
    private int yC;
    
    private int size;
    private Color color;
    
    public Block(int x, int y, int r, int gr, int b, int s) {
        xC = x;
        yC = y;
        color = new Color(r, gr, b);
        size = s;
    }
    
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(xC, yC, size, size);
    }

}
