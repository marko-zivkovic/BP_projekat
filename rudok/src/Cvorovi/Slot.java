package Cvorovi;

import javax.swing.text.Position;
import java.awt.*;

public class Slot {

    private Stroke stroke;
    private String name;
    private int x;
    private int y;
    private int h;
    private int w;
    protected Dimension size;
    protected Point position;
    private Paint color;

    public Slot (Stroke st, String ime, int x, int y, int h, int w, Paint p )
    {
        this.color = p;
        this.h = h;
        this.w = w;
        this.x = x;
        this.y = y;
        this.name = ime;
        this.stroke = st;
        size = new Dimension(w,h);
        position = new Point(x,y);

    }


    public Stroke getStroke() {return stroke;}
    public String getName() {return name;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getH() {return h;}
    public int getW() {return w;}
    public Dimension getSize() {return size;}
    public Point getPosition() {return position;}
    public Paint getColor() {return color;}
}
