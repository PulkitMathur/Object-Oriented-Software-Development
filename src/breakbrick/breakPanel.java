package breakbrick;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class breakPanel extends JPanel implements ActionListener, KeyListener {

	public static final int DELAY = 5;

	// Bricks Constants
	public static final int NUM_BRICKS = 21;
	private int totalBricks = NUM_BRICKS;
	private final int bricks[][];
	private final int brickWidth;
	private final int brickHeight;
	private final int ROW = 3;
	private final int COLUMN = 7;

	// Ball Constants
	public static final int BALL_X_INITIAL = 120;
	public static final int BALL_Y_INITIAL = 350;
	public static final int BALL_DIAMETER = 20;
	public static final Color BALL_COLOR = Color.DARK_GRAY;
	private int xBall = BALL_X_INITIAL;
	private int yBall = BALL_Y_INITIAL;
	private int xBallrev = -1;
	private int yBallrev = 1;

	// Paddle Constants
	public static final int PADDLE_X_INITIAL = 110;
	public static final int PADDLE_WIDTH_INITIAL = 100;
	public static final int PADDLE_HEIGHT_INITIAL = 8;
	public static final Color PADDLE_COLOR = Color.BLACK;
	public static final int PADDLE_SHIFT = 20;
	private int paddleX = PADDLE_X_INITIAL;
	private final int paddleWidth = PADDLE_WIDTH_INITIAL;
	private final int paddleHeight = PADDLE_HEIGHT_INITIAL;

	// Background
	public static final Color BACKGROUND_COLOR = Color.WHITE;

	// Fields
	private boolean play = false;
	private final Timer timer;
	private final int delay = DELAY;
	private int score = 0;
	private int sec = 0;

	public breakPanel() {

		// initializing the bricks
		bricks = new int[ROW][COLUMN];
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[0].length; j++) {
				bricks[i][j] = 1;
			}
		}
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		brickWidth = 540 / COLUMN;
		brickHeight = 150 / ROW;
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		// Screen
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(1, 1, 692, 592);

		// Drawing Bricks
		drawBricks((Graphics2D) g);

		// Background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 5, 592);
		g.fillRect(0, 0, 692, 5);
		g.fillRect(691, 0, 5, 592);

		// Score
		g.setColor(Color.BLACK);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 22));
		g.drawString("Score: " + score, 530, 30);
		g.drawString("Time(s): " + sec / 110, 10, 30);
		if (play) {
			sec++;
		}
		// Paddle
		g.setColor(PADDLE_COLOR);
		g.fillRect(paddleX, 550, paddleWidth, paddleHeight);

		// Ball
		g.setColor(BALL_COLOR);
		g.fillOval(xBall, yBall, BALL_DIAMETER, BALL_DIAMETER);

		// On victory
		if (totalBricks <= 0) {
			play = false;
			xBallrev = 0;
			yBallrev = 0;
			sec = 0;
			g.setColor(Color.GREEN);
			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("You Won Scores: " + score, 190, 300);

			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("Press Enter to restart", 230, 350);
		}

		// Ball Dropped
		if (yBall > 570) {
			play = false;
			xBallrev = 0;
			yBallrev = 0;
			sec = 0;
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("Game Over!!! Your Score: " + score, 80, 250);

			g.setFont(new Font("TimesRoman", Font.BOLD, 30));
			g.drawString("Press Enter to exit", 90, 350);
		}
		g.dispose();
	}

	public void drawBricks(Graphics2D g) {
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[0].length; j++) {
				if (bricks[i][j] > 0) {
					if (i == 2) {
						g.setColor(Color.gray);
					} else if (i == 1) {
						g.setColor(Color.darkGray);
					} else {
						g.setColor(Color.BLACK);
					}
					g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
					g.setStroke(new BasicStroke(10));
					g.setColor(Color.white);
					g.drawRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// timer.start();
		if (play) {

			// Checks intersection between paddle and ball
			if (new Rectangle(xBall, yBall, 20, 20).intersects(new Rectangle(paddleX, 550, 30, 8))) {
				yBallrev = -yBallrev;
				xBallrev = -1;
			} else if (new Rectangle(xBall, yBall, 20, 20).intersects(new Rectangle(paddleX + 70, 550, 30, 8))) {
				yBallrev = -yBallrev;
				xBallrev = xBallrev + 1;
			} else if (new Rectangle(xBall, yBall, 20, 20).intersects(new Rectangle(paddleX + 30, 550, 40, 8))) {
				yBallrev = -yBallrev;
			}

			// Checks intersection between ball and brick
			collision: for (int i = 0; i < bricks.length; i++) {
				for (int j = 0; j < bricks[0].length; j++) {
					if (bricks[i][j] > 0) {
						final int brickX = j * brickWidth + 80;
						final int brickY = i * brickHeight + 50;

						final Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						final Rectangle ballRect = new Rectangle(xBall, yBall, 20, 20);
						final Rectangle brickRect = rect;

						if (ballRect.intersects(brickRect)) {
							brickInit(0, i, j);
							totalBricks--;
							if (i == 2) {
								score += 5;
							} else if (i == 1) {
								score += 10;
							} else {
								score += 15;
							}

							if (xBall + 19 <= brickRect.x || xBall + 1 >= brickRect.x + brickRect.width) {
								xBallrev = -xBallrev;
							} else {
								yBallrev = -yBallrev;
							}
							break collision;
						}
					}
				}
			}

			// Ball Mechanics
			if (score >= 60 && score < 100) {
				xBall += xBallrev * 1.5;
				yBall += yBallrev * 1.5;

			} else if (score >= 100) {
				xBall += xBallrev * 1.8;
				yBall += yBallrev * 1.8;

			} else {
				xBall += xBallrev;
				yBall += yBallrev;

			}

			// Ball Boundaries Check
			if (xBall < 0) {
				xBallrev = -xBallrev;
			}
			if (yBall < 0) {
				yBallrev = -yBallrev;
			}
			if (xBall > 670) {
				xBallrev = -xBallrev;
			}
		}
		repaint();
	}

	public void brickInit(int val, int row, int col) {
		bricks[row][col] = val;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!play) {
				System.exit(0);
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (paddleX <= 580) {
				// paddleX = 580;
				towardsRight();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (paddleX > 15) {
				towardsLeft();
			}
		}
	}

	private void towardsLeft() {
		// TODO Auto-generated method stub
		play = true;
		if (score >= 60 && score < 100) {
			paddleX -= PADDLE_SHIFT * 1.7;
		} else if (score >= 100) {
			paddleX -= PADDLE_SHIFT * 2;
		} else {
			paddleX -= PADDLE_SHIFT;
		}

	}

	private void towardsRight() {
		// TODO Auto-generated method stub
		play = true;
		if (score >= 60 && score < 100) {
			paddleX += PADDLE_SHIFT * 1.7;
		} else if (score >= 100) {
			paddleX += PADDLE_SHIFT * 2;
		} else {
			paddleX += PADDLE_SHIFT;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
