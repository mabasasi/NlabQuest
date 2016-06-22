package action.skill;

import action.BaseHealAction;
import unit.Unit;

/**
 * 回復魔法のベースクラス.
 * 回復魔法は、このクラスを継承するべし.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultHeal extends BaseHealAction {

	public DefaultHeal(Builder builder) {
		super(builder);
	}

	@Override
	protected double calculation(Unit own, Unit tg) {
		return getPoint();
	}

}
