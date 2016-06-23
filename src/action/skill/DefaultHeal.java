package action.skill;

import action.AbstractHealSkill;
import unit.Unit;

/**
 * 回復魔法のスキル.
 * 回復量を point として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultHeal extends AbstractHealSkill {

	public DefaultHeal(Builder builder) {
		super(builder);
	}

	@Override
	protected double damage(Unit own, Unit tg) {
		if (own.getHp() == own.getMaxHp()) {
			return 0;
		}
		
		return this.getPoint();
	}

}
