package Leetcode.DFS.Medium;

/**
 * Union find, YouTube solution: https://www.youtube.com/watch?v=n3s9Q7GtfB4
 *
 */
public class Regions_Cut_By_Slashes_959 {

    private int regions;
    private int[] triangleRoot;

    public int regionsBySlashes(String[] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        regions = n * n * 4;
        triangleRoot = new int[n * n * 4];
        for (int i = 0; i < triangleRoot.length; i++) {
            triangleRoot[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // Go into each cell to union triangles according to '\', '/' or ' '
                switch (grid[i].charAt(j)) {
                    case '/': // Union top-left and right-bottom
                        union((i*n + j)*4, (i*n + j)*4 + 3);
                        union((i*n + j)*4 + 1, (i*n + j)*4 + 2);
                        break;
                    case '\\': // Union top-right and bottom-left
                        union((i*n + j)*4, (i*n + j)*4 + 1);
                        union((i*n + j)*4 + 2, (i*n + j)*4 + 3);
                        break;
                    case ' ': // Union top-right-bottom-left
                        union((i*n + j)*4, (i*n + j)*4 + 1);
                        union((i*n + j)*4 + 1, (i*n + j)*4 + 2);
                        union((i*n + j)*4 + 2, (i*n + j)*4 + 3);
                        break;
                }

                // Union two triangles between two adjacent cells
                if (i > 0) union(((i-1)*n + j)*4 + 2, (i*n + j)*4);
                if (j > 0) union((i*n + (j-1))*4 + 1, (i*n + j)*4 + 3);
            }
        }

        return regions;
    }

    private void union(int triangle1, int triangle2) {
        int rootOf1 = findRoot(triangle1);
        int rootOf2 = findRoot(triangle2);

        if (rootOf1 != rootOf2) {
            triangleRoot[rootOf1] = rootOf2;
            regions--;
        }
    }

    private int findRoot(int root) {
        while (triangleRoot[root] != root) {
            root = triangleRoot[root];
        }
        return root;
    }
}
