package action.skill;

import action.AbstractMagicSkill;
import unit.Unit;

/**
 * 魔法攻撃のスキル.
 * ダメージを point - DEF として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DefaultMagic extends AbstractMagicSkill {

	public DefaultMagic(Builder builder) {
		super(builder);
	}

	@Override
	protected double damage(Unit own, Unit tg) {
		return this.getPoint() - tg.getDef();
	}

}
