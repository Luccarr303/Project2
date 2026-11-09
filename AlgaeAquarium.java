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
        t.liftPen();
        t.moveTo(x, y);
        t.lowerPen();
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
        setPosition(x, y - radius, t);  // the circle is shifted up since it starts the drawing at the bottom of the circle
        t.startFill(color);
        t.circle(radius);
        t.finishFill();
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
        setPosition(x, y, t);
        t.startFill(color);
        t.turnLeft(45);
        for (int i = 0; i < 4; i++) {
            t.forward(size);
            t.turnRight(90);
        }
        t.turnRight(45);
        t.finishFill();
    }

    /**
     * @param x      the x coordinate of the triangle
     * @param y      the y coordinate of the triangle
     * @param size   the side length of the triangle
     * @param color  the fill color of the triangle
     * @param t      the PainterAPI object used to draw
     */
    static void drawTriangleRight(double x, double y, double size, Color color, PainterAPI t) {
        // draw a triangle to represent a tail
        setPosition(x, y, t);
        t.startFill(color);
        t.turnRight(150);
        for (int i = 0; i < 3; i++) {
            t.forward(size);
            t.turnRight(120);
        }
        t.finishFill();
        t.turnLeft(150);
    }   

    // Same thing just flipped for left Fish

    static void drawTriangleLeft(double x, double y, double size, Color color, PainterAPI t) {
        // draw a triangle to represent a left facing fishtail 
        setPosition(x, y, t);
        t.startFill(color);
        t.turnRight(30);
        for (int i = 0; i < 3; i++) {
            t.forward(size);
            t.turnLeft(120);
        }
        t.finishFill();
        t.turnLeft(30);
    }

    /**
     * @param t the PainterAPI object used to draw
     */

    static void drawCircularFish(PainterAPI t) {
        // Draws the two circular fish
        // Each fish has a circle body, a triangle tail and a circle eye
        // The direction of the fish will be seen by the tail and eye placement

        drawCircleShape(-225, 170, 40, Color.RED, t);
        drawTriangleRight(-265, 170, 40, Color.RED, t);
        drawCircleShape(-205, 190, 8, Color.BLACK, t);

        drawCircleShape(170, -45, 20, new Color(128, 0, 128), t); //purple
        drawTriangleLeft(190, -45, 20, new Color(128, 0, 128), t);
        drawCircleShape(160, -35, 4, Color.BLACK, t);
    }

    static void drawDiamondFish(PainterAPI t) {
        // Draws the two diamond fish, a big yellow fish and a blue fish
        // Each fish has a diamond body, a triangle tail and a circle eye
    
        drawDiamondShape(-5, 155, 80, Color.YELLOW, t);
        drawTriangleLeft(107, 155, 80, Color.YELLOW, t);
        drawCircleShape(35, 171, 8, Color.BLACK, t);

        drawDiamondShape(-220, -77, 50, Color.BLUE, t);
        drawTriangleRight(-220, -77, 50, Color.BLUE, t);
        drawCircleShape(-175, -67, 5, Color.BLACK, t);
    }

    static void drawDecorations(PainterAPI t) {
        // Draws bubbles and a box of fish food (bait)

        for (int i = 0; i < 5; i++) {
            drawCircleShape(-125 + i * 10, -70 + i * 50, 6 + i * 2, Color.WHITE, t);  // creates the effect of the bubbles floating up
        }

        // box of fish bait

        setPosition(-40, -280, t);
        t.startFill(new Color(139, 69, 19)); // brown
        for (int j = 0; j < 4; j++) {
            t.forward(80);
            t.turnLeft(90);
        }
        t.finishFill();
    }

    public static void main(String[] args) {
        CanvasAPI canvas = new SwingCanvasImpl(800, 600, "Algae Aquarium");

        // background: green water tank (contaminated by algae)
        canvas.setBackgroundColor(Color.GREEN);

        PainterAPI t = canvas.getPainter();
        t.setSpeed(5);
        // Draw the fish and decorations
        drawCircularFish(t);
        drawDiamondFish(t);
        drawDecorations(t);
    }
}