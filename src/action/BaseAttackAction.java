package action;

import java.util.List;

import unit.Unit;

/**
 * 通常攻撃のベースクラス.
 * 通常攻撃は、このクラスを継承するべし.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class BaseAttackAction extends Action {
	
	public BaseAttackAction(Builder builder) {
		super(builder);
	}

	@Override
	public void action(Unit own, List<Unit> targets) {
		System.out.println(String.format("%s の %s。", own.getName(), this.getShowName()));
		sleep();
		
		// MPが残ってるか判断
		if (own.getMp() < useMp()) {
			System.out.println(String.format("しかし MPが足りなかった。"));
			return;
		}
		
		for (Unit tg : targets) {
			// ダメージを計算
			int dmg = (int)this.calculation(own, tg);
			
			if (dmg > 0) {
				// データ適用
				tg.setHp(tg.getHp() - dmg);
				System.out.println(String.format("%sは %dの ダメージを うけた。", tg.getName(), dmg));
				tg.showStatus();
				if (!tg.isSurvive()) {
					System.out.println(String.format("%s は ちからつきた。", tg.getName()));
				}
			} else {
				System.out.println(String.format("%sに ダメージを あたえられない。", tg.getName()));
			}
			sleep();
		}
	}

}
