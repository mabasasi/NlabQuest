package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import command.DefaultAICommand;
import unit.Unit;

/**
 * 戦闘中の全ユニット管理クラス.
 * @author shunichi
 */
public class UnitManager {
	
	private List<Unit> all;
	private List<Unit> party;
	private List<Unit> enemy;
	
	private List<Unit> temp;
	
	public UnitManager() {
		all = new ArrayList<>();
		party = new ArrayList<>();
		enemy = new ArrayList<>();
		temp = new ArrayList<>();
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
	 * TODO 強制的にAIを設定させているが、手動にしたい.
	 * @param unit 敵ユニット
	 */
	public void addEnemyUnit(Unit unit) {
		unit.setCommand(new DefaultAICommand());
		all.add(unit);
		enemy.add(unit);
	}

	
	
	
	/**
	 * ユニットリストを返却する.
	 * 既に、行動不能ユニットは除く.
	 * @param own 自分
	 * @param tg 対象ユニットenum
	 * @return 新規ユニットリスト、nullで失敗(基本的にない)
	 */
	public List<Unit> getUnits(Unit own, TargetUnit tg) {
		boolean isEnemy = enemy.contains(own);
		temp.clear();
		
		// ユニットの振り分け
		switch (tg) {
			case all:
				temp.addAll(all);
				break;
			case party:
				if (isEnemy) temp.addAll(enemy);
				else         temp.addAll(party);
				break;
			case enemy:
				if (isEnemy) temp.addAll(party);
				else         temp.addAll(enemy);
				break;
			case own:
				temp.add(own);
				break;
			case none:
				break;
			default :
				throw new UnsupportedOperationException("対象ユニットを指定して下さい.");
		}
		
		// 行動不能ユニットの除外
		Iterator<Unit> it = temp.iterator();
		while(it.hasNext()) {
			Unit unit = it.next();
			if (!unit.isSurvive()) {
				it.remove();
			}
		}
		
		return temp;
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
