[back](main.md)
### 1. **What is an Event?**
An event is an occurrence that happens in the application, usually triggered by user interaction. Examples include:
- Mouse movements or clicks
- Keyboard presses
- Window resizing or closing
- Component actions (like button presses)

### 2. **Event Sources**
An event source is an object that generates events. In AWT, components such as buttons, text fields, and windows act as event sources. For example, a button can generate an `ActionEvent` when clicked.

### 3. **Event Listeners**
An event listener is an interface that defines methods for handling specific types of events. When an event occurs, the corresponding listener method is invoked. A listener must be registered with an event source to receive notifications about events.

### 4. **Common Event Listener Interfaces**
Here are some common event listener interfaces in AWT:
- **ActionListener**: Handles action events (e.g., button clicks).
- **MouseListener**: Handles mouse events (e.g., clicks, presses, releases).
- **KeyListener**: Handles keyboard events (e.g., key presses, releases).
- **WindowListener**: Handles window events (e.g., opening, closing, activating).

### 5. **Adding Event Listeners**
To handle events, you need to:
1. Create a class that implements the appropriate event listener interface.
2. Override the methods defined in the interface to specify the action taken when the event occurs.
3. Register the listener with the event source.

### 6. **Example: Handling Button Clicks**
Here’s a simple example demonstrating how to handle a button click event using `ActionListener`:

```java
import java.awt.*;
import java.awt.event.*;

public class EventHandlingExample extends Frame {
    public EventHandlingExample() {
        // Create a button
        Button button = new Button("Click Me");
        button.setBounds(100, 100, 100, 30);

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button was clicked!");
            }
        });

        // Add the button to the frame
        add(button);

        // Set frame properties
        setSize(300, 200);
        setLayout(null);
        setVisible(true);

        // Close window on close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new EventHandlingExample();
    }
}
```

### 7. **Example: Handling Mouse Events**
Here’s an example of handling mouse events using `MouseListener`:

```java
import java.awt.*;
import java.awt.event.*;

public class MouseEventExample extends Frame {
    public MouseEventExample() {
        // Set frame properties
        setSize(300, 200);
        setLayout(null);
        setVisible(true);

        // Add MouseListener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
            }
        });

        // Close window on close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new MouseEventExample();
    }
}
```

### 8. **Example: Handling Key Events**
Here’s how to handle keyboard events using `KeyListener`:

```java
import java.awt.*;
import java.awt.event.*;

public class KeyEventExample extends Frame {
    public KeyEventExample() {
        // Set frame properties
        setSize(300, 200);
        setLayout(null);
        setVisible(true);

        // Add KeyListener to the frame
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar());
            }
        });

        // Close window on close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new KeyEventExample();
    }
}
```

### 9. **Event Propagation**
In AWT, events propagate through the component hierarchy. For example, if a mouse event occurs on a button that is inside a panel, the event is first delivered to the button, and if not handled, it can propagate up to the panel and then to the frame.

[event Hierarchy](eventHierarchy.md)