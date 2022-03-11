package mypaintpackage;

import javax.swing.JFrame;

public class FrameClass extends JFrame{
	
	// конструктор класса фрейма
	FrameClass() {
		
		// размеры
		setBounds(100,100,1015,700);
				
		// запрещаем изменять размеры окна
		setResizable(false);
				
		// название окна
		setTitle("Как пеинт, но только лучше!");
				
		// закрытие программы после закрытия окна
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// прикрепим панель к окну
		add(new PanelClass());
				
		// видимость
		setVisible(true);
	}
}
