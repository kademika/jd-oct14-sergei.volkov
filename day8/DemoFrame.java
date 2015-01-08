package day8;

public class DemoFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		Painter p = new Painter();
		Thread.sleep(2000);
		p.x+=50;
		p.repaint();
		Thread.sleep(2000);
		p.x+=50;
		p.repaint();
		
	}
}
