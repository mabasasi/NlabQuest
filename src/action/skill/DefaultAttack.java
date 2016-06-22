package action.skill;

import action.BaseAttackAction;
import unit.Unit;

/**
 * 通常攻撃のスキル.
 * ダメージを ATK + point - DEF として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultAttack extends BaseAttackAction {

	public DefaultAttack(Builder builder) {
		super(builder);
	}

	@Override
	protected double calculation(Unit own, Unit tg) {
		return own.getAtk() + getPoint() - tg.getDef();
	}

	
}
