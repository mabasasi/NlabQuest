package action;

import java.util.List;

import unit.Unit;

/**
 * 各アクションの基底クラス.
 * ビルダーを使って初期化する.
 * 派生アクションは、このクラスをベースとする.
 * @author shunichi
 */
public abstract class Action extends ActionData {
	
	public Action(Builder builder) {
		super(builder);
	}
	
	/**
	 * ダメージ計算.
	 * @param own 自分自身
	 * @param tg 対象ユニット
	 * @return ダメージ
	 */
	protected abstract double calculation(Unit own, Unit tg);
	
	/**
	 * アクションを実行する.
	 * @param own 自分自身
	 * @param target 相手のリスト
	 */
	public abstract void action(Unit own, List<Unit> target);
	
	/**
	 * 一定時間待機する.
	 */
	protected void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {  }
	}
	
}
