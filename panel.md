[back](main.md)

### 1. **What is a Panel?**
A `Panel` is a subclass of `Container` that provides a space for placing components. It does not have a title bar, borders, or buttons like a `Frame`, making it suitable for grouping components within a `Frame` or another container.

### 2. **Creating a Panel**
To create a panel, you simply instantiate the `Panel` class. You can then add components to it and set a layout manager to control the arrangement of those components.

Example:
```java
import java.awt.*;

public class MyPanelExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Panel Example");
        Panel panel = new Panel();

        panel.setLayout(new FlowLayout()); // Set layout manager for the panel

        // Create and add components to the panel
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        panel.add(button1);
        panel.add(button2);

        // Add the panel to the frame
        frame.add(panel);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
```

### 3. **Layout Management**
Panels support various layout managers, allowing you to control how components are arranged within them. Commonly used layout managers with panels include:
- **FlowLayout**: Components are arranged in a left-to-right flow, wrapping to the next line as needed.
- **BorderLayout**: Divides the panel into five areas (North, South, East, West, Center).
- **GridLayout**: Arranges components in a grid of specified rows and columns.
- **GridBagLayout**: A more flexible and complex layout manager that allows for varying sizes of components.

Example of setting a layout manager:
```java
panel.setLayout(new GridLayout(2, 2)); // 2 rows and 2 columns
```

### 4. **Adding Components**
You can add any AWT component (like buttons, labels, text fields, etc.) to a panel using the `add(Component comp)` method.

Example:
```java
Label label = new Label("This is a label");
panel.add(label); // Add label to the panel
```

### 5. **Using Multiple Panels**
You can create multiple panels within a frame or even nest panels within panels. This allows for more complex layouts and better organization of your GUI components.

Example:
```java
Panel panel1 = new Panel();
Panel panel2 = new Panel();

panel1.setLayout(new FlowLayout());
panel2.setLayout(new BorderLayout());

panel1.add(new Button("Panel 1 Button"));
panel2.add(new Button("Panel 2 Button"), BorderLayout.CENTER);

frame.add(panel1, BorderLayout.NORTH);
frame.add(panel2, BorderLayout.SOUTH);
```

### 6. **Handling Events**
Panels themselves do not directly handle events. However, you can add listeners to the components within a panel. This allows you to respond to user interactions, such as button clicks or mouse movements.

Example of adding an action listener to a button within a panel:
```java
button1.addActionListener(e -> {
    System.out.println("Button 1 clicked!");
});
```

### 7. **Customizing Panel Appearance**
You can customize the appearance of a panel using methods such as:
- **setBackground(Color color)**: Sets the background color of the panel.
- **setPreferredSize(Dimension d)**: Sets the preferred size of the panel when using layout managers that respect component sizes.

Example:
```java
panel.setBackground(Color.LIGHT_GRAY);
panel.setPreferredSize(new Dimension(200, 100));
```

### 8. **Example: Using Panel in a Frame**
Here’s a complete example demonstrating how to create a frame with multiple panels, each containing different components:

```java
import java.awt.*;
import java.awt.event.*;

public class PanelExample extends Frame {
    public PanelExample() {
        setTitle("Panel Example");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Create panels
        Panel topPanel = new Panel();
        Panel bottomPanel = new Panel();

        // Set layouts for panels
        topPanel.setLayout(new FlowLayout());
        bottomPanel.setLayout(new GridLayout(1, 2));

        // Create and add components to the top panel
        topPanel.add(new Label("Enter your name:"));
        TextField textField = new TextField(10);
        topPanel.add(textField);
        Button submitButton = new Button("Submit");
        topPanel.add(submitButton);

        // Create and add components to the bottom panel
        bottomPanel.add(new Button("Button 1"));
        bottomPanel.add(new Button("Button 2"));

        // Add panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // Handle button action
        submitButton.addActionListener(e -> {
            String name = textField.getText();
            System.out.println("Hello, " + name + "!");
        });

        // Close window on close event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new PanelExample();
    }
}
```

### 9. **Key Methods of Panel**
- **setLayout(LayoutManager mgr)**: Sets the layout manager for the panel.
- **add(Component comp)**: Adds a component to the panel.
- **remove(Component comp)**: Removes a component from the panel.
- **setBackground(Color color)**: Sets the background color of the panel.
- **setVisible(boolean b)**: Controls the visibility of the panel.