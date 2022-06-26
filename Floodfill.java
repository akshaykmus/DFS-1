// T : O(mxn)
// S : O(mxn)

class Solution {
    public int[][] dirs;
    int oldColor;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image[sr][sc] == color)
            return image;
        dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        oldColor = image[sr][sc];
        int m = image.length;
        int n = image[0].length;

        dfs(image, sr, sc, color, m, n);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int m, int n) {
        if (sr < 0 || sc < 0 || sr == m || sc == n || image[sr][sc] != oldColor)
            return;
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            // image[nr][nc] = color;
            dfs(image, nr, nc, color, m, n);
        }

    }
}