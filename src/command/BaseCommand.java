package command;

import java.util.ArrayList;
import java.util.List;

import action.Action;

/**
 * コマンド基底クラス.
 * @author shunichi
 */
public class BaseCommand {

	private List<Action> skill;
	
	public BaseCommand() {
		skill = new ArrayList<>();
	}
	
	
	/**
	 * アクションを追加する.
	 * @param acts アクション
	 */
	public void addAction(Action... acts) {
		for (Action act : acts) {
			skill.add(act);
		}
	}

	/**
	 * アクションを取得する.
	 * @param index インデックス
	 * @return アクション, nullで失敗
	 */
	public Action getAction(int index) {
		if (index < 0 || skill.size() <= index) {
			return null;
		}
		return skill.get(index);
	}
	
	/**
	 * アクションの配列を取得する.
	 * 内部で新規リスト作成.
	 * @return アクション配列
	 */
	public List<Action> getActionList() {
		return new ArrayList<>(skill);
	}
	
	/**
	 * コマンドの数を取得.
	 * @return コマンド数
	 */
	public int getActionSize() {
		return skill.size();
	}
	
}
