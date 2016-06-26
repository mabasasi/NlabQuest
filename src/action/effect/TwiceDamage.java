package action.effect;

import unit.Status;
import unit.Unit;

public class TwiceDamage extends Effect {

	@Override
	public void effect(Unit own) {
		System.out.println(String.format("%sは 次の攻撃力が二倍になった.", own.getName()));
		Status status = own.getStatus();
		status.setTwiceDamage(1);
	}

}
