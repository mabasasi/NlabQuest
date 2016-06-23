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
				.note("通常攻撃.\n全てのユニットが使用できる.")
				.targetUnit(TargetUnit.enemy));
	}
	
	public static Action slash() {
		return new DefaultAttack(Action.builder().name("斬撃").showName("ざんげき")
				.note("斬撃攻撃 敵の防御力を半減させる")
				.mp(8).point(10)
				.targetUnit(TargetUnit.enemy));
	}
	
	
	public static Action mera() {
		return new DefaultMagic(Action.builder().name("メラ").showName("メラ")
				.note("炎単体攻撃")
				.mp(10).point(35)
				.targetUnit(TargetUnit.enemy));
	}
	
	public static Action ionazun() {
		return new DefaultMagic(Action.builder().name("イオナズン").showName("イオナズン")
				.note("爆発全体攻撃")
				.mp(25).point(100)
				.targetUnit(TargetUnit.enemy).isEntire(true));
	}
	
	public static Action hoimi() {
		return new DefaultHeal(Action.builder().name("ホイミ").showName("ホイミ")
				.note("単体回復")
				.mp(10).point(30)
				.targetUnit(TargetUnit.party).isHeal(true));
	}
	
	
	
	public static Action descript() {
		return new DescriptAction(Action.builder().name("説明").showName("せつめい")
				.note("行動.\nスキルの説明を表示する.").isEntire(true).isReact(true));
	}
	
}
