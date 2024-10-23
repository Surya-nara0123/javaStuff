[back](main.md)

### 1. **What is a FileDialog?**
A `FileDialog` is a dialog window that displays a file selection interface. Users can navigate through the filesystem, view files and directories, and select a file for opening or saving. The `FileDialog` is usually modal, meaning it blocks input to other windows until the dialog is closed.

### 2. **Creating a FileDialog**
To create a `FileDialog`, you instantiate the `FileDialog` class, providing the parent frame and the type of dialog (open or save). You can then set various properties, such as the title, initial directory, and file filters.

Example:
```java
import java.awt.*;
import java.awt.event.*;

public class FileDialogExample {
    public static void main(String[] args) {
        Frame frame = new Frame("FileDialog Example");
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        // Button to open the file dialog
        Button openButton = new Button("Open File");
        openButton.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(frame, "Select a File", FileDialog.LOAD);
            fileDialog.setDirectory("C:\\"); // Set initial directory
            fileDialog.setVisible(true); // Show the dialog

            // Get the selected file
            String file = fileDialog.getDirectory() + fileDialog.getFile();
            System.out.println("Selected file: " + file);
        });

        frame.add(openButton);

        // Close window on close event
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        frame.setVisible(true); // Make the frame visible
    }
}
```

### 3. **FileDialog Properties**
- **Dialog Type**: Use `FileDialog.LOAD` for loading files and `FileDialog.SAVE` for saving files.
- **Title**: Set the title of the dialog using the constructor or `setTitle(String title)`.
- **Directory**: Set the initial directory using `setDirectory(String dir)`.
- **File Filter**: You can filter the types of files shown in the dialog using `setFilenameFilter(FilenameFilter filter)`.

### 4. **Displaying the FileDialog**
To display the `FileDialog`, call the `setVisible(boolean)` method with `true`. This will make the dialog appear on the screen. The dialog remains modal, blocking interaction with the parent frame until closed.

### 5. **Retrieving Selected File Information**
Once the user has selected a file and closed the dialog, you can retrieve the selected file's path using:
- `getDirectory()`: Returns the directory of the selected file.
- `getFile()`: Returns the name of the selected file.

You can combine these two methods to get the complete file path.

### 6. **Example: Using FileDialog for Saving Files**
Here’s an example demonstrating how to create a `FileDialog` for saving a file:

```java
import java.awt.*;
import java.awt.event.*;

public class SaveFileDialogDemo extends Frame {
    public SaveFileDialogDemo() {
        setTitle("Save File Dialog Demo");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Button to open the save file dialog
        Button saveButton = new Button("Save File");
        saveButton.addActionListener(e -> {
            FileDialog fileDialog = new FileDialog(this, "Save a File", FileDialog.SAVE);
            fileDialog.setDirectory("C:\\"); // Set initial directory
            fileDialog.setVisible(true); // Show the dialog

            // Get the selected file
            String file = fileDialog.getDirectory() + fileDialog.getFile();
            System.out.println("File to save: " + file);
        });

        add(saveButton);

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
        new SaveFileDialogDemo();
    }
}
```

### 7. **Usage Context**
The `FileDialog` class is commonly used in applications for:
- Allowing users to select files for opening or saving, providing a familiar interface.
- Simplifying file management tasks in applications where file input/output is needed.