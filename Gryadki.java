import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
public class Gryadki {

    public static void main(String[] args) {

        //считывание
        Scanner sc = new Scanner(new File("input.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        String[] tmp = lines.get(0).split(" ");
        int n = Integer.valueOf(tmp[0]);
        int m = Integer.valueOf(tmp[1]);
        String[][] graph = new String[n][m];
        for (int i = 1; i < n + 1; i++) {
            String[] temp = lines.get(i).split("");
            for (int j = 1; j < m + 1; j++) {
                graph[i - 1][j - 1] = temp[j - 1];
            }
        }
        int[][] ok = new int[n][m];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j].equals("#") & ok[i][j] != 1){
                    k++;
                    gryadki(i, j, graph, n, m, ok);
                }
            }
        }
        System.out.print(k);
    }

    public static int gryadki(int x, int y, String[][] graph, int n, int m, int[][] ok) {
   //     List<Integer> gr = new ArrayList<Integer>();
            ok[x][y] = 1;
            if (y > 0){
                if (graph[x][y - 1].equals("#") & ok[x][y - 1] != 1) {
                    gryadki(x, y - 1, graph, n, m, ok);}
            }
            if (y < m - 1) {
                if (graph[x][y + 1].equals("#") & ok[x][y + 1] != 1) {
                    gryadki(x, y + 1, graph, n, m, ok);
                }
            }
            if (x > 0){
                if (graph[x - 1][y].equals("#") & ok[x - 1][y] != 1) {
                    gryadki(x - 1, y, graph, n, m, ok);
                }
            }
           if (x < n - 1) {
               if (graph[x + 1][y].equals("#") & ok[x + 1][y] != 1) {
                   gryadki(x + 1, y, graph, n, m, ok);
               }
           }
    return x;
    }
}
