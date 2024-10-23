import java.awt.*;
import java.awt.event.*;
// import javax.script.ScriptEngineManager;
// import javax.script.ScriptEngine;
// import javax.script.ScriptException;

public class frameTutorial extends Frame {

    // public void paint(Graphics g) {
    // // Drawing operations should be inside paint()
    // g.setColor(Color.GREEN);
    // g.fillRect(0, 0, getWidth(), getHeight());
    // try {
    // Thread.sleep(1000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // g.setColor(Color.BLACK);
    // g.fillRect(0, 0, getWidth(), getHeight());
    // }
    public void paint(Graphics gph) {
        // creating a constructor of the font class and passing name, style, and size of
        // the font
        // we can change these three parameters accordingly
        Font font = new Font("Brush Script MT Italic", Font.BOLD | Font.ITALIC, 20);
        // setting font by invoking the setFont() method
        gph.setFont(font);
        gph.drawString("Javatpoint is the best learning platform.", 12, 45);
    }

    public static void main(String[] args) throws InterruptedException {
        frameTutorial myFrame = new frameTutorial();
        myFrame.setSize(300, 200);
        myFrame.setTitle("Frame Tutorial");
        myFrame.setVisible(true);
        myFrame.setResizable(false);
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myFrame.dispose();
            }
        });

        // myFrame.addComponentListener(
        // new java.awt.event.ComponentAdapter() {
        // public void componentMoved(java.awt.event.ComponentEvent evt) {
        // System.out.println("Component Moved");
        // }
        // public void componentResized(java.awt.event.ComponentEvent evt) {
        // System.out.println("Component Resized");
        // }
        // }
        // );
        // myFrame.addFocusListener(
        // new java.awt.event.FocusAdapter() {
        // public void focusGained(java.awt.event.FocusEvent evt) {
        // System.out.println("Focus Gained");
        // }
        // public void focusLost(java.awt.event.FocusEvent evt) {
        // System.out.println("Focus Lost");
        // }
        // }
        // );
    }
}

/*
 * @Override
            public void actionPerformed(ActionEvent e) {
                ScriptEngineManager manager = new ScriptEngineManager();
                ScriptEngine engine = manager.getEngineByName("JavaScript");   // Retrieve a 
JavaScript engine from the manager
                try {
                    text = engine.eval(text).toString();
                    textField.setText(text);
                } catch (ScriptException e1) {
                    e1.printStackTrace();
                }
            }
 */