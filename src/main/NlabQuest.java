package main;

import java.awt.Toolkit;
import java.util.Scanner;

import unit.Unit;
import unit.UnitFactory;

/**
 * メイン.
 * @author morishige
 */
public class NlabQuest {

	//　http://dq5nds.myafil.net/message_battle.html
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws InterruptedException {
		
		UnitManager manager = new UnitManager();
		manager.addPartyUnit(UnitFactory.hero("Aさん"));
		manager.addPartyUnit(UnitFactory.wizard("Bさん"));
		manager.addPartyUnit(UnitFactory.sage("Cさん"));
		manager.addPartyUnit(UnitFactory.warrior("Dさん"));
		
		manager.addEnemyUnit(UnitFactory.kingDevil("まおー"));

		
		
		
		
		
		System.out.println("help 実装したんで、使って下さい。");
		// 無限ループ(HPが0になったら終了)
		int turn = 1;
		main:
		while(true) {
			System.out.println("\n<<"+(turn++)+" ターン目>>");
			manager.showStatus();
			Toolkit.getDefaultToolkit().beep();
			
			// 各ユニットの行動
			for (Unit unit : manager.getUnits(null, TargetUnit.all)) {
				// 生存しているなら行動する
				if (unit.isSurvive()) {
					unit.command(manager, false);
					if (!manager.isSurvive()) {
						break main;
					}
				}
			}
		}
		
		System.out.println("\nたたかいは おわった。");
	}
	
}
