package unit;

import action.skill.ActionFactory;

/**
 * ユニット定義クラス.
 * @author morishige
 */
public class UnitFactory {
	
	public static Unit hero(String name) {
		return new Unit(Unit.builder().job("ゆうしゃ").name(name)
				.hp(320).mp(24).atk(30).def(20)
				.action(ActionFactory.slash())
				.action(ActionFactory.hoimi())
				.action(ActionFactory.baikirut()));
	}
	
	public static Unit wizard(String name) {
		return new Unit(Unit.builder().job("まほうつかい").name(name)
				.hp(200).mp(30).atk(15).def(0)
				.action(ActionFactory.mera()));
	}
	
	public static Unit sage(String name) {
		return new Unit(Unit.builder().job("けんじゃ").name(name)
				.hp(260).mp(50).atk(10).def(0)
				.action(ActionFactory.hoimi()));
	}
	
	public static Unit warrior(String name) {
		return new Unit(Unit.builder().job("せんし").name(name)
				.hp(360).mp(50).atk(30).def(40)
				.action(ActionFactory.doubleAttack()));
	}
	
	
	public static Unit kingDevil(String name) {
		Unit unit = new BossUnit(Unit.builder().job("まおう").name(name)
				.hp(600).mp(75).atk(70).def(0)
				.action(ActionFactory.ionazun()));
		unit.getStatus().setDoubleAttack(1);
		return unit;
	}
}
