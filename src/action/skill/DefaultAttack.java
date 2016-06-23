package action.skill;

import action.AbstractAttackSkill;
import unit.Unit;

/**
 * 通常攻撃のスキル.
 * ダメージを ATK + point - DEF として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultAttack extends AbstractAttackSkill {

	public DefaultAttack(Builder builder) {
		super(builder);
	}

	@Override
	protected double damage(Unit own, Unit tg) {
		return own.getAtk() + this.getPoint() - tg.getDef();
	}
	
}
