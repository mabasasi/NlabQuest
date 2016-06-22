package main;

import java.util.ArrayList;
import java.util.List;

import unit.Unit;

/**
 * 戦闘中の全ユニット管理クラス.
 * @author shunichi
 */
public class UnitManager {
	
	private List<Unit> all;
	private List<Unit> party;
	private List<Unit> enemy;
	
	public UnitManager() {
		all = new ArrayList<>();
		party = new ArrayList<>();
		enemy = new ArrayList<>();
	}
	
	/**
	 * 味方ユニットを追加する.
	 * @param unit 味方ユニット
	 */
	public void addPartyUnit(Unit unit) {
		all.add(unit);
		party.add(unit);
	}
	
	/**
	 * 敵ユニットを追加する.
	 * @param unit 敵ユニット
	 */
	public void addEnemyUnit(Unit unit) {
		all.add(unit);
		enemy.add(unit);
	}
	
	
	/**
	 * ユニットリストを返却する.
	 * @param own 自分
	 * @param tg 対象ユニットenum
	 * @return ユニットリスト、nullで失敗(基本的にない)
	 */
	public List<Unit> getUnits(Unit own, TargetUnit tg) {
		boolean isEnemy = enemy.contains(own);
		
		switch (tg) {
		case all:
			return all;
		case party:
			if (!isEnemy)	return new ArrayList<>(party);
			return new ArrayList<>(enemy);
		case enemy:
			if (!isEnemy)	return new ArrayList<>(enemy);
			return new ArrayList<>(party);
		case own:
			List<Unit> owns = new ArrayList<>();
			owns.add(own);
			return owns;
		}
		
		return null;
	}
	
	/**
	 * 全体のステータスを表示する.
	 */
	public void showStatus() {
		System.out.println("みかた：");
		for (Unit unit : party) {
			unit.showStatus();
		}
		
		System.out.println("てき：");
		for (Unit unit : enemy) {
			unit.showStatus();
		}
	}
	
	/**
	 * 敵か味方が生存しているか確認.
	 * @return trueで続行、falseでゲーム終了
	 */
	public boolean isSurvive() {
		boolean p = check(party);
		boolean e = check(enemy);
		return p && e;
	}
	
	/**
	 * ユニットチェック.
	 * @param units ユニットリスト
	 * @return trueで続行、falseで終了
	 */
	private boolean check(List<Unit> units) {
		int n = 0;
		for (Unit unit : units) {
			if (!unit.isSurvive()) {
				n ++;
			}
		}
		return (n != units.size());
	}
	
	
}
