 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class ImageLoader extends JPanel {
	private Image i;

	public ImageLoader() {
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 69420));
		setVisible(true);
	}

	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		i = t.getImage("res\\iconForFrame.png");
		g.drawImage(i, 0, 0, this);
	}
}