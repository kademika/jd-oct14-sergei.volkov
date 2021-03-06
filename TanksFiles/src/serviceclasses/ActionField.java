package serviceclasses;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import fieldobjects.Brick;
import fieldobjects.Eagle;
import fieldobjects.FieldObject;
import fieldobjects.Land;
import fieldobjects.Rock;
import fieldobjects.Water;
import tanks.AbstractTank;
import tanks.T34;
import tanks.Tiger;

public class ActionField extends JPanel {

	final boolean COLORDED_MODE = false;
	final int TANKS_IN_BATTLE = 2;
	BattleField battleField;
	
	T34 defender;
	Bullet bullet;
	Tiger aggressor;
	
	AbstractTank[] tanksOnField;
	Brick brick;
	Water water;
	Eagle eagle;
	Rock rock;
	HashMap<AbstractTank,FieldObject> contentOfQuadrant;

	public ActionField() throws Exception {

		battleField = new BattleField();
		
		brick = new Brick();
		water = new Water();
		eagle = new Eagle();
		rock = new Rock();

		defender = new T34("D", battleField, 128, 512, Direction.UP);
		aggressor = new Tiger("A", battleField, 128, 64, Direction.DOWN);
		bullet = new Bullet(-100, -100, Direction.UP);
        contentOfQuadrant = new HashMap<AbstractTank,FieldObject>();
        contentOfQuadrant.put(defender, new Land(defender.getX(),defender.getY()));
        contentOfQuadrant.put(aggressor, new Land(aggressor.getX(),aggressor.getY()));
    

		tanksOnField = new AbstractTank[TANKS_IN_BATTLE];
		tanksOnField[0] = defender;
		tanksOnField[1] = aggressor;
		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.BF_WIDTH,
				battleField.BF_HEIGHT + 22));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	public void runTheGame() throws Exception {
		Action tmp;

		while (true) {
			for (AbstractTank t : tanksOnField) {
				tmp = t.setup();
				switch (tmp.getNextAct()) {
				case FIRE:
					processFire(tmp.getPointer());
					break;
				case MOVE:
					processMove(tmp);
					break;
				case TURN_RIGHT:
					turnRight(tmp.getPointer());
					break;
				case TURN_LEFT:
					turnLeft(tmp.getPointer());
					break;
				}
			}
		}

	}

	private String getQuadrantXY(int v, int h) {
		return (v - 1) * 64 + "_" + (h - 1) * 64;
	}

	public String getQuadrant(int x, int y) {
		return Integer.toString(y / 64) + "_" + Integer.toString(x / 64);
	}

	public int getQuadrantV(int x) {
		return x / 64;
	}

	public int getQuadrantH(int y) {
		return y / 64;
	}
	

	private boolean processInterception(Bullet bullet) throws Exception {
         FieldObject tmpObject;
			
		int y = bullet.getY()/64;
		int x = bullet.getX()/64;
		System.out.print("Y:" + bullet.getY());
		System.out.println("X:" + bullet.getX());
		System.out.print("y:" + y);
		System.out.println("x:" + x);
		
		if ((y >= 0) && (y < 9) && (x >= 0) && (x < 9)) {
			tmpObject = battleField.getFieldObject(y,x);
			if(tmpObject instanceof Water || tmpObject instanceof Land){
				return false;
			}else{
			  if(tmpObject instanceof Rock){
				  bullet.destroy();
			      return true;
			  }else{
				if(tmpObject instanceof Eagle || tmpObject instanceof Brick){
					battleField.setFieldObject(y, x, new Land(x*64,y*64));
			        System.out.println("Made empty");
			        bullet.destroy();
			        return true; 
				}else{
				  if(tmpObject instanceof AbstractTank){
					 battleField.setFieldObject(y, x, new Land(x*64,y*64));
			         System.out.println("Made empty");
			         bullet.destroy();
			         processDestroy((AbstractTank)tmpObject);
			         return true; 
				  }
				}
			  }
			}
		}
		return false;
	}

	public boolean checkIntersection(AbstractTank tank, int buletY, int buletX) {
		String coordinates = getQuadrant(tank.getX(), tank.getY());
		int separator = coordinates.indexOf("_");
		int y = Integer.parseInt(coordinates.substring(0, separator));
		int x = Integer.parseInt(coordinates.substring(separator + 1));
		if (y == buletY && x == buletX) {
			return true;
		} else {
			return false;
		}

	}

	public void processTurn(AbstractTank tank, Direction direction)
			throws Exception {
		tank.setDirection(direction);
		System.out.print("Direction" + tank.getDirection());
		repaint();
	}

	public void turnRight(AbstractTank tank) throws Exception {

		switch (tank.getDirection()) {
		case UP:
			tank.setDirection(Direction.RIGHT);
			break;
		case RIGHT:
			tank.setDirection(Direction.DOWN);
			break;
		case DOWN:
			tank.setDirection(Direction.LEFT);
			break;
		case LEFT:
			tank.setDirection(Direction.UP);
			break;
		}
		System.out.print("Direction" + tank.getDirection());
		repaint();
	}

	public void turnLeft(AbstractTank tank) throws Exception {

		switch (tank.getDirection()) {
		case UP:
			tank.setDirection(Direction.LEFT);
			break;
		case LEFT:
			tank.setDirection(Direction.DOWN);
			break;
		case DOWN:
			tank.setDirection(Direction.RIGHT);
			break;
		case RIGHT:
			tank.setDirection(Direction.UP);
			break;
		}
		System.out.print("Direction" + tank.getDirection());
		repaint();
	}

	public void processMove(Action action) throws Exception {
		int step = 1;
		int covered = 0;
		String coordinates;
		AbstractTank tank = action.getPointer();
	
		// check limits x: 0, 513; y: 0, 513
		if ((tank.getDirection() == Direction.UP && tank.getY() == 0)
				|| (tank.getDirection() == Direction.DOWN && tank.getY() >= 512)
				|| (tank.getDirection() == Direction.LEFT && tank.getX() == 0)
				|| (tank.getDirection() == Direction.RIGHT && tank.getX() >= 512)
				|| battleField.getNextFieldObject(getQuadrantV(tank.getY()),
						getQuadrantH(tank.getX()), tank.getDirection()) instanceof Rock
				|| battleField.getNextFieldObject(getQuadrantV(tank.getY()),
						getQuadrantH(tank.getX()), tank.getDirection()) == null
				|| battleField.getNextFieldObject(getQuadrantV(tank.getY()),
						getQuadrantH(tank.getX()), tank.getDirection()) instanceof Eagle
				|| battleField.getNextFieldObject(getQuadrantV(tank.getY()),
						getQuadrantH(tank.getX()), tank.getDirection()) instanceof AbstractTank
				|| (tank instanceof T34) && (battleField.getNextFieldObject(getQuadrantV(tank.getY()),
						getQuadrantH(tank.getX()), tank.getDirection()) instanceof Brick)) {
			System.out.println("[illegal move] direction: "
					+ tank.getDirection() + " tankX: " + tank.getX()
					+ ", tankY: " + tank.getY());
			action.setActionResult(false);
			return;
		}
		// insert the previous content of current quadrant 
		if(contentOfQuadrant.containsKey(tank)){
		   battleField.setFieldObject(getQuadrantV(tank.getY()),getQuadrantH(tank.getX()), contentOfQuadrant.get(tank));
		}else{
			battleField.setFieldObject(getQuadrantV(tank.getY()),getQuadrantH(tank.getX()), new Land(tank.getX(),
					tank.getY()));
		}
		
		while (covered < 64) {

			if (tank.getDirection() == Direction.UP) {
				coordinates = getQuadrant(tank.getX(), tank.getY() - 1);
				System.out.println("coordinates " + coordinates);
				tank.updateY(-step);
				System.out.println("[move up] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.DOWN) {
				coordinates = getQuadrant(tank.getX(), tank.getY() + 64);
				System.out.println("coordinates " + coordinates);
				tank.updateY(step);
				System.out.println("[move down] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else if (tank.getDirection() == Direction.LEFT) {
				coordinates = getQuadrant(tank.getX() - 1, tank.getY());
				System.out.println("coordinates " + coordinates);
				tank.updateX(-step);
				System.out.println("[move left] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			} else {
				coordinates = getQuadrant(tank.getX() + 64, tank.getY());
				System.out.println("coordinates " + coordinates);
				tank.updateX(step);
				System.out.println("[move right] direction: "
						+ tank.getDirection() + " tankX: " + tank.getX()
						+ ", tankY: " + tank.getY());
			}
			covered += step;
			repaint();
			Thread.sleep(tank.getMaxSpeed());

		}
		// save the previous content of current quadrant
		contentOfQuadrant.put(tank, battleField.getFieldObject(getQuadrantV(tank.getY()),getQuadrantH(tank.getX())));
		// mark the tank on the battle field
		battleField.setFieldObject(getQuadrantV(tank.getY()), getQuadrantH(tank.getX()), tank);
		action.setActionResult(true);
	}

	public void processFire(AbstractTank tank) throws Exception {
		bullet = new Bullet(tank.getX() + 25, tank.getY() + 25,
				tank.getDirection());
		int covered = 0;
		int step = 1;

		while (bullet.getX() > 0 && bullet.getX() <= 576 && bullet.getY() > 0
				&& bullet.getY() <= 576) {
			while (covered < 64) {

				if (bullet.getDirection() == Direction.UP) {
					bullet.updateY(-step);
					System.out.println("[move up] direction: "
							+ bullet.getDirection() + " bulX: " + bullet.getX()
							+ ", bulletY: " + bullet.getY());
				} else if (bullet.getDirection() == Direction.DOWN) {
					bullet.updateY(step);
					System.out.println("[move down] direction: "
							+ bullet.getDirection() + " bulX: " + bullet.getX()
							+ ", bulletY: " + bullet.getY());
				} else if (bullet.getDirection() == Direction.LEFT) {
					bullet.updateX(-step);
					System.out.println("[move left] direction: "
							+ bullet.getDirection() + " bulX: " + bullet.getX()
							+ ", bulletY: " + bullet.getY());
				} else {
					bullet.updateX(step);
					System.out.println("[move right] direction: "
							+ bullet.getDirection() + " bulX: " + bullet.getX()
							+ ", bulletY: " + bullet.getY());
				}
				covered += step;

				repaint();
				Thread.sleep(bullet.getSpeed());
			}
			covered = 0;
			if (processInterception(bullet)) {
				repaint();
				Thread.sleep(bullet.getSpeed());

			}
		}
	}

	
	public void processDestroy(AbstractTank tank) throws Exception {
		int[] coordinates = randomXY();

		if (tank instanceof Tiger){
			if(((Tiger) tank).getArmor()>0){
				((Tiger) tank).setArmor(0);
				return;
			}
		}
		tank.setX(-100);
		tank.setY(-100);
		repaint();
		TimeUnit.SECONDS.sleep(3);
		tank.setX(coordinates[0]);
		tank.setY(coordinates[1]);
		contentOfQuadrant.put(tank, new Land(coordinates[0],coordinates[1]));
		repaint();
	}

	public int[] randomXY() {

		int[][] coordinates = new int[3][];
		Random rand = new Random();
		int r = rand.nextInt(3);
		coordinates[0] = new int[2];
		coordinates[1] = new int[2];
		coordinates[2] = new int[2];
		coordinates[0][0] = 512;
		coordinates[0][1] = 512;
		coordinates[1][0] = 64;
		coordinates[1][1] = 64;
		coordinates[2][0] = 256;
		coordinates[2][1] = 256;

		return coordinates[r];
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		FieldObject tmpObject;
		int i = 0;
		
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				//g.fillRect(h * 64, v * 64, 64, 64);
				g.clearRect(h * 64, v * 64, 64, 64);
			}
		}

		
		for (int v = 0; v < battleField.getDimentionY(); v++) {
			for (int h = 0; h < battleField.getDimentionX(); h++) {
				tmpObject = battleField.getFieldObject(v,h);
						//battleField.getFieldObject(v,h).draw(g);
				if(!(tmpObject instanceof Water)){
				  if ((tmpObject instanceof AbstractTank)&&(!(contentOfQuadrant.get((AbstractTank)tmpObject) 
						instanceof Water))){
					  contentOfQuadrant.get((AbstractTank)tmpObject).draw(g);
				  }else{
				    tmpObject.draw(g);
				  }  
				}
			}
		}

		defender.draw(g);
		aggressor.draw(g);
		
		
		for (int v = 0; v < battleField.getDimentionY(); v++) {
			for (int h = 0; h < battleField.getDimentionX(); h++) {
				tmpObject = battleField.getFieldObject(v,h);
				if(tmpObject instanceof Water){
				   tmpObject.draw(g);
				}else{
					if ((tmpObject instanceof AbstractTank) && (contentOfQuadrant.get((AbstractTank)tmpObject) 
						instanceof Water)){
					  contentOfQuadrant.get((AbstractTank)tmpObject).draw(g);
				 	}
			}
		  }
		}
		bullet.draw(g);
	}
}
