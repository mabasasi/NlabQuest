package action;

import unit.Unit;

/**
 * 魔法攻撃のベースクラス.
 * 魔法攻撃は、このクラスを継承するべし.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class AbstractMagicSkill extends AbstractAction {

	public AbstractMagicSkill(Builder builder) {
		super(builder);
	}

	@Override
	protected String showTriggerMessage(Unit own) {
		return String.format("%s は %s をとなえた。", own.getName(), getShowName());
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
