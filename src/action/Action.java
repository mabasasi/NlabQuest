package action;

import java.util.List;

import unit.Unit;

/**
 * 各アクションの基底クラス.
 * ビルダーを使って初期化する.
 * 派生アクションは、このクラスをベースとする.
 * 一応、アクションを実装するときは、abstractクラスを経由すべし?.
 * @author shunichi
 */
public abstract class Action extends BaseAction {

	public Action(Builder builder) {
		super(builder);
	}
	
	/**
	 * アクションを実行する.
	 * @param own 自分自身
	 * @param targets 相手のリスト
	 */
	public abstract void action(Unit own, List<Unit> targets);

	

	/**
	 * 待機する.
	 */
	protected void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
}
