import java.awt.*;
import java.awt.geom.*;
/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */
public class Circle{
    public static double PI=3.1416;
    private int diameter;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(int diametro,int xPosicion,int yPosicion,String color){
        this.diameter = diametro;
        this.xPosition = xPosicion;
        this.yPosition = yPosicion;
        this.color = color;
        makeVisible();
    }
    
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }
    
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }
    
    public void slowMoveHorizontal(int distance){
        int delta;
        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }
    
    private void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, new Ellipse2D.Double(xPosition, yPosition, diameter, diameter));
            canvas.wait(10);
        }
    }

    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}