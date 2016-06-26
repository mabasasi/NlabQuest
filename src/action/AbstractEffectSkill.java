package action;

import unit.Unit;

public class AbstractEffectSkill extends AbstractAction {

	public AbstractEffectSkill(Builder builder) {
		super(builder);
	}

	@Override
	protected String showTriggerMessage(Unit own) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected String showInvalidMessage(Unit own, Unit tg) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected String showDamageMessage(Unit own, Unit tg, int dmg) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	protected double damage(Unit own, Unit tg) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
