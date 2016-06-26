package action.skill;

import java.util.List;
import java.util.Scanner;

import action.Action;
import command.Command;
import main.NlabQuest;
import unit.Unit;

public class DescriptAction extends Action {
	private static Scanner scanner = NlabQuest.scanner;

	public DescriptAction(Builder builder) {
		super(builder);
	}

	@Override
	public void action(Unit own, List<Unit> targets) {
		Command com = own.getCommand();
		
		System.out.println("どのスキルをみる？");
		System.out.println(skillMessage(com.getActionList()));
		System.out.print("コマンド : ");
		
		String in = scanner.next();
		try {
			int n = Integer.valueOf(in);
			Action act = com.getAction(n);
			if (act != null) {
				System.out.println("----------------------------------------");
				System.out.println(showSkill(act));
				System.out.println("----------------------------------------");
			}
		} catch (Exception ex) {  }
	}

	
	
	
	/**
	 * スキルの説明文.
	 * @param act アクション
	 * @return 文字列
	 */
	private String showSkill(Action act) {
		return String.format("%s(%s) MP:%d, point:%d\n"
				+ "対象:%s, 全体:%s, 回復:%s\n"
				+ "%s",
				act.getName(), act.getShowName(), act.getMp(), act.getPoint(),
				act.getTargetUnit().toString(), act.isEntire(), act.isHeal(), 
				act.getNote());
	}
	
	/**
	 * コマンドメニューの文字列.
	 * @param acts アクションリスト
	 * @return 文字列
	 */
	private String skillMessage(List<Action> acts) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		
		for (Action act : acts) {
			sb.append(i++).append("=").append(act.getName());
			sb.append("(").append(act.getMp()).append(")");
			sb.append("、");
		}
		
		String str = sb.toString();
		return str.substring(0, str.length()-1);
	}
}
