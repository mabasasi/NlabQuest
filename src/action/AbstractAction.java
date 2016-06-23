package action;

import java.util.List;

import unit.Unit;

/**
 * スキルのベースクラス.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class AbstractAction extends Action {

	public AbstractAction(Builder builder) {
		super(builder);
	}
	
	/**
	 * スキルを実行する際のメッセージ.
	 * ex)◯◯のこうげき！.
	 * @param own 自分
	 * @return 文字列
	 */
	protected abstract String showTriggerMessage(Unit own);
	
	/**
	 * 効果が無かった際のメッセージ.
	 * ex)◯◯にダメージを与えられない.
	 * @param own 自分
	 * @param tg 相手
	 * @return 文字列
	 */
	protected abstract String showInvalidMessage(Unit own, Unit tg);
	
	/**
	 * ダメージを与えた(回復した)際のメッセージ.
	 * ex)◯◯は dmg のダメージを受けた.
	 * @param own 自分
	 * @param tg 相手
	 * @param dmg ダメージ値
	 * @return 文字列
	 */
	protected abstract String showDamageMessage(Unit own, Unit tg, int dmg);
	
	/**
	 * ダメージ計算式.
	 * 無効の場合(回復でHPマックス)は、ダメージ値を0にする.
	 * @param own 自分自身
	 * @param tg 対象ユニット
	 * @return ダメージ
	 */
	protected abstract double damage(Unit own, Unit tg);

	@Override
	public void action(Unit own, List<Unit> targets) {
		System.out.println(showTriggerMessage(own));
		sleep();
		
		// MP処理
		if (useMp(own)) {
			for (Unit tg : targets) {
				// ダメージを計算＆表示
				if (calc(own, tg))	tg.showStatusWithSurvive();
				sleep();
			}
		}
	}
	
	/**
	 * ダメージを与える.
	 * @param own 自分
	 * @param tg 対象
	 * @return trueでダメージをあたえた、falseでダメージを与えられなかった.
	 */
	protected boolean calc(Unit own, Unit tg) {
		// ダメージを計算
		int dmg = (int) this.damage(own, tg);
		if (dmg <= 0) {
			System.out.println(showInvalidMessage(own, tg));
			return false;
		}
		
		// ダメージを与える(回復する)
		int t = (isHeal()) ? -1 : 1;	// 回復する場合は、dmgをマイナスにする
		tg.setHp(tg.getHp() - dmg*t);
		System.out.println(showDamageMessage(own, tg, dmg));
		return true;
	}
	
	
	/**
	 * MPを使用する.
	 * @param own 自分
	 * @return trueでMPを使用できた、falseでMP使用に失敗.
	 */
	protected boolean useMp(Unit own) {
		//　MPが残っているか判断
		if (own.getMp() < getMp()) {
			System.out.println(String.format("しかし MPが足りなかった。"));
			return false;
		}
		
		// MPを使用する
		own.setMp(own.getMp() - getMp());
		return true;
	}
}
