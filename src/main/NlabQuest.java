package main;

import java.awt.Toolkit;

import unit.Unit;
import unit.UnitFactory;

/**
 * メイン.
 * @author morishige
 */
public class NlabQuest {
	
	public static void main(String[] args) throws InterruptedException {
		//　http://dq5nds.myafil.net/message_battle.html
		
		UnitManager manager = new UnitManager();
		manager.addPartyUnit(UnitFactory.hero("Kさい"));
		manager.addPartyUnit(UnitFactory.wizard("Iぶせ"));
		manager.addPartyUnit(UnitFactory.sage("Tなか"));
		manager.addPartyUnit(UnitFactory.warrior("Mしげ"));
		
		manager.addEnemyUnit(UnitFactory.kingDevil("Eさわ"));

		
		
		// 無限ループ(HPが0になったら終了)
		int turn = 1;
		main:
		while(true) {
			System.out.println("\n"+turn+" ターン目：");
			manager.showStatus();
			Toolkit.getDefaultToolkit().beep();
			
			// 各ユニットの行動
			for (Unit unit : manager.getUnits(null, TargetUnit.all)) {
				// 生存しているなら行動する
				if (unit.isSurvive()) {
					// 行動
					System.out.println();
					Toolkit.getDefaultToolkit().beep();
					
					unit.showStatus();
					unit.command(manager, false);
					// 全体のチェック
					if (!manager.isSurvive()) {
						break main;
					}
				}
			}
		}
		
		System.out.println("\nたたかいは おわった。");
	}
	
}
