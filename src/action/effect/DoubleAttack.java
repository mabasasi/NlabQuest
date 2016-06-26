package action.effect;

import unit.Status;
import unit.Unit;

public class DoubleAttack extends Effect {

	@Override
	public void effect(Unit own) {
		System.out.println(String.format("%sは 次のターン2回攻撃が出来る。", own.getName()));
		Status status = own.getStatus();
		status.setDoubleAttack(1);
	}

}
