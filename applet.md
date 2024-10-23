[back](main.md)

In Java AWT, an `Applet` is a small application that can be embedded within a web page and run in a web browser. Applets are designed to provide interactive features on websites, such as animations or simple games. However, it's worth noting that applets are now largely deprecated and not widely supported in modern browsers.

### 1. **What is an Applet?**
An `Applet` is a subclass of the `java.applet.Applet` class (or `javax.swing.JApplet` in Swing). It is a Java program that can be executed within the context of a web browser or applet viewer. Applets typically have a graphical user interface (GUI) and can respond to user interactions.

### 2. **Creating an Applet**
To create an applet, you subclass the `Applet` class and override its lifecycle methods: `init()`, `start()`, `stop()`, and `destroy()`. The `init()` method is used for initializing the applet, `start()` is called when the applet is started, `stop()` is called when it is stopped, and `destroy()` is called when the applet is destroyed.

Example:
```java
import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {
    public void init() {
        // Initialization code
        setBackground(Color.LIGHT_GRAY);
    }

    public void paint(Graphics g) {
        // Drawing code
        g.setColor(Color.BLUE);
        g.drawString("Hello, Applet!", 20, 20);
    }
}
```

### 3. **Applet Lifecycle**
- **`init()`**: Called once when the applet is first loaded. It is used for initialization tasks, such as setting up the user interface or loading resources.
- **`start()`**: Called after `init()`, or when the applet is restarted. It is used for starting animations or threads.
- **`stop()`**: Called when the user navigates away from the page containing the applet. It is used to pause animations or save state.
- **`destroy()`**: Called when the applet is no longer needed. It is used for cleanup tasks.

### 4. **Embedding an Applet in HTML**
To run an applet in a web browser, you need to embed it in an HTML page using the `<applet>` tag (though this tag is deprecated). Here’s an example:

```html
<!DOCTYPE html>
<html>
<head>
    <title>Applet Example</title>
</head>
<body>
    <applet code="SimpleApplet.class" width="300" height="300"></applet>
</body>
</html>
```

### 5. **Working with Graphics in Applets**
In the `paint(Graphics g)` method, you can use various graphics methods to draw shapes, text, and images. For example:
- `g.drawRect(int x, int y, int width, int height)` to draw a rectangle.
- `g.fillRect(int x, int y, int width, int height)` to fill a rectangle with color.
- `g.drawString(String str, int x, int y)` to display text.

### 6. **User Interaction**
You can handle user input in applets by adding event listeners. For example, to handle mouse clicks, you can implement `MouseListener` or override `mouseClicked(MouseEvent e)`.

### 7. **Limitations and Deprecation**
- **Browser Support**: Most modern browsers no longer support Java applets due to security concerns and the rise of alternative technologies (such as HTML5, CSS3, and JavaScript).
- **Security Restrictions**: Applets run in a restricted environment (sandbox) that limits their access to the local filesystem and network, which can restrict functionality.

### 8. **Conclusion**
Although applets were once a popular way to provide interactive features on web pages, they have fallen out of favor due to security issues and the emergence of more modern web technologies. Understanding applets can provide insight into Java's graphical capabilities and event handling, but students should focus on more current technologies for web development.

By mastering applets, students will gain an understanding of the historical context of Java in web applications, but they should also be encouraged to explore modern alternatives for building interactive web applications.