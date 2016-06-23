package action;

import unit.Unit;

/**
 * 通常攻撃のベースクラス.
 * 通常攻撃は、このクラスを継承するべし.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class AbstractAttackSkill extends AbstractAction {

	public AbstractAttackSkill(Builder builder) {
		super(builder);
	}

	@Override
	protected String showTriggerMessage(Unit own) {
		return String.format("%s の %s。", own.getName(), this.getShowName());
	}

	@Override
	protected String showInvalidMessage(Unit own, Unit tg) {
		return String.format("%sに ダメージを あたえられない。", tg.getName());
	}

	@Override
	protected String showDamageMessage(Unit own, Unit tg, int dmg) {
		return String.format("%sは %dの ダメージを うけた。", tg.getName(), dmg);
	}	
}
