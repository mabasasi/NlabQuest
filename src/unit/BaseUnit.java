package unit;

import java.util.ArrayList;
import java.util.List;

import action.Action;
import action.skill.ActionFactory;
import command.Command;

/**
 * ユニットのデータクラス.
 * 内部にビルダーを実装してるんで、それ使って初期化する.
 * @author morishige
 */
public class BaseUnit {
	
	/**職業*/
	private final String job;
	/**名前*/
	private String name;

	/**スキル*/
	private Command command;
	
	/**最大HP*/
	private final int maxHp;
	/**最大MP*/
	private final int maxMp;
	
	/**現在HP*/
	private int hp;
	/**現在MP*/
	private int mp;
	/**攻撃力*/
	private int atk;
	/**防御力*/
	private int def;
	
	public BaseUnit(Builder builder) {
		this.job = builder.job;
		this.name = builder.name;
		this.maxHp = builder.hp;
		this.maxMp = builder.mp;
		this.hp = builder.hp;
		this.mp = builder.mp;
		this.atk = builder.atk;
		this.def = builder.def;
		
		this.command = new Command();
		command.addAction(builder.skill.toArray(new Action[0]));
	}
	
	/**
	 * 名前を設定する.
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}
	
//	/**
//	 * ユニットの実行できるコマンドを実装する.
//	 * @param act アクションコマンド
//	 */
//	public void addAction(Action act) {
//		System.out.println(String.format("%s は %s をおぼえた!", getName(), act.getName()));
//		command.addAction(act);
//	}
	
	/**
	 * ユニットのAIを設定する.
	 * @param command AIコマンド
	 */
	public void setCommand(Command command) {
		command.addAction(this.command.getActionList());
		this.command = command;
	}
	
	/**
	 * ユニットの現在HPを設定する.
	 * <p>0以下は0に修正する.</p>
	 * @param hp 現在HP
	 */
	public void setHp(int hp) {
		this.hp = hp;
		if (getHp() < 0) {
			this.hp = 0;
		}
		if (getHp() > getMaxHp()) {
			this.hp = getMaxHp();
		}
	}
	
	/**
	 * ユニットの現在Mpを設定する.
	 * <p>0以下は0に修正する.</p>
	 * @param mp 現在Mp
	 */
	public void setMp(int mp) {
		this.mp = mp;
		if (getMp() < 0) {
			this.mp = 0;
		}
	}
	
	/**
	 * ユニットの生存状態を確認する.
	 * @return trueで生存、falseで死亡
	 */
	public boolean isSurvive() {
		return (getHp() > 0);
	}
	
	/**
	 * ユニットのステータスを表示する.
	 */
	public void showStatus() {
		System.out.println(String.format("%s[%s] HP:%d/%d MP:%d/%d",
				getName(), getJob(), getHp(), getMaxHp(), getMp(), getMaxMp()));
	}
	
	/**
	 * ユニットのステータスと、生存状態を表示する.
	 */
	public void showStatusWithSurvive() {
		showStatus();
		if (!isSurvive()) {
			System.out.println(String.format("%s は ちからつきた。", getName()));
		}
	}
	
	
	
	public Command getCommand() {
		return command;
	}
	
	public String getJob() {
		return job;
	}
	
	public String getName() {
		return name;
	}
	
	public int getMaxHp() {
		return maxHp;
	}
	
	public int getMaxMp() {
		return maxMp;
	}
	
	public int getHp() {
		return hp;
	}
	
	public int getMp() {
		return mp;
	}
	
	public int getAtk() {
		return atk;
	}
	
	public int getDef() {
		return def;
	}
	
	
	
	public static Builder builder() {
		return new Builder();
	}
	
	
	/**
	 * ユニットのビルダークラス.
	 * @author morishige
	 */
	public static class Builder {
		private String job;
		private String name;
		private int hp;
		private int mp;
		private int atk;
		private int def;
		
		private List<Action> skill;
		
		private Builder() {
			skill = new ArrayList<>();
			skill.add(ActionFactory.singleAttack());
		}
		
		
		public Builder job(String job) {
			this.job = job;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder hp(int hp) {
			this.hp = hp;
			return this;
		}
		
		public Builder mp(int mp) {
			this.mp = mp;
			return this;
		}
		
		public Builder atk(int atk) {
			this.atk = atk;
			return this;
		}
		
		public Builder def(int def) {
			this.def = def;
			return this;
		}
		
		public Builder action(Action action) {
			skill.add(action);
			return this;
		}
		
	}
}
