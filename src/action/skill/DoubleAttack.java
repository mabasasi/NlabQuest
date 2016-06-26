package action.skill;

import java.util.List;

import action.AbstractAttackSkill;
import unit.Unit;

/**
 * 2回攻撃のスキル.
 * ダメージを ATK + point - DEF として扱う.
 * 攻撃処理を二度行う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public class DoubleAttack extends AbstractAttackSkill {

	public DoubleAttack(Builder builder) {
		super(builder);
	}
	
	@Override
	public void action(Unit own, List<Unit> targets) {
		System.out.println(showTriggerMessage(own));
		sleep();
		
		// MP処理
		if (useMp(own)) {
			for (Unit tg : targets) {
				for (int i=0; i<2; i++) { 
					// ダメージを計算＆表示
					if (calc(own, tg))	tg.showStatusWithSurvive();
					sleep();
				}
			}
		}
	}
	
	
	@Override
	protected double damage(Unit own, Unit tg) {
		return own.getAtk() + this.getPoint() - tg.getDef();
	}

}
