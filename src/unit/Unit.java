
package unit;


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
	 * ユニットの戦闘行動.
	 * @param manager ユニット管理クラス
	 * @param ai trueで自動選択、falseで手動選択
	 */
	public void command(UnitManager manager, boolean ai) {
		
		// 値の入力
		Action action = getCommand().showMenu(this);
		
		// コマンドの実行
		if (action != null) {
			// 対象の選択(units:対象のユニット、target:抽出されたユニット)
			List<Unit> units = manager.getUnits(this, action.getTargetUnit());
			List<Unit> target = getCommand().showTarget(action, units);
			
			if (target != null) {
				action.action(this, target);
				return;
			}
			
			// 選択できない場合は、再び選択
			command(manager, ai);
			return;
		}
		
		System.out.println(String.format("%s は何もしなかった。", getName()));
	}
	
}
