package main.java.ru.shishkin.simplePaint;

import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame() {
        setBounds(100, 100, 1015, 700);
        setResizable(false);
        setTitle("Paint 2.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Panel());
        setVisible(true);
    }
}
