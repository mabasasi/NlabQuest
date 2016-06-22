package action.skill;

import action.Action;
import main.TargetUnit;

/**
 * スキル定義クラス.
 * すべてのスキルはここで実装する.
 * @author morishige
 */
public class ActionFactory  {
	
	public static Action singleAttack() {
		return new DefaultAttack(Action.builder().name("通常攻撃").showName("こうげき")
				.explanation("通常攻撃")
				.useMp(0).point(0)
				.targetUnit(TargetUnit.enemy).isEntireAction(false));
	}
	
	public static Action slash() {
		return new DefaultAttack(Action.builder().name("斬撃").showName("ざんげき")
				.explanation("斬撃攻撃 敵の防御力を半減させる")
				.useMp(8).point(10)
				.targetUnit(TargetUnit.enemy).isEntireAction(false));
	}
	
	
	public static Action mera() {
		return new DefaultMagic(Action.builder().name("メラ").showName("メラ")
				.explanation("炎単体攻撃")
				.useMp(10).point(35)
				.targetUnit(TargetUnit.enemy).isEntireAction(false));
	}
	
	public static Action ionazun() {
		return new DefaultMagic(Action.builder().name("イオナズン").showName("イオナズン")
				.explanation("爆発全体攻撃")
				.useMp(25).point(100)
				.targetUnit(TargetUnit.enemy).isEntireAction(true));
	}
	
	public static Action hoimi() {
		return new DefaultHeal(Action.builder().name("ホイミ").showName("ホイミ")
				.explanation("単体回復")
				.useMp(10).point(30)
				.targetUnit(TargetUnit.party).isEntireAction(false));
	}
	
	
}
