import java.awt.*;
import java.awt.event.*;

public class tutorial extends Frame {
    static Image img;
    public void paint(Graphics gph) {
        gph.drawImage(img, 0, 0, this);
    }
    public static void main(String[] args) {
        tutorial myFrame = new tutorial();
        myFrame.setSize(300, 200);
        myFrame.setTitle("Frame Tutorial");
        myFrame.setVisible(true);
        // myFrame.setResizable(false);
        img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrsur\\Desktop\\javaStuff\\insanePhoto.jpg");
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myFrame.dispose();
            }
        });
        
    }
}