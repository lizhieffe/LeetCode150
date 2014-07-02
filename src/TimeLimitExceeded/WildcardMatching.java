package TimeLimitExceeded;

/*
 * the algorithm should be correct http://fisherlei.blogspot.com/2013/01/leetcode-wildcard-matching.html
 * don't know why it still etl 
 */

public class WildcardMatching {

	char[] s;
	char[] p;

	int[][] dp;

	public boolean isMatch(String s, String p) {
		if (s == null && p == null)
			return true;

		if (s == null || p == null)
			return false;

		this.s = s.toCharArray();
		this.p = p.toCharArray();

		dp = new int[this.s.length][this.p.length];
		for (int i = 0; i < this.s.length; i ++)
			for (int j = 0; j < this.p.length; j ++)
				dp[i][j] = -1;

		return isMatch(0, 0);
	}

	private boolean isMatch(int i, int j) {
		if (i >= s.length && j >= p.length)
			return true;

		if (j >= p.length)
			return false;

		if (i >= s.length) {
			if (p[j] == '*')
				return isMatch(i, j + 1);
			else
				return false;
		}

		if (dp[i][j] != -1)
			return dp[i][j] == 0 ? false : true;

		boolean result = false;
		int tmp1 = i;
		int tmp2 = j;
		if (p[tmp2] != '*' && p[tmp2] != '.') {
			while (tmp1 < s.length && tmp2 < p.length && p[tmp2] != '.' && p[tmp2] != '*') {
				if (s[tmp1] == p[tmp2]) {
					tmp1 ++;
					tmp2 ++;
				}
				else {
					result = false;
					break;
				}
			}
			if (tmp1 < s.length && tmp2 < p.length && p[tmp2] != '.' && p[tmp2] != '*');
			else
				result = isMatch(tmp1, tmp2);

		} else if (p[j] == '.')
			result = isMatch(i + 1, j + 1);
		else {
			for (int k = 0; k < s.length - i; k ++) {
				result = isMatch(i + k, j + 1) || result;
				if (result == true)
					break;
			}
		}

		dp[i][j] = result == true ? 1 : 0;
		return result;
	}
	
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String p = "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*";
		
		System.out.println(new WildcardMatching().isMatch(s, p));
	}
}
