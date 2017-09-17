package breakbrick;

import javax.swing.JFrame;

public class breakOut {

	public static final int HEIGHT = 600;
	public static final int WIDTH = 700;

	public static void main(String[] args) {
		final JFrame mainFrame = new JFrame();
		final breakPanel mainPanel = new breakPanel();

		mainFrame.setBounds(10, 10, WIDTH, HEIGHT);
		mainFrame.setTitle("Lets break them all!!!");
		mainFrame.setResizable(false);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.add(mainPanel);
	}
}
