[back](main.md)

### 1. **What is a TextArea?**
A `TextArea` is a user interface element that enables users to input and edit multiple lines of text. It can be configured to allow line wrapping, scrolling, and more, making it suitable for longer text inputs.

### 2. **Creating a TextArea**
To create a `TextArea`, you instantiate the `TextArea` class, optionally providing initial text, the number of rows, and the number of columns.

Example:
```java
import java.awt.*;

public class TextAreaExample {
    public static void main(String[] args) {
        Frame frame = new Frame("TextArea Example");
        TextArea textArea = new TextArea("Enter your text here", 5, 30); // Create a text area with initial text

        frame.add(textArea); // Add text area to the frame
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **TextArea Properties**
- **Text**: The text displayed in the text area can be set during instantiation or changed later using `setText(String text)`.
- **Editable State**: You can control whether the text area is editable using `setEditable(boolean editable)`. If set to `false`, the user cannot modify the text.
- **Rows and Columns**: You can specify the number of visible rows and columns when creating the text area using the constructor.

### 4. **Handling Events**
To respond to user input, you can add a `TextListener` to the text area. This listener will be triggered whenever the text is modified.

Example:
```java
textArea.addTextListener(e -> {
    String inputText = textArea.getText(); // Retrieve text from the text area
    System.out.println("Text changed: " + inputText);
});
```

### 5. **Example: Creating a TextArea with Text Listener**
Here’s a complete example that demonstrates how to create a text area, add it to a frame, and handle user input:

```java
import java.awt.*;
import java.awt.event.*;

public class TextAreaDemo extends Frame {
    public TextAreaDemo() {
        setTitle("TextArea Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        TextArea textArea = new TextArea(10, 30); // Create a text area with 10 rows and 30 columns
        Button button = new Button("Show Text"); // Create a button

        // Add action listener to the button
        button.addActionListener(e -> {
            String inputText = textArea.getText(); // Retrieve text from the text area
            System.out.println("Text in TextArea: " + inputText);
        });

        // Add components to the frame
        add(textArea);
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
        new TextAreaDemo();
    }
}
```

### 6. **Customizing TextArea Appearance**
You can customize the appearance of a text area using various methods:
- **setFont(Font font)**: Changes the font of the text displayed in the text area.
- **setBackground(Color color)**: Sets the background color of the text area.
- **setForeground(Color color)**: Sets the foreground (text) color.

### 7. **Scrolling in TextArea**
If the text area contains more text than can be displayed, it automatically provides a scrollable view. You can control the scroll behavior using methods like `setScrollbarVisibility(int visibility)`.

### 8. **Example: A Read-Only TextArea**
You can make a `TextArea` read-only by setting it as non-editable.

```java
textArea.setEditable(false); // Make the text area read-only
```

### 9. **Line Wrapping**
You can control line wrapping in a `TextArea` using the `setLineWrap(boolean wrap)` method. This will allow text to wrap within the component.