// Submission link: https://leetcode.com/problems/image-smoother/submissions/1493574161/

public class Image_Smoother {
    public static void main(String[] args) {
        int[][] img = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result = imageSmoother(img);
        System.out.println(result);
    }

    public static int[][] imageSmoother(int[][] img) {
        int n = img.length;
        int m = img[0].length;
        int[][] result = new int[n][m];
        int[][] direction = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                int sum = 0;
                int count = 1;
                sum += img[i][j];

                for(int[] dir : direction) {
                    int x_dir = i + dir[0];
                    int y_dir = j + dir[1];

                    if(x_dir >= 0 && x_dir < n && y_dir >= 0 && y_dir < m) {
                        count++;
                        sum += img[x_dir][y_dir];
                    }
                }

                result[i][j] = (sum / count);
            }
        }

        return result;
    }
}
