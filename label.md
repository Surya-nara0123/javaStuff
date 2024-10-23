[back](main.md)
### 1. **What is a Label?**
A `Label` is a simple component that displays text or an image but does not allow user interaction. Labels are often used to label other components (like text fields) or to provide information to the user.

### 2. **Creating a Label**
To create a label, you instantiate the `Label` class and provide the text to be displayed. You can also create a label with no text initially and set it later.

Example:
```java
import java.awt.*;

public class LabelExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Label Example");
        Label label = new Label("This is a label."); // Create a label with text

        frame.add(label); // Add label to the frame
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **Label Properties**
- **Text**: The text displayed by the label can be set during instantiation or changed later using `setText(String text)`.
- **Alignment**: You can specify the alignment of the text within the label using constants such as `Label.LEFT`, `Label.CENTER`, or `Label.RIGHT`.
- **Background and Foreground Colors**: You can customize the appearance of the label by setting its background and foreground (text) colors using `setBackground(Color color)` and `setForeground(Color color)`.

### 4. **Handling Events**
Labels do not respond to user actions, as they are non-interactive components. However, they can still be useful for displaying information related to user actions, and you can programmatically change their text based on events.

### 5. **Example: Creating a Label and Updating It**
Here’s a complete example that demonstrates how to create a label, add it to a frame, and update the label based on a button click:

```java
import java.awt.*;
import java.awt.event.*;

public class LabelDemo extends Frame {
    private Label label;

    public LabelDemo() {
        setTitle("Label Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        label = new Label("Initial Text"); // Create a label with initial text
        Button button = new Button("Change Text"); // Create a button

        // Add action listener to change label text when button is clicked
        button.addActionListener(e -> {
            label.setText("Text Changed!"); // Update label text
        });

        // Add components to the frame
        add(label);
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
        new LabelDemo();
    }
}
```

### 6. **Using Labels with Images**
In addition to text, you can display images on labels. To do this, you need to create an `Image` object and set it to the label using `setIcon(Image img)`.

Example:
```java
Image img = Toolkit.getDefaultToolkit().getImage("path/to/image.png");
Label imageLabel = new Label();
imageLabel.setIcon(img);
```

### 7. **Customizing Label Appearance**
You can customize the appearance of labels using various methods:
- **setFont(Font font)**: Changes the font of the label text.
- **setSize(int width, int height)**: Sets the size of the label.

### 8. **Alignment of Text in a Label**
You can set the alignment of the text in a label using the constructor or the `setAlignment(int alignment)` method.

Example of center alignment:
```java
Label centerLabel = new Label("Centered Label", Label.CENTER);
```

### 9. **Example: A Label with Image**
Here’s an example demonstrating how to create a label that displays an image:

```java
import java.awt.*;

public class ImageLabelExample extends Frame {
    public ImageLabelExample() {
        setTitle("Image Label Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

        Image img = Toolkit.getDefaultToolkit().getImage("path/to/image.png"); // Load an image
        Label imageLabel = new Label();
        imageLabel.setIcon(img); // Set the image to the label

        add(imageLabel); // Add label with image to the frame

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true); // Make the frame visible
    }

    public static void main(String[] args) {
        new ImageLabelExample();
    }
}
```