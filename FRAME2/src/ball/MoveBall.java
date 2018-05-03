package ball;

public class MoveBall {
	private Ball ball;
	private boolean boolX = true;
	private boolean boolY = true;
	public MoveBall(Ball pBall) {
		this.ball = pBall;
	}

//	public void go(int mvX, int mvY) {
//		
//		while(true) {
//			ball.setPosX(ball.getPosX() + mvX);
//			ball.setPosY(ball.getPosY() + mvY);
//			if(ball.getPosX() > ball.getWidth() - ball.getSizeBall() && this.boolX) {
//				mvX *= (-1);
//				this.boolX = false;
//				break;
//			}
//			if(ball.getPosX() < 0) {
//				this.boolX = true;
//				mvX *= -1;
//				break;
//			}
//			if(ball.getPosY() > ball.getHeight() - ball.getSizeBall() && this.boolY) {
//				mvY *= -1;
//				this.boolY = false;
//				break;
//			}
//			if(ball.getPosY() < 0) {
//				this.boolY = true;
//				mvY *= -1;
//				break;
//			}
//			ball.repaint();  
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		go(mvX, mvY);
//	}
}
