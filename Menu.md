[back](main.md)
### 1. **What is a Menu?**
A `Menu` is a pop-up element that appears when a user interacts with the associated menu in a `MenuBar`. It displays a list of options, allowing users to select commands or actions within the application.

### 2. **Creating a Menu**
To create a `Menu`, you instantiate the `Menu` class, specifying the name of the menu as a string. After creating the menu, you can add `MenuItem` objects and separators to it.

Example:
```java
import java.awt.*;
import java.awt.event.*;

public class MenuExample {
    public static void main(String[] args) {
        Frame frame = new Frame("Menu Example");
        MenuBar menuBar = new MenuBar();

        // Create a File menu
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");

        // Add action listeners to menu items
        exitItem.addActionListener(e -> System.exit(0));

        // Add menu items to the File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Add a separator
        fileMenu.add(exitItem);

        // Add the File menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        frame.setMenuBar(menuBar);

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

### 3. **Menu Properties**
- **Adding Items**: Use the `add(MenuItem item)` method to add `MenuItem` objects to the `Menu`.
- **Separators**: Use `addSeparator()` to add a separator line between menu items for better organization.
- **Sub-menus**: You can create sub-menus by adding another `Menu` to a `Menu` using the `add(Menu menu)` method.

### 4. **Handling Events**
Each `MenuItem` within a `Menu` can have action listeners added to it to handle user selections. This allows your application to respond to user actions in the menu.

Example:
```java
exitItem.addActionListener(e -> System.exit(0)); // Exit the application
```

### 5. **Example: Creating a Menu with MenuItems**
Here’s a complete example demonstrating how to create a `Menu` with menu items and handle user interactions:

```java
import java.awt.*;
import java.awt.event.*;

public class MenuDemo extends Frame {
    public MenuDemo() {
        setTitle("Menu Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create a menu bar
        MenuBar menuBar = new MenuBar();

        // Create a File menu
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem exitItem = new MenuItem("Exit");

        // Add action listener for the Exit menu item
        exitItem.addActionListener(e -> System.exit(0));

        // Add menu items to the File menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator(); // Add a separator
        fileMenu.add(exitItem);

        // Add the File menu to the menu bar
        menuBar.add(fileMenu);

        // Set the menu bar for the frame
        setMenuBar(menuBar);

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
        new MenuDemo();
    }
}
```

### 6. **Customizing Menu Appearance**
You can customize the appearance of a `Menu` using various methods:
- **setBackground(Color color)**: Sets the background color of the menu.
- **setForeground(Color color)**: Sets the foreground (text) color of the menu.
- **setFont(Font font)**: Changes the font for the text in the menu.

### 7. **Usage Context**
The `Menu` class is commonly used in applications for:
- Organizing commands related to specific functionalities (e.g., File operations, Edit commands).
- Providing a clear and structured way for users to navigate through options.
- Enhancing user experience by grouping related commands together.