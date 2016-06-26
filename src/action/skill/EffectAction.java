package action.skill;

import java.util.List;

import action.AbstractAction;
import unit.Unit;

public class EffectAction extends AbstractAction {

	public EffectAction(Builder builder) {
		super(builder);
	}

	@Override
	protected String showTriggerMessage(Unit own) {
		return String.format("%s の %s。", own.getName(), this.getShowName());
	}

	@Override
	protected String showInvalidMessage(Unit own, Unit tg) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected String showDamageMessage(Unit own, Unit tg, int dmg) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected double damage(Unit own, Unit tg) {
		return 0;
	}
	
	@Override
	public void action(Unit own, List<Unit> targets) {
		System.out.println(showTriggerMessage(own));
		sleep();
		
		// MP処理
		if (useMp(own)) {
			getEffect().effect(own);
		}
	}

}
