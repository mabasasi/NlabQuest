package action;

import java.util.List;

import unit.Unit;

/**
 * 回復魔法のスキル.
 * 回復魔法を point として扱う.
 * ビルダーを使って初期化する.
 * @author shunichi
 */
public abstract class BaseHealAction extends Action {

	public BaseHealAction(Builder builder) {
		super(builder);
	}
	
	@Override
	public void action(Unit own, List<Unit> targets) {
		System.out.println(String.format("%s は %s をとなえた。", own.getName(), getShowName()));
		sleep();
		
		// MPが残ってるか判断
		if (own.getMp() < useMp()) {
			System.out.println(String.format("しかし MPが足りなかった。"));
			return;
		}
		
		// MPを使用する
		own.setMp(own.getMp() - useMp());
		
		for (Unit tg : targets) {
			// ダメージを計算
			int dmg = (int)this.calculation(own, tg);
			
			if (dmg > 0) {
				// データ適用
				tg.setHp(tg.getHp() + dmg);
				System.out.println(String.format("%sは %dポイント かいふくした。", tg.getName(), dmg));
			} else {
				System.out.println(String.format("%sの HPは まんたんだ。", tg.getName()));
			}
			sleep();
		}
	}

}
