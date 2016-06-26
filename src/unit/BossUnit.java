package unit;

/**
 * ボス用のユニット.
 * 毎ターン2回攻撃可能.
 * @author shunichi
 */
public class BossUnit extends Unit {
	
	public BossUnit(Builder builder) {
		super(builder);
	}

	@Override
	public void turnInit() {
		Status status = getStatus();
		status.setDoubleAttack(1);
	}
	
	@Override
	public void turnEnded() {
		Status status = getStatus();
		status.setDoubleAttack(1);
	}
}
