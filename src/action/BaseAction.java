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
	private final int mp;
	/**ポイント(ダメージ、回復値)*/
	private final int point;
	
	/**ターゲット*/
	private final TargetUnit targetUnit;
	/**全体攻撃フラグ*/
	private final boolean isEntire;
	/**回復フラグ*/
	private final boolean isHeal;
	/**追加攻撃フラグ*/
	private final boolean isReact;

	public BaseAction(Builder builder) {
        this.name = builder.name;
        this.showName = builder.showName;
        this.note = builder.note;
        this.mp = builder.mp;
        this.point = builder.point;
        this.targetUnit = builder.targetUnit;
        this.isEntire = builder.isEntire;
        this.isHeal = builder.isHeal;
        this.isReact = builder.isReact;
    }
	
	/**
	 * アクションの名前を取得する.
	 * @return 名前
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * アクションの表示名を取得する.
	 * @return 表示名
	 */
	public String getShowName() {
		return this.showName;
	}
	
	/**
	 * アクションの説明文を取得する.
	 * @return 説明文
	 */
	public String getNote() {
		return this.note;
	}
	
	/**
	 * アクションの使用MPを取得する.
	 * @return 使用MP
	 */
	public int getMp() {
		return this.mp;
	}
	
	/**
	 * アクションのポイント(ダメージ、回復値等)を取得する.
	 * @return　ポイント
	 */
	public int getPoint() {
		return this.point;
	}
	
	/**
	 * アクションの全体攻撃フラグを取得する.
	 * @return trueで全体アクション
	 */
	public TargetUnit getTargetUnit() {
		return this.targetUnit;
	}
	
	/**
	 * アクションの全体攻撃フラグを取得する.
	 * @return trueで全体アクション
	 */
	public boolean isEntire() {
		return this.isEntire;
	}
	
	/**
	 * アクションの回復フラグを取得する.
	 * @return trueで回復アクション
	 */
	public boolean isHeal() {
		return this.isHeal;
	}
	
	/**
	 * アクションの追加攻撃フラグを取得する.
	 * この攻撃をターンに含めない、ということ.
	 * @return trueで追加攻撃.
	 */
	public boolean isReact() {
		return this.isReact;
	}
	
	
	
	/**
	 * アクションのビルダーを生成する.
	 * @return アクション・ビルダー
	 */
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
		private int mp;
		private int point;
		private TargetUnit targetUnit;
		private boolean isEntire;
		private boolean isHeal;
		private boolean isReact;
		
		
		private Builder() {
			name = "";
			showName = "";
			note = "";
			mp = 0;
			point = 0;
			targetUnit = TargetUnit.none;
			isEntire = false;
			isHeal = false;
			isReact = false;
		}
		
		/**
		 * アクションの名前を指定する.
		 * @param name 名前
		 * @return this
		 */
		public Builder name(String name) {
			if (name == null || name.isEmpty())	new IllegalArgumentException("name は必須です.");
			
			this.name = name;
			return this;
		}
		
		/**
		 * アクションの表示名を指定する.
		 * @param showName 表示名
		 * @return this
		 */
		public Builder showName(String showName) {
			if (name == null || name.isEmpty())	new IllegalArgumentException("showName は必須です.");
			
			this.showName = showName;
			return this;
		}
		
		/**
		 * アクションの説明文を指定する.
		 * @param note 説明文
		 * @return this
		 */
		public Builder note(String note) {			
			this.note = note;
			return this;
		}
		
		/**
		 * アクションの使用MPを指定する.
		 * @param mp 使用MP({@code>=} 0)
		 * @return this
		 */
		public Builder mp(int mp) {
			if (mp < 0)	new IllegalArgumentException("mpは正の値を取ります.");
			
			this.mp = mp;
			return this;
		}
		
		/**
		 * アクションのポイント(ダメージ、回復値等)を指定する.
		 * @param point ポイント
		 * @return this
		 */
		public Builder point(int point) {
			if (point < 0)	new IllegalArgumentException("pointは正の値を取ります.");
			
			this.point = point;
			return this;
		}
		
		/**
		 * アクションの対象を指定する.
		 * @param targetUnit 対象ユニット
		 * @return this
		 */
		public Builder targetUnit(TargetUnit targetUnit) {
			this.targetUnit = targetUnit;
			return this;
		}
		
		/**
		 * アクションの全体攻撃フラグを指定する.
		 * @param isEntire trueで全体アクション.
		 * @return this
		 */
		public Builder isEntire(boolean isEntire) {
			this.isEntire = isEntire;
			return this;
		}
		
		/**
		 * アクションの回復フラグを指定する.
		 * @param isHeal trueで回復アクション.
		 * @return this
		 */
		public Builder isHeal(boolean isHeal) {
			this.isHeal = isHeal;
			return this;
		}
		
		/**
		 * アクションの追加攻撃フラグを指定する.
		 * この攻撃をターンに含めない、ということ.
		 * @param isReact trueで追加攻撃.
		 * @return this
		 */
		public Builder isReact(boolean isReact) {
			this.isReact = isReact;
			return this;
		}
	}
}
