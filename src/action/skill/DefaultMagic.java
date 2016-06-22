package action.skill;

import action.BaseMagicAction;
import unit.Unit;

/**
 * 魔法攻撃のスキル.
 * ダメージを point - DEF として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultMagic extends BaseMagicAction {

	public DefaultMagic(Builder builder) {
		super(builder);
	}

	@Override
	protected double calculation(Unit own, Unit tg) {
		return getPoint() - tg.getDef();
	}

}
