package gui;

import Cvorovi.Slot;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class SlotView {

    private Slot slot;
    private Shape shape;

    public SlotView (Slot s){
        this.slot = s;
    }

    public void paint(Graphics2D g){
        shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(slot.getX(),slot.getY());

        ((GeneralPath)shape).lineTo(slot.getX() + slot.getW(), slot.getY());

        ((GeneralPath)shape).lineTo( slot.getX() + slot.getW(),slot.getY() + slot.getH());

        ((GeneralPath)shape).lineTo(slot.getX(),slot.getY() + slot.getH());

        ((GeneralPath)shape).closePath();

        g.setPaint(Color.GREEN);
        g.setStroke(slot.getStroke());
        g.draw(getShape());
        g.setPaint(slot.getColor());
        g.drawRect(slot.getX(), slot.getY(), slot.getW(), slot.getH());
        g.drawString(slot.getName(), slot.getX() + 10, slot.getY() + 10);

        //g.fill(getShape());

    }


    public Shape getShape() {
        return shape;
    }
}
