package mypaintpackage;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

public class PanelClass extends JPanel{
	
	// Массив цветов
	Color [] masColor;
	
	// Переменная, которая отвечает за текущий выбранный цвет
	int countColor = 0;
	
	// Переменные для хранения координат мыши
	int mX = 0, mY = 0;
	
	// Флаг, чт пользователь рисует
	Boolean flag = false;
	
	// Конструктор класса панели
	PanelClass () {
		// подключаем обработчки событий для мыши к панели окна
		addMouseListener(new myMouse1());
		addMouseMotionListener(new myMouse2());
		
		// создадим массим из семи цветов
		masColor = new Color[10];
		
		// заполним массив цветами
		masColor[0] = Color.BLACK;
		masColor[1] = Color.RED;
		masColor[2] = Color.GREEN;
		masColor[3] = Color.BLUE;
		masColor[4] = Color.YELLOW;
		masColor[5] = Color.ORANGE;
		// можно создать свой цвет
		masColor[6] = new Color(120,100,100);
		masColor[7] = Color.WHITE;
		masColor[8] = Color.CYAN;
		masColor[9] = Color.MAGENTA;
	}
	
	// метод для отрисовки графики
	public void paintComponent(Graphics g) {
		// рисуем семь прямоугольников
		for(int i = 0; i<10; i++) {
			// устанавливаем цвет
			g.setColor(masColor[i]);
			// рисуем закрашенный прямоугольник
			g.fillRect(100 * i, 0, 100, 100);
		}
		// если флаг рисования - ИСТИНА, то рисуем
		// маленький квадрат выбранным цветом
		// в точке где находится курсор мыши
		if(flag == true) {
			// установливаем цвет для рисования
			g.setColor(masColor[countColor]);
			// рисуем закрашенный квадрат
			g.fillRect(mX, mY, 3, 3);
		}
	}
	
	// обработка нажатий на мышь
	public class myMouse1 implements MouseListener {
		// Нажатие кнопки мыши
		public void mousePressed(MouseEvent e) {
			// получаем координаты мыши
			int tX = e.getX();
			int tY = e.getY();
			
			// получаем количество нажатий клавиши
			int col = e.getClickCount();
			
			// получение номера нажатой клавиши
			int btn = e.getButton();
			
			// проверяем,что курсор находится в области выбора цвета
			if ((tY>0) && (tY<100) && (tX>0) && (tX<1000)) {
				// проверяем, что клавишу нажали один раз
				if (col==1)
				{
					// проверяем, что нажали левую клавишу
					if(btn ==1) {
						// по координате X курсора мыши вычисляе номер цвета
						// при делении дробная часть будет отбрасываться
						// потому что countColor имеет тип данных int
						System.out.println("x = " + tX + " y = " + tY);
						countColor = tX / 100;
						System.out.println("Номер выбранного цвета" + countColor);
					}
				}
			}
		}

		// отпускание кнопки мыши после нажатия
		public void mouseReleased(MouseEvent e) {
			// признак рисования ложь - не рисует
			flag = false;
		}
		
		// щелчок кнопкой мыши (нажали и отпустили)
		public void mouseClicked(MouseEvent e) {}
		// появление курсора мыши на панели окна
		public void mouseEntered(MouseEvent e) {}
		// выход курсора мыши за пределы панели окна
		public void mouseExited(MouseEvent e) {}
	}
	
	// обработка нажатий на мышь
	public class myMouse2 implements MouseMotionListener {
		// перемещение мыши с нажатой клавишей
		public void mouseDragged(MouseEvent e) {
			// Получение координат курсора мыши
			int tX = e.getX();
			int tY = e.getY();
			
			// если курсор находится в той части экрана, где можно рисовать
			if (tY > 100) {
				// запоминаем координаты мыши в переменных
				mX = tX;
				mY = tY;
				
				// устанавливаем признак, что пользователь рисует
				flag = true;
				
				// вызываем переотрисовку
				repaint();
			}
		}

		// перемещение мыши
		public void mouseMoved(MouseEvent e) {
			// Получение координат курсора мыши
			int tX = e.getX();
			int tY = e.getY();
						
			// проверяем,что курсор находится в области выбора цвета
			if ((tY>0) && (tY<100) && (tX>0) && (tX<1000)) {
				// устанавливаем другой курсор (курсор в виде пальца)
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			else {
				// устанавливаем курсор по умолчанию
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		}
	}	
}
