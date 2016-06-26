package main;

import java.awt.Toolkit;
import java.util.List;

import action.Action;
import command.Command;
import unit.Status;
import unit.Unit;

/**
 * ユニットを実際に動かすクラス.
 * @author shunichi
 */
public class UnitTurnMover {
	
	private final UnitManager manager;
	
	public UnitTurnMover(UnitManager manager) {
		this.manager = manager;
	}
	
	
	
	
	
	/**
	 * ターン処理.
	 * @param unit 自身
	 * @return trueでゲーム終了、falseで続行
	 */
	public boolean turn(Unit unit) {
		if (unit.isSurvive()) {
			unit.turnInit();
			
			try {
				this.action(unit);
			} catch (StackOverflowError er) {
				System.out.println("※※※動きすぎです！※※※");
			}
			
			unit.turnEnded();
		}
		return !manager.isSurvive();
	}
	
	
	
	/**
	 * 実際の行動定義.
	 * @param own 自身
	 */
	private void action(Unit own) {
		Command command = own.getCommand();
		Status status = own.getStatus();
		
		// 攻撃開始時の処理
		this.actionStart(own);
		
		// アクションの選択
		Action action = command.showMenu(own);
		if (action == null)		inputError(own);
		
		// 対象の選択(units:対象のユニット、target:抽出されたユニット)
		List<Unit> units = manager.getUnits(own, action.getTargetUnit());
		List<Unit> target = command.showTarget(action, units);
		if (target == null)		inputError(own);
		
		// コマンドの実行
		action.action(own, target);
		
		// 再行動処理(アクションのフラグ、ユニットのステータス)
		if (action.isReact() || status.isDoubleAttack()) {
			System.out.println("◆さいこうどう!");
			action(own);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 攻撃開始処理.
	 * @param unit 自分
	 */
	private void actionStart(Unit unit) {
		System.out.println();
		Toolkit.getDefaultToolkit().beep();
		
		unit.showStatus();
	}
	
	
	/**
	 * 入力エラー処理.
	 * @param unit 自分
	 */
	private void inputError(Unit unit) {
		System.out.println("入力エラー. ◆再行動!");
		action(unit);
	}
	
	
}
