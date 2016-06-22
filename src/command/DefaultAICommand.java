package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import action.Action;
import unit.Unit;

/**
 * 通常AIコマンド管理クラス.
 * @author shunichi
 */
public class DefaultAICommand extends Command {
	private static Random random = new Random();
	
	public DefaultAICommand() {
		super();
	}
	
	@Override
	public Action showMenu(Unit own) {
		sleep();
		
		// 半分は通常攻撃
		if (getActionSize() <= 1 || random.nextBoolean()) {
			return getAction(0);
		}
		
		//アクションをランダムで選択
		int n = random.nextInt(getActionSize()-1)+1;
		
		// MPチェック(足りないなら通常攻撃)
		Action act = getAction(n);
		if (act == null || own.getMp() <= act.useMp()) {
			return getAction(0);
		}
		return act;
	}
	
	@Override
	public List<Unit> showTarget(Action action, List<Unit> units) {
		List<Unit> list = new ArrayList<>();
		
		int n = random.nextInt(units.size());
		list.add(units.get(n));
		return list;
	}
	
	/**
	 * 一定時間待機する.
	 */
	protected void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {  }
	}

}
