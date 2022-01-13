package gui;

import Cvorovi.Slot;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class SlotView {

    private Slot slot;
    private Shape shape;
    private Paint boja;
    private SlotHendler slotHendler;

    public SlotView (Slot s){
        this.slot = s;
        this.boja = s.getColor();
        shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(slot.getX(),slot.getY());

        ((GeneralPath)shape).lineTo(slot.getX() + slot.getW(), slot.getY());

        ((GeneralPath)shape).lineTo( slot.getX() + slot.getW(),slot.getY() + slot.getH());

        ((GeneralPath)shape).lineTo(slot.getX(),slot.getY() + slot.getH());

        ((GeneralPath)shape).closePath();
    }

    public void paint(Graphics2D g){

        g.setPaint(Color.GREEN);
        g.setStroke(slot.getStroke());
        g.draw(getShape());
        g.setPaint(boja);
        g.drawRect(slot.getX(), slot.getY(), slot.getW(), slot.getH());
        g.drawString(slot.getName(), slot.getX() + 10, slot.getY() + 10);

        g.fill(getShape());

    }


    public Shape getShape() {
        return shape;
    }
}
