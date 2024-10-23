[back](main.md)
### 1. **What is a Button?**
A `Button` is a user interface element that users can click to perform a specific action. It can display a text label, an icon, or both, and it can be used in various contexts within a window or a panel.

### 2. **Creating a Button**
To create a button, you instantiate the `Button` class and provide a label as a string. You can also create a button without a label.

Example:
```java
import java.awt.*;

public class ButtonExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Button Example");
        Button button = new Button("Click Me"); // Create a button with a label

        frame.add(button); // Add button to the frame
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **Button Properties**
- **Label**: The text displayed on the button. You can set or change the label using `setLabel(String label)` or during instantiation.
- **Enabled State**: Buttons can be enabled or disabled, controlling whether they can be interacted with. Use `setEnabled(boolean enabled)` to change this state.
- **Background and Foreground Colors**: You can customize the button's appearance by setting its background and foreground (text) colors using `setBackground(Color color)` and `setForeground(Color color)`.

### 4. **Handling Events**
To respond to button clicks, you need to add an `ActionListener` to the button. An `ActionListener` is an interface that requires implementing the `actionPerformed(ActionEvent e)` method, which is called when the button is clicked.

Example:
```java
button.addActionListener(e -> {
    System.out.println("Button clicked!");
});
```

### 5. **Example: Creating a Button with an Action Listener**
Here’s a complete example that demonstrates how to create a button, add it to a frame, and handle the button click event:

```java
import java.awt.*;
import java.awt.event.*;

public class ButtonDemo extends Frame {
    public ButtonDemo() {
        setTitle("Button Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        Button button = new Button("Click Me!"); // Create a button

        // Add action listener to the button
        button.addActionListener(e -> {
            System.out.println("Button was clicked!");
        });

        // Add button to the frame
        add(button);

        // Close window on close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new ButtonDemo();
    }
}
```

### 6. **Button Styles and Customization**
You can customize the button's appearance using various methods:
- **setFont(Font font)**: Changes the font of the button text.
- **setSize(int width, int height)**: Sets the size of the button.
- **setLayout(LayoutManager mgr)**: While buttons themselves do not manage layout, the container (like a panel or frame) can have its layout set to organize buttons effectively.

### 7. **Types of Buttons**
- **Default Button**: This is typically highlighted and performs an action when the user presses Enter. You can set a button as the default by using the `setDefaultButton()` method in some UI contexts.
- **Toggle Button**: A button that can be in one of two states: pressed (on) or released (off). While AWT does not have a built-in toggle button, you can implement this functionality using a standard button with a custom action listener to manage its state.

### 8. **Disabling a Button**
You can disable a button, making it unresponsive to user interactions. This can be useful in scenarios where certain actions cannot be performed until specific conditions are met.

Example:
```java
button.setEnabled(false); // Disables the button
```

### 9. **Example: A Button with State Management**
Here’s an example demonstrating a toggle-like behavior with a button:

```java
import java.awt.*;
import java.awt.event.*;

public class ToggleButtonExample extends Frame {
    private boolean isOn = false;

    public ToggleButtonExample() {
        setTitle("Toggle Button Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

        Button toggleButton = new Button("Turn On");

        toggleButton.addActionListener(e -> {
            isOn = !isOn; // Toggle the state
            if (isOn) {
                toggleButton.setLabel("Turn Off");
                toggleButton.setBackground(Color.GREEN);
            } else {
                toggleButton.setLabel("Turn On");
                toggleButton.setBackground(Color.RED);
            }
        });

        add(toggleButton);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ToggleButtonExample();
    }
}
```