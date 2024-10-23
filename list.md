[back](main.md)
### 1. **What is a List?**
A `List` is a component that displays a list of items from which the user can select one or more options. It can be displayed in a single-column format, and the items can be selected either by clicking or by using keyboard navigation.

### 2. **Creating a List**
To create a `List`, you instantiate the `List` class, optionally specifying whether multiple selections are allowed.

Example:
```java
import java.awt.*;

public class ListExample {
    public static void main(String[] args) {
        Frame frame = new Frame("List Example");
        List list = new List(); // Create a list

        // Add items to the list
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");

        frame.add(list); // Add the list to the frame
        frame.setSize(300, 200);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
```

### 3. **List Properties**
- **Selected Items**: You can retrieve selected items using `getSelectedItem(int index)` and `getSelectedItems()`.
- **Item Count**: You can get the number of items in the list using `getItemCount()`.
- **Item at Index**: You can retrieve an item at a specific index using `getItem(int index)`.

### 4. **Handling Events**
To respond to user selections, you can add an `ItemListener` or `ActionListener` to the `List` component. This listener will be triggered whenever the user selects or deselects items.

Example:
```java
list.addItemListener(e -> {
    String selectedItem = list.getSelectedItem(); // Get the selected item
    System.out.println("Selected: " + selectedItem);
});
```

### 5. **Example: Creating a List with Item Listener**
Here’s a complete example that demonstrates how to create a `List`, add items to it, and handle user selections:

```java
import java.awt.*;
import java.awt.event.*;

public class ListDemo extends Frame {
    public ListDemo() {
        setTitle("List Demo");
        setSize(300, 200);
        setLayout(new FlowLayout());

        List list = new List(); // Create a list
        list.add("Option 1");
        list.add("Option 2");
        list.add("Option 3");

        // Allow multiple selections
        list.setMultipleMode(true);

        // Add item listener to respond to user selection
        list.addItemListener(e -> {
            String[] selectedItems = list.getSelectedItems(); // Get selected items
            System.out.println("Selected: " + String.join(", ", selectedItems));
        });

        add(list); // Add the list to the frame

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
        new ListDemo();
    }
}
```

### 6. **Customizing List Appearance**
You can customize the appearance of a `List` using various methods:
- **setBackground(Color color)**: Sets the background color of the list.
- **setForeground(Color color)**: Sets the foreground (text) color of the list.
- **setFont(Font font)**: Changes the font of the list items.

### 7. **Usage Context**
The `List` component is useful for displaying collections of items, such as file names, options in settings, or available items in a database. It provides a straightforward way for users to select from multiple options.