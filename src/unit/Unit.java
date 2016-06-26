
package unit;


import action.Action;

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
		System.out.println(String.format("%s[%s] HP:%d/%d MP:%d/%d %s",
				getName(), getJob(), getHp(), getMaxHp(), getMp(), getMaxMp(), getStatus().getStatusString()));
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
	 * ターンが始まる前の処理.
	 * 複数回攻撃でも、一度しか実行されない.
	 */
	public void turnInit() {
		
	}
	
	/**
	 * ターンが終わる際の処理.
	 * 複数回攻撃でも、一度しか実行されない.
	 */
	public void turnEnded() {
		
	}
	
	
	
	/**
	 * 待機する.
	 */
	protected void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
}
