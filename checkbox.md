[back](main.md)
### 1. **What is a Checkbox?**
A `Checkbox` is a user interface element that provides a way for users to make binary choices (checked or unchecked). Each checkbox operates independently, allowing multiple checkboxes to be selected at the same time.

### 2. **Creating a Checkbox**
To create a checkbox, you instantiate the `Checkbox` class, optionally providing a label and a boolean value indicating its initial state (checked or unchecked).

Example:
```java
import java.awt.*;

public class CheckboxExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Checkbox Example");
        Checkbox checkbox = new Checkbox("Option 1"); // Create a checkbox with a label

        frame.add(checkbox); // Add checkbox to the frame
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **Checkbox Properties**
- **Label**: The text displayed next to the checkbox can be set during instantiation or changed later using `setLabel(String label)`.
- **State**: The checked state of the checkbox can be retrieved or set using `getState()` and `setState(boolean state)` methods, respectively.
- **Group**: Checkboxes can be grouped to allow only one to be selected at a time using a `CheckboxGroup`.

### 4. **Handling Events**
To respond to user actions, you can add a `ItemListener` to the checkbox. This listener will be triggered whenever the state of the checkbox changes (checked or unchecked).

Example:
```java
checkbox.addItemListener(e -> {
    if (checkbox.getState()) {
        System.out.println("Checkbox is checked.");
    } else {
        System.out.println("Checkbox is unchecked.");
    }
});
```

### 5. **Example: Creating a Checkbox with Item Listener**
Here’s a complete example that demonstrates how to create a checkbox, add it to a frame, and handle user input:

```java
import java.awt.*;
import java.awt.event.*;

public class CheckboxDemo extends Frame {
    public CheckboxDemo() {
        setTitle("Checkbox Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        Checkbox checkbox = new Checkbox("Enable Feature"); // Create a checkbox
        Button button = new Button("Show Status"); // Create a button

        // Add item listener to the checkbox
        checkbox.addItemListener(e -> {
            if (checkbox.getState()) {
                System.out.println("Checkbox is checked.");
            } else {
                System.out.println("Checkbox is unchecked.");
            }
        });

        // Add action listener to the button
        button.addActionListener(e -> {
            String status = checkbox.getState() ? "checked" : "unchecked";
            System.out.println("Checkbox status: " + status);
        });

        // Add components to the frame
        add(checkbox);
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
        new CheckboxDemo();
    }
}
```

### 6. **Customizing Checkbox Appearance**
You can customize the appearance of a checkbox using various methods:
- **setBackground(Color color)**: Sets the background color of the checkbox.
- **setForeground(Color color)**: Sets the foreground (text) color of the checkbox.
- **setFont(Font font)**: Changes the font of the checkbox label.

### 7. **Checkbox Groups**
To create a group of checkboxes where only one checkbox can be selected at a time, use the `CheckboxGroup` class.

Example:
```java
CheckboxGroup group = new CheckboxGroup();
Checkbox checkbox1 = new Checkbox("Option 1", group, false);
Checkbox checkbox2 = new Checkbox("Option 2", group, false);
```

### 8. **Example: Checkbox Group**
Here's an example demonstrating how to use a `CheckboxGroup`:

```java
import java.awt.*;
import java.awt.event.*;

public class CheckboxGroupDemo extends Frame {
    public CheckboxGroupDemo() {
        setTitle("Checkbox Group Demo");
        setSize(300, 200);
        setLayout(new FlowLayout());

        CheckboxGroup group = new CheckboxGroup();
        Checkbox checkbox1 = new Checkbox("Option 1", group, false);
        Checkbox checkbox2 = new Checkbox("Option 2", group, false);

        // Add item listener to show the selected option
        checkbox1.addItemListener(e -> System.out.println("Selected: " + checkbox1.getLabel()));
        checkbox2.addItemListener(e -> System.out.println("Selected: " + checkbox2.getLabel()));

        // Add components to the frame
        add(checkbox1);
        add(checkbox2);

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
        new CheckboxGroupDemo();
    }
}
```