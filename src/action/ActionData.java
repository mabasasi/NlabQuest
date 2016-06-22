
package action;

import main.TargetUnit;

/**
 * アクションのデータクラス.
 * 内部にビルダーを実装してるんで、それ使って初期化する.
 * @author morishige
 */
public class ActionData {
	
	/**名前*/
	private final String name;
	/**表示名(ひらがな)*/
	private final String showName;
	/**説明*/
	private final String explanation;
	/**消費MP*/
	private final int useMp;
	/**ポイント(ダメージ、回復値)*/
	private final int point;
	
	/**ターゲット*/
	private final TargetUnit targetUnit;
	/**全体攻撃フラグ*/
	private final boolean isEntireAction;
	
	public ActionData(Builder builder) {
        this.name = builder.name;
        this.showName = builder.showName;
        this.explanation = builder.explanation;
        this.useMp = builder.useMp;
        this.point = builder.point;
        this.targetUnit = builder.targetUnit;
        this.isEntireAction = builder.isEntireAction;
    }
	
	public String getName() {
		return this.name;
	}
	
	public String getShowName() {
		return this.showName;
	}
	
	public String getExplanation() {
		return this.explanation;
	}
	
	public int useMp() {
		return this.useMp;
	}
	
	public int getPoint() {
		return this.point;
	}
	
	public TargetUnit getTargetUnit() {
		return this.targetUnit;
	}
	
	public boolean isEntireAction() {
		return this.isEntireAction;
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
		private String explanation;
		private int useMp;
		private int point;
		private TargetUnit targetUnit;
		private boolean isEntireAction;
		
		private Builder() {}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder showName(String showName) {
			this.showName = showName;
			return this;
		}
		
		public Builder explanation(String explanation) {
			this.explanation = explanation;
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
		
		public Builder isEntireAction(boolean isEntireAction) {
			this.isEntireAction = isEntireAction;
			return this;
		}
	}
}
