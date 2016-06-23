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
	/**スピード*/
	private int spd;
	/**運*/
	private int luck;
	
	/**スキル*/
	private Command command;
	
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
	
	/**
	 * ユニットのAIを設定する.
	 * @param command AIコマンド
	 */
	public void setCommand(Command command) {
		command.addAction(this.command.getActionList().toArray(new Action[0]));
		this.command = command;
	}
	
	/**
	 * ユニットの現在HPを設定する.
	 * 0以下は0に修正する.
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
	 * 0以下は0に修正する.
	 * @param mp 現在MP
	 */
	public void setMp(int mp) {
		this.mp = mp;
		if (getMp() < 0) {
			this.mp = 0;
		}
		if (getMp() > getMaxMp()) {
			this.mp = getMaxHp();
		}
	}
	



	/**
	 * ユニットの職業を取得する.
	 * @return 職業
	 */
	public String getJob() {
		return job;
	}
	
	/**
	 * ユニットの名前を取得する.
	 * @return 名前
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ユニットの最大HPを取得する.
	 * @return 最大HP
	 */
	public int getMaxHp() {
		return maxHp;
	}
	
	/**
	 * ユニットの最大MPを取得する.
	 * @return 最大MP
	 */
	public int getMaxMp() {
		return maxMp;
	}
	
	/**
	 * ユニットのHPを取得する.
	 * @return 現在HP
	 */
	public int getHp() {
		return hp;
	}
	
	/**
	 * ユニットのMPを取得する.
	 * @return 現在MP
	 */
	public int getMp() {
		return mp;
	}
	
	/**
	 * ユニットの攻撃力を取得する.
	 * @return 攻撃力
	 */
	public int getAtk() {
		return atk;
	}
	
	/**
	 * ユニットの防御力を取得する.
	 * @return 防御力
	 */
	public int getDef() {
		return def;
	}
	
	/**
	 * ユニットのコマンドクラスを取得する.
	 * @return　コマンドクラス
	 */
	public Command getCommand() {
		return command;
	}
	
	
	
	/**
	 * ユニットのビルダーを生成する.
	 * @return ユニット・ビルダー
	 */
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
		private int spd;
		private int luck;
		
		private List<Action> skill;
		
		private Builder() {
			skill = new ArrayList<>();
			skill.add(ActionFactory.singleAttack());
		}
		
		/**
		 * ユニットの職業を指定する.
		 * @param job 職業
		 * @return this
		 */
		public Builder job(String job) {
			this.job = job;
			return this;
		}
		
		/**
		 * ユニットの名前を指定する.
		 * @param name 名前
		 * @return this
		 */
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		/**
		 * ユニットのHPを指定する.
		 * @param hp HP
		 * @return this
		 */
		public Builder hp(int hp) {
			this.hp = hp;
			return this;
		}
		
		/**
		 * ユニットのMPを指定する.
		 * @param mp MP
		 * @return this
		 */
		public Builder mp(int mp) {
			this.mp = mp;
			return this;
		}
		
		/**
		 * ユニットの攻撃力を指定する.
		 * @param atk 攻撃力
		 * @return this
		 */
		public Builder atk(int atk) {
			this.atk = atk;
			return this;
		}
		
		/**
		 * ユニットの防御力を指定する.
		 * @param def 防御力
		 * @return this
		 */
		public Builder def(int def) {
			this.def = def;
			return this;
		}
		
		/**
		 * ユニットの速度を指定する.
		 * 命中、回避に影響する.
		 * @param spd 速度
		 * @return this
		 */
		public Builder spd(int spd) {
			this.spd = spd;
			return this;
		}
		
		/**
		 * ユニットの運を指定する.
		 * 命中、回避、会心に影響する.
		 * @param luck 運
		 * @return this
		 */
		public Builder luck(int luck) {
			this.luck = luck;
			return this;
		}
		
		/**
		 * ユニットのアクションを指定する.
		 * @param action アクション(内部はリスト)
		 * @return this
		 */
		public Builder action(Action action) {
			skill.add(action);
			return this;
		}
		
	}
}
