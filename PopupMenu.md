[back](main.md)
### 1. **What is a PopupMenu?**
A `PopupMenu` is a pop-up element that appears when triggered, allowing users to select options without navigating through a standard menu structure. It is often used for context menus that provide actions relevant to the component under the mouse cursor.

### 2. **Creating a PopupMenu**
To create a `PopupMenu`, you instantiate the `PopupMenu` class, add `MenuItem` objects to it, and then show it in response to specific events, like a mouse click.

Example:
```java
import java.awt.*;
import java.awt.event.*;

public class PopupMenuExample {
    public static void main(String[] args) {
        Frame frame = new Frame("PopupMenu Example");
        PopupMenu popupMenu = new PopupMenu();

        // Create menu items for the popup menu
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem deleteItem = new MenuItem("Delete");

        // Add action listeners for the menu items
        copyItem.addActionListener(e -> System.out.println("Copy action performed"));
        pasteItem.addActionListener(e -> System.out.println("Paste action performed"));
        deleteItem.addActionListener(e -> System.out.println("Delete action performed"));

        // Add menu items to the popup menu
        popupMenu.add(copyItem);
        popupMenu.add(pasteItem);
        popupMenu.add(deleteItem);

        // Add the popup menu to the frame
        frame.add(popupMenu);

        // Add a mouse listener to show the popup menu on right-click
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(frame, e.getX(), e.getY());
                }
            }
        });

        // Set up the frame
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        // Close the window on close event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
```

### 3. **PopupMenu Properties**
- **Adding MenuItems**: You can add `MenuItem` objects to a `PopupMenu` using the `add(MenuItem item)` method.
- **Separators**: You can use `addSeparator()` to add a separator line between items for better organization.
- **Customizing Appearance**: Just like other components, you can customize the appearance of a `PopupMenu` using methods like `setBackground(Color color)` and `setForeground(Color color)`.

### 4. **Displaying the PopupMenu**
To display the `PopupMenu`, you call the `show(Component invoker, int x, int y)` method, passing the component that invoked it (e.g., the frame) and the coordinates where the menu should appear.

### 5. **Example: Using PopupMenu with Action Handling**
Here’s a complete example demonstrating how to create a `PopupMenu` with action handling:

```java
import java.awt.*;
import java.awt.event.*;

public class PopupMenuDemo extends Frame {
    public PopupMenuDemo() {
        setTitle("PopupMenu Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create a PopupMenu
        PopupMenu popupMenu = new PopupMenu();

        // Create menu items for the popup menu
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        MenuItem deleteItem = new MenuItem("Delete");

        // Add action listeners for the menu items
        cutItem.addActionListener(e -> System.out.println("Cut action performed"));
        copyItem.addActionListener(e -> System.out.println("Copy action performed"));
        pasteItem.addActionListener(e -> System.out.println("Paste action performed"));
        deleteItem.addActionListener(e -> System.out.println("Delete action performed"));

        // Add menu items to the popup menu
        popupMenu.add(cutItem);
        popupMenu.add(copyItem);
        popupMenu.addSeparator(); // Add a separator
        popupMenu.add(pasteItem);
        popupMenu.add(deleteItem);

        // Add the popup menu to the frame
        add(popupMenu);

        // Add a mouse listener to show the popup menu on right-click
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(PopupMenuDemo.this, e.getX(), e.getY());
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(PopupMenuDemo.this, e.getX(), e.getY());
                }
            }
        });

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
        new PopupMenuDemo();
    }
}
```

### 6. **Usage Context**
The `PopupMenu` class is commonly used in applications for:
- Providing contextual options relevant to the area or component where the user clicked (e.g., right-clicking on text to see editing options).
- Offering quick access to actions without navigating through a traditional menu structure.