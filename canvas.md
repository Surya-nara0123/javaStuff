[back](main.md)

### 1. **What is a Canvas?**
A `Canvas` is a flexible area that allows for drawing shapes, text, and images. You can override its `paint(Graphics g)` method to perform custom drawing whenever the canvas needs to be rendered. The `Canvas` is not interactive by itself, but you can add event listeners to handle user inputs.

### 2. **Creating a Canvas**
To create a `Canvas`, you simply instantiate the `Canvas` class and override the `paint(Graphics g)` method to define the custom drawing logic. You can then add the `Canvas` to a container like a `Frame` or a `Panel`.

Example:
```java
import java.awt.*;
import java.awt.event.*;

public class CanvasExample extends Canvas {
    public void paint(Graphics g) {
        // Drawing a rectangle
        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);

        // Drawing a string
        g.setColor(Color.BLACK);
        g.drawString("Hello, Canvas!", 60, 120);
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Canvas Example");
        Canvas canvas = new CanvasExample();
        canvas.setSize(300, 200);

        frame.add(canvas);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        // Close window on close event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
```

### 3. **Canvas Properties**
- **Size**: Set the size of the `Canvas` using `setSize(int width, int height)`.
- **Background Color**: Set the background color using `setBackground(Color color)`.
- **Foreground Color**: Set the foreground color for drawing using `setForeground(Color color)`.

### 4. **Drawing on the Canvas**
To draw on the `Canvas`, you typically use the `paint(Graphics g)` method, which is called by the AWT framework whenever the `Canvas` needs to be rendered (e.g., when the window is resized or exposed).

Inside the `paint` method, you can:
- Draw shapes: Use methods like `drawRect()`, `fillRect()`, `drawOval()`, `fillOval()`, etc.
- Draw text: Use `drawString(String str, int x, int y)` to display text.
- Draw images: Use `drawImage(Image img, int x, int y, ImageObserver obs)` to render images.

### 5. **Handling User Inputs**
You can make the `Canvas` interactive by adding event listeners to handle mouse clicks, key presses, etc. For example, you can implement `MouseListener` to respond to mouse events.

Example:
```java
canvas.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Get mouse coordinates
        int x = e.getX();
        int y = e.getY();
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }
});
```

### 6. **Example: Custom Drawing on Canvas**
Here's an example demonstrating how to create a `Canvas` and handle mouse clicks to draw circles at the clicked location:

```java
import java.awt.*;
import java.awt.event.*;

public class DrawingCanvas extends Canvas {
    public void paint(Graphics g) {
        // Draw circles on the canvas
    }

    public void drawCircle(Graphics g, int x, int y) {
        g.setColor(Color.BLUE);
        g.fillOval(x - 15, y - 15, 30, 30); // Draw a circle
    }

    public static void main(String[] args) {
        Frame frame = new Frame("Drawing on Canvas");
        DrawingCanvas canvas = new DrawingCanvas();
        canvas.setSize(400, 300);

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Graphics g = canvas.getGraphics();
                canvas.drawCircle(g, e.getX(), e.getY());
            }
        });

        frame.add(canvas);
        frame.setSize(400, 300);
        frame.setVisible(true);

        // Close window on close event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
```

### 7. **Usage Context**
The `Canvas` class is commonly used in applications for:
- Custom graphics rendering, including animations and visualizations.
- Game development, where real-time rendering of shapes and images is required.
- Creating interactive applications where user interactions lead to dynamic visual changes.