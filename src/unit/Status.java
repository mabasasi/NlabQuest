package unit;

/**
 * ステータス管理クラス.
 * といっても、フラグの管理クラス.
 * @author shunichi
 */
public class Status {
	
	private int twiceDamage;
	private int doubleAttack;
	
	
	public Status() {
		twiceDamage = 0;
	}
	
	
	public String getStatusString() {
		StringBuilder sb = new StringBuilder();
		if (twiceDamage > 0) {
			sb.append(" 倍("+twiceDamage+")");
		}
		if (doubleAttack > 0) {
			sb.append(" 追("+doubleAttack+")");
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * ダメージ二倍フラグ.
	 * @param addNum 追加持続ターン数
	 */
	public void setTwiceDamage(int addNum) {
		twiceDamage = addNum;
	}
	
	/**
	 * ダメージ二倍フラグ.
	 * もしtrueなら、読み取った後ターンを減らす.
	 * @return　可否
	 */
	public boolean isTwiceDamage() {
		if (twiceDamage > 0) {
			twiceDamage --;
			return true;
		}
		return false;
	}
	
	
	/**
	 * 再行動フラグ.
	 * @param addNum 再行動ターン数
	 */
	public void setDoubleAttack(int addNum) {
		doubleAttack = addNum;
	}
	
	/**
	 * 再行動フラグ.
	 * もしtrueなら、読み取った後ターンを減らす.
	 * @return　可否
	 */
	public boolean isDoubleAttack() {
		if (doubleAttack > 0) {
			doubleAttack --;
			return true;
		}
		return false;
	}
	
	
}
