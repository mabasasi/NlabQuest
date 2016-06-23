
package unit;


import java.awt.Toolkit;
import java.util.List;

import action.Action;
import main.UnitManager;

/**
 * 各ユニットの基底クラス.
 * ビルダーを使って初期化する.
 * 派生ユニットは、このクラスをベースとする.
 * @author shunichi
 */
public class Unit extends BaseUnit {
	
	
	public Unit(Builder builder) {
		super(builder);
		
		System.out.println(String.format("%s 「%s」が たんじょうした!", getJob(), getName()));
		System.out.println(String.format("-> HP:%d, MP:%d, ATK:%d, DEF:%d", getHp(), getMp(), getAtk(), getDef()));
		for (Action action : getCommand().getActionList()) {
			System.out.println(String.format("-> %sは %sを おぼえた!", getName(), action.getShowName()));
		}
	}
	

	/**
	 * ユニットの生存状態を確認する.
	 * @return trueで生存、falseで死亡
	 */
	public boolean isSurvive() {
		return (getHp() > 0);
	}
	
	/**
	 * ユニットのステータスを表示する.
	 */
	public void showStatus() {
		System.out.println(String.format("%s[%s] HP:%d/%d MP:%d/%d",
				getName(), getJob(), getHp(), getMaxHp(), getMp(), getMaxMp()));
	}
	
	/**
	 * ユニットのステータスと、生存状態を表示する.
	 */
	public void showStatusWithSurvive() {
		showStatus();
		if (!isSurvive()) {
			System.out.println(String.format("%s は ちからつきた。", getName()));
		}
	}
	
	
	
	
	/**
	 * ユニットの戦闘行動.
	 * @param manager ユニット管理クラス
	 * @param ai trueで自動選択、falseで手動選択
	 */
	public void command(UnitManager manager, boolean ai) {
		runTurn();
		
		// 値の入力
		Action action = getCommand().showMenu(this);
		
		// 攻撃処理
		if (action != null) {
			// 対象の選択(units:対象のユニット、target:抽出されたユニット)
			List<Unit> units = manager.getUnits(this, action.getTargetUnit());
			List<Unit> target = getCommand().showTarget(action, units);
			
			if (target != null) {
				// コマンドの実行
				action.action(this, target);
				// 再行動フラグで、追加攻撃
				if (action.isReact()) {
					System.out.println("◆さいこうどう!");
					sleep();
					command(manager, ai);
				}
				return;
			}
			
			// ターゲット選択できない場合は、再び選択
			System.out.println("エラー. ◆さいこうどう!");
			command(manager, ai);
			return;
		}
		
		// アクション選択できない場合は、再び選択
		System.out.println("エラー. ◆さいこうどう!");
		command(manager, ai);
		return;
	}
	
	

	
	
	/**
	 * 待機する.
	 */
	protected void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	/**ターン開始処理*/
	private void runTurn() {
		System.out.println();
		Toolkit.getDefaultToolkit().beep();
		
		this.showStatus();
	}
}
