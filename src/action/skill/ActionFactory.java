package action.skill;

import action.Action;
import action.effect.TwiceDamage;
import main.TargetUnit;

/**
 * スキル定義クラス.
 * すべてのスキルはここで実装する.
 * @author morishige
 */
public class ActionFactory  {
	/*
	    private String name;
		private String showName;
		private String note;
		private int mp;
		private int point;
		private TargetUnit targetUnit;
		private boolean isEntire;
		private boolean isHeal;
		private boolean isReact;
	 */
	
	
	public static Action singleAttack() {
		return new DefaultAttack(Action.builder().name("通常攻撃").showName("こうげき")
				.note("通常攻撃.\n全てのユニットが使用できる.")
				.targetUnit(TargetUnit.enemy));
	}
	
	public static Action doubleAttack() {
		return new DoubleAttack(Action.builder().name("ダブルアタック").showName("ダブルアタック")
				.note("2回攻撃.\n通常攻撃を2回行うことが出来る.")
				.mp(10).point(0)
				.targetUnit(TargetUnit.enemy));
	}
	
	public static Action slash() {
		return new DefaultAttack(Action.builder().name("斬撃").showName("ざんげき")
				.note("斬撃攻撃 敵の防御力を半減させる")
				.mp(8).point(10)
				.targetUnit(TargetUnit.enemy));
	}
	
	
	
	public static Action baikirut() {
		return new EffectAction(Action.builder().name("バイキルト").showName("バイキルト")
				.note("次の攻撃のダメージを二倍にする.")
				.mp(5)
				.targetUnit(TargetUnit.own)
				.effect(new TwiceDamage()));
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
				.note("行動.\nスキルの説明を表示する.").targetUnit(TargetUnit.own).isReact(true));
	}
	
}
