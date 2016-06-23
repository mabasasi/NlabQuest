package action;

import unit.Unit;

/**
 * 回復魔法のスキル.
 * 回復魔法を point として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class AbstractHealSkill extends AbstractAction {

	public AbstractHealSkill(Builder builder) {
		super(builder);
	}

	@Override
	protected String showTriggerMessage(Unit own) {
		return String.format("%s は %s をとなえた。", own.getName(), getShowName());
	}

	@Override
	protected String showInvalidMessage(Unit own, Unit tg) {
		return String.format("%sの HPは まんたんだ。", tg.getName());
	}

	@Override
	protected String showDamageMessage(Unit own, Unit tg, int dmg) {
		return String.format("%sは %dポイント かいふくした。", tg.getName(), dmg);
	}

}
