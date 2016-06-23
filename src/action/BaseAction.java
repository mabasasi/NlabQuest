package action;

import main.TargetUnit;

/**
 * 各スキルのベースクラス.
 * 内部にビルダーを実装してるんで、それ使って初期化する.
 * @author shunichi
 */
public class BaseAction {
	
	/**名前*/
	private final String name;
	/**表示名(ひらがな)*/
	private final String showName;
	/**説明*/
	private final String note;
	/**消費MP*/
	private final int useMp;
	/**ポイント(ダメージ、回復値)*/
	private final int point;
	
	/**ターゲット*/
	private final TargetUnit targetUnit;
	/**全体攻撃フラグ*/
	private final boolean isEntire;
	/**回復フラグ*/
	private final boolean isHeal;
	
	public BaseAction(Builder builder) {
        this.name = builder.name;
        this.showName = builder.showName;
        this.note = builder.note;
        this.useMp = builder.useMp;
        this.point = builder.point;
        this.targetUnit = builder.targetUnit;
        this.isEntire = builder.isEntire;
        this.isHeal = builder.isHeal;
    }
	
	public String getName() {
		return this.name;
	}
	
	public String getShowName() {
		return this.showName;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public int mp() {
		return this.useMp;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public TargetUnit getTargetUnit() {
		return this.targetUnit;
	}
	
	public boolean isEntire() {
		return this.isEntire;
	}
	
	public boolean isHeal() {
		return this.isHeal;
	}
	
	
	public static Builder builder() {
		return new Builder();
	}
	
	
	
	/**
	 * アクションのビルダークラス.
	 * @author morishige
	 */
	public static class Builder {
		private String name;
		private String showName;
		private String note;
		private int useMp;
		private int point;
		private TargetUnit targetUnit;
		private boolean isEntire;
		private boolean isHeal;
		
		private Builder() {}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder showName(String showName) {
			this.showName = showName;
			return this;
		}
		
		public Builder note(String note) {
			this.note = note;
			return this;
		}
		
		public Builder useMp(int useMp) {
			this.useMp = useMp;
			return this;
		}
		
		public Builder point(int point) {
			this.point = point;
			return this;
		}
		
		public Builder targetUnit(TargetUnit targetUnit) {
			this.targetUnit = targetUnit;
			return this;
		}
		
		public Builder isEntire(boolean isEntire) {
			this.isEntire = isEntire;
			return this;
		}
		
		public Builder isHeal(boolean isHeal) {
			this.isHeal = isHeal;
			return this;
		}
	}
}
