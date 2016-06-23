package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import action.Action;
import unit.Unit;

/**
 * コマンド管理クラス.
 * @author shunichi
 */
public class Command {
	private static Scanner scanner = new Scanner(System.in);
	private List<Action> skill;
	
	public Command() {
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
	 * コマンド番号を選択する.
	 * @param own 自分
	 * @return 実行するアクション、nullで失敗
	 */
	public Action showMenu(Unit own) {
		System.out.println(String.format("%s はどうする？", own.getName()));
		System.out.println(menuMessage(skill));
		System.out.print("コマンド : ");
		
		String in = scanner.nextLine();
		try {
			int n = Integer.valueOf(in);
			return getAction(n);
		} catch (NumberFormatException ex) {
			return null;
		}
	}
	
	/**
	 * 対象を指定する.
	 * @param action アクション
	 * @param units ユニットリスト
	 * @return 対象のユニットリスト、nullで失敗
	 */
	public List<Unit> showTarget(Action action, List<Unit> units) {
		// 全体=trueなら、リスト全体を対象
		if (action.isEntire()) {
			return units;
		}

		List<Unit> list = new ArrayList<>();
		// 対象が1人だけなら終了
		if (units.size() == 1) {
			list.add(units.get(0));
			return list;
		}
		
		System.out.println("だれに？");
		System.out.println(targetMessage(units));
		System.out.print("コマンド : ");
		
		String in = scanner.nextLine();
		try {
			int n = Integer.valueOf(in);
			list.add(units.get(n));
			return list;
		} catch (NumberFormatException ex) {
			return null;
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
	 * @return アクション配列
	 */
	public Action[] getActionList() {
		return skill.toArray(new Action[0]);
	}
	
	/**
	 * コマンドの数を取得.
	 * @return コマンド数
	 */
	public int getActionSize() {
		return skill.size();
	}
	
	
	
	
	
	/**
	 * コマンドメニューの文字列.
	 * @param acts アクションリスト
	 * @return 文字列
	 */
	private String menuMessage(List<Action> acts) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		for (Action act : acts) {
			sb.append(i++).append("=").append(act.getName());
			sb.append("(").append(act.mp()).append(")");
			sb.append("、");
		}
		
		String str = sb.toString();
		return str.substring(0, str.length()-1);
	}
	
	/**
	 * コマンド対象の文字列.
	 * @param units ユニットリスト
	 * @return　文字列
	 */
	private String targetMessage(List<Unit> units) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		for (Unit unit : units) {
			sb.append(i++).append("=").append(unit.getName());
			sb.append("(").append(unit.getHp()).append("/").append(unit.getMaxHp()).append(")");
			sb.append("、");
		}
		
		String str = sb.toString();
		return str.substring(0, str.length()-1);
	}
	

}
