[back](main.md)
### 1. **Loading Images**

In AWT, images can be loaded using the `Toolkit` class, which provides methods for fetching images from various sources like files or URLs.

#### Example: Loading an Image
```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageExample extends Frame {

    Image img;

    public ImageExample() {
        // Load an image using Toolkit
        img = Toolkit.getDefaultToolkit().getImage("path_to_image.jpg");

        setSize(400, 400);
        setVisible(true);

        // Close the window when "X" button is clicked
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // Override paint method to draw the image
    public void paint(Graphics g) {
        // Draw the image at (50, 50) with the original width and height
        g.drawImage(img, 50, 50, this);
    }

    public static void main(String[] args) {
        new ImageExample();
    }
}
```

In this example, the `Toolkit` class is used to load the image, and the `paint()` method is overridden to draw the image on the frame.

### 2. **Drawing Images**
The `Graphics` class provides methods to draw images on components, such as `drawImage()`.

#### Key Methods to Draw an Image:
- `drawImage(Image img, int x, int y, ImageObserver observer)`: Draws the image at the specified `(x, y)` position.
- `drawImage(Image img, int x, int y, int width, int height, ImageObserver observer)`: Scales the image to the specified width and height before drawing.

#### Example: Drawing a Scaled Image
```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScaledImageExample extends Frame {

    Image img;

    public ScaledImageExample() {
        img = Toolkit.getDefaultToolkit().getImage("path_to_image.jpg");

        setSize(500, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        // Draw the image scaled to 300x200
        g.drawImage(img, 50, 50, 300, 200, this);
    }

    public static void main(String[] args) {
        new ScaledImageExample();
    }
}
```

In this example, the image is drawn scaled to 300x200 pixels, regardless of its original size.

### 3. **Double Buffering (For Smooth Drawing)**

When drawing images or other graphics, you might experience flickering. Double buffering can help reduce this flickering by drawing off-screen and then displaying the entire image at once.

#### Example: Double Buffering
```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DoubleBufferingExample extends Frame {

    Image img;
    Image offScreenImage;
    Graphics offScreenGraphics;

    public DoubleBufferingExample() {
        img = Toolkit.getDefaultToolkit().getImage("path_to_image.jpg");

        setSize(400, 400);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void update(Graphics g) {
        // Create off-screen image if necessary
        if (offScreenImage == null) {
            offScreenImage = createImage(getWidth(), getHeight());
            offScreenGraphics = offScreenImage.getGraphics();
        }

        // Clear the off-screen image
        offScreenGraphics.setColor(getBackground());
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        // Draw the image off-screen
        offScreenGraphics.drawImage(img, 50, 50, this);

        // Display the off-screen image
        g.drawImage(offScreenImage, 0, 0, this);
    }

    public static void main(String[] args) {
        new DoubleBufferingExample();
    }
}
```

### 4. **ImageObserver Interface**
The `ImageObserver` interface is used to receive notification about the status of image loading. When drawing images, you can pass the current component (`this`) as the observer, so it knows when to repaint as the image is loaded.

### 5. **Image Scaling and Transformation**
Images can be scaled, rotated, or manipulated using the `Graphics2D` class, which extends `Graphics`. This is useful for more advanced operations on images, such as flipping or rotating.

#### Example: Scaling an Image with `Graphics2D`
```java
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageTransformExample extends Frame {

    Image img;

    public ImageTransformExample() {
        img = Toolkit.getDefaultToolkit().getImage("path_to_image.jpg");

        setSize(500, 500);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Scale the image to half size
        g2d.scale(0.5, 0.5);
        g2d.drawImage(img, 50, 50, this);

        // Reset the transformation to avoid affecting future drawings
        g2d.setTransform(new AffineTransform());
    }

    public static void main(String[] args) {
        new ImageTransformExample();
    }
}
```

### Summary of Important Methods
- **Loading Images**: `Toolkit.getDefaultToolkit().getImage()`
- **Drawing Images**: `Graphics.drawImage()`
- **Scaling and Transforming Images**: Using `Graphics2D`
- **Double Buffering**: To avoid flickering during image rendering.
