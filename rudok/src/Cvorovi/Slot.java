package Cvorovi;

import javax.swing.text.Position;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.io.Serializable;

public class Slot implements Serializable {

    private Stroke stroke;
    private String name;
    private int x;
    private int y;
    private int h;
    private int w;
    protected Dimension size;
    protected Point position;
    private Paint color;
    private SlotComponent slotComponent;

    public Slot (Stroke st, int x, int y, int h, int w,Paint fill)
    {
        this.color = fill;
        this.h = h;
        this.w = w;
        this.x = x;
        this.y = y;
        //this.name = ime;
        this.stroke = st;
        size = new Dimension(w,h);
        position = new Point(x,y);
        this.name = "Slot";
        slotComponent = SlotComponent.getInstance();

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
