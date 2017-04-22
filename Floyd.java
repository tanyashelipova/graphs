import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import static java.lang.Integer.min;

public class Floyd {

    public static void main(String[] args) {

        //считывание 
        Scanner sc = new Scanner(new File("input.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        int n = Integer.valueOf(lines.get(0));
        int[][] graph = new int[n + 1][n + 1];
        int[][] graphAns = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            String[] temp = lines.get(i).split(" ");
            for (int j = 1; j < n + 1; j++) {
                graph[i - 1][j - 1] = Integer.valueOf(temp[j - 1]);
            }
        }

        int i, j;
        int k;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                for (k = 0; k < n; k++) {
                    graph[j][k] = min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.print("\n");
        }

    }
}
