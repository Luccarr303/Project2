import edu.cymbal.graphics.*;
import edu.cymbal.graphics.impl.SwingCanvasImpl;
import java.awt.Color;

// import necessities

public class AlgaeAquarium {

    /**
     * @param x the x coordinate to move to
     * @param y the y coordinate to move to
     * @param t the PainterAPI object used to draw
     */

    static void setPosition(double x, double y, PainterAPI t) {
        // will move the painter to (x, y) without drawing or doing anything extra
        // no other methods will be called in here
    }

    /**
     * @param x      the x coordinate of the circle
     * @param y      the y coordinate of the circle
     * @param radius the radius of the circle
     * @param color  the fill color of the circle
     * @param t      the PainterAPI object used to draw
     */

    static void drawCircleShape(double x, double y, double radius, Color color, PainterAPI t) {
        // draws a filled circle while being placed at (x, y)
        // setPosition method will be called
    }

    /**
     * @param x      the x coordinate of the diamond
     * @param y      the y coordinate of the diamond
     * @param size   the side length of the diamond
     * @param color  the fill color of the diamond
     * @param t      the PainterAPI object used to draw
     */
    static void drawDiamondShape(double x, double y, double size, Color color, PainterAPI t) {
        // draws a filled diamond (a square turned on its corner) placed at (x, y)
        // will call: setPosition
    }

    /**
     * @param x      the x coordinate of the triangle
     * @param y      the y coordinate of the triangle
     * @param size   the side length of the triangle
     * @param color  the fill color of the triangle
     * @param t      the PainterAPI object used to draw
     */
    static void drawTriangleShape(double x, double y, double size, Color color, PainterAPI t) {
        // draw a triangle to represent a tail
        // setPosition method will be called
    }

    /**
     * @param t the PainterAPI object used to draw
     */

    static void drawCircularFish(PainterAPI t) {
        // Draws the two circular fish
        // Each fish has a circle body, a triangle tail and a circle eye
        // The direction of the fish will be seen by the tail and eye placement
        //
        // Loop #1 : repeat 2 times, once for each circular fish
        //   Fish 1 : red, normal size (radius will probably be something like 40)
        //       rough position: left side of the tank, upper area, facing right
        //   Fish 2 : purple, small (radius probably around 20)
        //       rough position: lower right area, facing left
        // Inside the loop for each fish:
        //   draw body : call drawCircleShape
        //   draw tail : call drawTriangleShape
        //   draw eye  : call drawCircleShape 
        //   will call setPosition
    }

    static void drawDiamondFish(PainterAPI t) {
        // Draws the two diamond fish, a big yellow fish and a blue fish
        // Each fish has a diamond body, a triangle tail and a circle eye
        //
        // Loop 2: repeat 2 times, once for each diamond fish
        //   Fish 3: yellow, big (size around 80)
        //       rough position: upper right area, facing left
        //   Fish 4: blue, between small and normal (size aorund 50)
        //       rough position: lower left area, facing right
        // Inside the loop for each fish:
        //   draw body : call drawDiamondShape
        //   draw tail : call drawTriangleShape 
        //   draw eye  : call drawCircleShape  
        //   will call setPosition
    }

    static void drawDecorations(PainterAPI t) {
        // Draws bubbles and a box of fish food (bait)
        //
        // Loop 3: repeat about 5 times to draw multiple bubbles
        //   each bubble will call drawCircleShape
        //   change x/y position each time
        //   rough position: somewhere around
        //   will also call: setPosition
        //
        // Bait box: draw a simple box 
        //   setPosition will be called to move to the bottom of the tank
    }

    public static void main(String[] args) {
        CanvasAPI canvas = new SwingCanvasImpl(800, 600, "Algae Aquarium");

        // background: green water tank (contaminated by algae)
        canvas.setBackgroundColor(Color.GREEN);

        PainterAPI t = canvas.getPainter();
        t.setSpeed(5);

        // setup test: three different PainterAPI calls (delete later)
        t.forward(100);
        t.turnRight(90);
        t.circle(30);

        // main will call these once building starts
        // drawCircularFish(t);
        // drawDiamondFish(t);
        // drawDecorations(t);
    }
}