package tanks;
import serviceclasses.ActionField;
import serviceclasses.BattleField;
import serviceclasses.Direction;

public class BT7 extends AbstractTank {
	int maxSpeed = 72;

	public BT7() {
		super();
	}

	public BT7(ActionField af, BattleField battle, int x, int y, Direction direction) {
		super(af, battle, x, y, direction);
		speed = 5;
	}

	public BT7(ActionField af, BattleField battle) {
		super(af, battle);
		speed = 5;
	}

	@Override
	public void move() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("BT7 is moving");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Speed of BT7 is " + maxSpeed;
	}

}
