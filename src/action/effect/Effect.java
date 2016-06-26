package action.effect;

import unit.Unit;

/**
 * アクションの効果実装クラス.
 * @author shunichi 
 */
public abstract class Effect {
	
	/**
	 * エフェクトを実行する.
	 * @param own 自分
	 */
	public abstract void effect(Unit own);
	
}
