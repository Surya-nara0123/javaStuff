### Colors in Java AWT

Colors in Java AWT are used to specify the color of various graphical components, such as shapes, text, and backgrounds. The `Color` class in AWT provides a wide range of predefined colors as well as the ability to create custom colors.

#### 1. **Color Class**
The `Color` class is part of the `java.awt` package and allows you to define colors using RGB (Red, Green, Blue) values or predefined constants.

#### 2. **Creating Colors**
You can create colors in several ways:

- **Predefined Colors**: Java provides a set of predefined color constants in the `Color` class. Examples include:
  - `Color.RED`
  - `Color.GREEN`
  - `Color.BLUE`
  - `Color.BLACK`
  - `Color.WHITE`
  - `Color.YELLOW`
  
- **Custom Colors**: You can create a custom color using RGB values. Each component (R, G, B) can range from 0 to 255.
  
  ```java
  Color customColor = new Color(150, 100, 200); // RGB values
  ```

- **Using Alpha (Transparency)**: You can also create colors with transparency (alpha value), where 0 is fully transparent and 255 is fully opaque.
  
  ```java
  Color semiTransparentColor = new Color(255, 0, 0, 128); // Red with 50% transparency
  ```

#### 3. **Setting Colors**
To set the color for drawing operations, you use the `setColor(Color c)` method of the `Graphics` object.

Example:
```java
Graphics g = getGraphics();
g.setColor(Color.BLUE); // Set color to blue
g.fillRect(50, 50, 100, 100); // Draw a filled rectangle
```

#### 4. **Using Colors in Painting**
Colors are commonly used in the `paint(Graphics g)` method to customize the appearance of graphical components.

Example:
```java
import java.awt.*;

public class ColorExample extends Frame {
    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(20, 20, 100, 100); // Red rectangle
        
        g.setColor(Color.GREEN);
        g.fillOval(150, 20, 100, 100); // Green circle
        
        g.setColor(Color.BLUE);
        g.drawString("Colored Text", 20, 150); // Blue text
    }

    public static void main(String[] args) {
        ColorExample frame = new ColorExample();
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

### Fonts in Java AWT

Fonts in Java AWT are used to define the appearance of text rendered in graphical components. The `Font` class provides methods to create and manipulate fonts.

#### 1. **Font Class**
The `Font` class is part of the `java.awt` package and represents a specific typeface and style for rendering text. It includes properties such as font name, style, and size.

#### 2. **Creating Fonts**
You can create a font using the `Font` constructor:

```java
Font font = new Font("Arial", Font.BOLD, 16); // Font name, style, size
```

Styles can be:
- `Font.PLAIN`
- `Font.BOLD`
- `Font.ITALIC`
- `Font.BOLD | Font.ITALIC` (for both bold and italic)

#### 3. **Setting Fonts**
To set the font for drawing text, you use the `setFont(Font font)` method of the `Graphics` object.

Example:
```java
Graphics g = getGraphics();
g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
g.drawString("Hello, World!", 50, 50);
```

#### 4. **Using Fonts in Painting**
Fonts are commonly used in the `paint(Graphics g)` method to customize the appearance of text.

Example:
```java
import java.awt.*;

public class FontExample extends Frame {
    public void paint(Graphics g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Bold Text", 20, 50);
        
        g.setFont(new Font("Courier New", Font.ITALIC, 16));
        g.setColor(Color.BLUE);
        g.drawString("Italic Text", 20, 100);
        
        g.setFont(new Font("Verdana", Font.PLAIN, 18));
        g.setColor(Color.RED);
        g.drawString("Plain Text", 20, 150);
    }

    public static void main(String[] args) {
        FontExample frame = new FontExample();
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