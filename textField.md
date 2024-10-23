[back](main.md)
### 1. **What is a TextField?**
A `TextField` is a user interface element that enables users to input text. It can be configured to accept a specific number of characters and can be set to be editable or non-editable.

### 2. **Creating a TextField**
To create a `TextField`, you instantiate the `TextField` class, optionally providing an initial string as a default value.

Example:
```java
import java.awt.*;

public class TextFieldExample {
    public static void main(String[] args) {
        Frame frame = new Frame("TextField Example");
        TextField textField = new TextField("Enter text here"); // Create a text field with default text

        frame.add(textField); // Add text field to the frame
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **TextField Properties**
- **Text**: The text displayed in the text field can be set during instantiation or changed later using `setText(String text)`.
- **Editable State**: You can control whether the text field is editable using `setEditable(boolean editable)`. If set to `false`, the user cannot modify the text.
- **Columns**: You can specify the number of columns (visible width) of the text field using the constructor or `setColumns(int columns)` method.

### 4. **Handling Events**
To respond to user input, you can add an `ActionListener` to the text field. This listener will be triggered when the user presses Enter after typing text.

Example:
```java
textField.addActionListener(e -> {
    String inputText = textField.getText(); // Retrieve text from the text field
    System.out.println("You entered: " + inputText);
});
```

### 5. **Example: Creating a TextField with Action Listener**
Here’s a complete example that demonstrates how to create a text field, add it to a frame, and handle user input:

```java
import java.awt.*;
import java.awt.event.*;

public class TextFieldDemo extends Frame {
    public TextFieldDemo() {
        setTitle("TextField Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        TextField textField = new TextField(20); // Create a text field with 20 columns
        Button button = new Button("Submit"); // Create a submit button

        // Add action listener to the text field
        textField.addActionListener(e -> {
            String inputText = textField.getText(); // Retrieve text from the text field
            System.out.println("You entered: " + inputText);
        });

        // Add action listener to the button
        button.addActionListener(e -> {
            String inputText = textField.getText(); // Retrieve text from the text field
            System.out.println("Button clicked! You entered: " + inputText);
        });

        // Add components to the frame
        add(textField);
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
        new TextFieldDemo();
    }
}
```

### 6. **Customizing TextField Appearance**
You can customize the appearance of a text field using various methods:
- **setFont(Font font)**: Changes the font of the text displayed in the text field.
- **setBackground(Color color)**: Sets the background color of the text field.
- **setForeground(Color color)**: Sets the foreground (text) color.

### 7. **Limitations**
A `TextField` is designed for single-line input. If you need to handle multiple lines of text, consider using a `TextArea` instead.

### 8. **Example: TextField with Limited Input**
You can restrict the number of characters a user can enter by listening to the `KeyListener` events. However, managing this is more complex than simply using a `TextField`.

### 9. **Example: A Read-Only TextField**
You can make a `TextField` read-only by setting it as non-editable.

```java
textField.setEditable(false); // Make the text field read-only
```