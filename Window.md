[back](main.md)
### 1. **What is a Window?**
A `Window` is a lightweight top-level container that can be used to hold other AWT components. It provides a way to create a separate window without the additional features of a frame, such as a title bar and window decorations.

### 2. **Creating a Window**
To create a `Window`, you instantiate the `Window` class and provide a parent `Frame` or `Component` as an argument. You can then add components to the window and control its visibility.

Example:
```java
import java.awt.*;

public class WindowExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Main Frame");
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());

        // Create a window
        Window window = new Window(frame);
        window.setSize(200, 150);
        window.setLayout(new FlowLayout());

        // Add a label to the window
        window.add(new Label("This is a custom window."));

        // Create a button to show the window
        Button showButton = new Button("Show Window");
        showButton.addActionListener(e -> window.setVisible(true));
        frame.add(showButton);

        // Close the main frame
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true); // Make the main frame visible
    }
}
```

### 3. **Window Properties**
- **Size and Layout**: You can set the size and layout of the window using `setSize(int width, int height)` and `setLayout(LayoutManager layout)`.
- **Visibility**: Control the visibility of the window using `setVisible(boolean visible)`.
- **Background and Foreground Colors**: You can customize the appearance of the window with `setBackground(Color color)` and `setForeground(Color color)`.

### 4. **Handling Events**
You can add event listeners to the components inside the window to respond to user interactions, just as you would with other AWT components.

### 5. **Example: Creating a Simple Window**
Here’s a complete example that demonstrates how to create a `Window`, add components, and manage visibility:

```java
import java.awt.*;

public class SimpleWindowDemo extends Frame {
    public SimpleWindowDemo() {
        setTitle("Simple Window Demo");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Create a button to open the window
        Button openWindowButton = new Button("Open Window");
        add(openWindowButton);

        // Create a custom window
        Window window = new Window(this);
        window.setSize(200, 150);
        window.setLayout(new FlowLayout());
        window.add(new Label("This is a custom window."));

        // Add a button to close the window
        Button closeWindowButton = new Button("Close");
        closeWindowButton.addActionListener(e -> window.setVisible(false));
        window.add(closeWindowButton);

        // Show the window on button click
        openWindowButton.addActionListener(e -> window.setVisible(true));

        // Close the main frame
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true); // Make the main frame visible
    }

    public static void main(String[] args) {
        new SimpleWindowDemo();
    }
}
```

### 6. **Customizing Window Appearance**
You can customize the appearance of a `Window` using various methods:
- **setBackground(Color color)**: Sets the background color of the window.
- **setForeground(Color color)**: Sets the foreground (text) color of the window.
- **setFont(Font font)**: Changes the font of the text in the window.

### 7. **Usage Context**
The `Window` class is ideal for situations where you want to create pop-up dialogs or custom windows that do not require standard frame features. Use cases include:
- Tooltips or help windows
- Custom pop-ups for notifications
- Contextual information displays