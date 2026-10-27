
class Solution {
    public String[] createGrid(int m, int n) {

        char[][] mat = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = '#';
            }
        }

        for (int j = 0; j < n; j++) {
            mat[0][j] = '.';
        }

        for (int i = 0; i < m; i++) {
            mat[i][n - 1] = '.';
        }

        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            ans[i] = new String(mat[i]);
        }

        return ans;
    }
}
