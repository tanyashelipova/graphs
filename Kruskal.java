import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kruskal{

    public static int min(int [][] graph, int m) {
        int min = 9999;
        int mini = -1;
        for (int i = 0; i < m; i++){
            if (graph[i][2] <= min & graph[i][3] == 0) {
                min = graph[i][2];
                mini = i;
            }
        }
        return mini;
    }

    public static void main(String[] args) throws IOException {

        //считывание
        Scanner sc = new Scanner(new File("input.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] tmp = lines.get(0).split(" ");
        int n = Integer.valueOf(tmp[0]);
        int m = Integer.valueOf(tmp[1]);

        int[][] graph = new int[m][4];
        for (int i = 1; i < m + 1; i++) {
            String[] temp = lines.get(i).split(" ");
            graph[i - 1][0] = Integer.valueOf(temp[0]) - 1;
            graph[i - 1][1] = Integer.valueOf(temp[1]) - 1;
            graph[i - 1][2] = Integer.valueOf(temp[2]);
            graph[i - 1][3] = 0;
        }

        int[][] graphSorted = new int[m][3];
        for (int i = 0; i < m; i++) {
            int mini = min(graph, m);
            graph[mini][3] = 1;
            if (mini != -1) {
                graphSorted[i][0] = graph[mini][0];
                graphSorted[i][1] = graph[mini][1];
                graphSorted[i][2] = graph[mini][2];
            }
        }

        int[] color = new int[n];
        for (int i = 0; i < n; i++){
            color[i] = i;
        }

        int ein = 0;
        int num = 0;
        int w = 0;
        while(ein < n - 1) {
            int colorA = color[graphSorted[num][0]];
            int colorB = color[graphSorted[num][1]];
            if (colorA == colorB) {
                num++;
            }
            if (!(colorA == colorB)) {
                for (int i = 0; i < n; i++){
                    if (color[i] == colorB){
                        color[i] = colorA;
                    }
                }
                w = w + graphSorted[num][2];
                num++;
                ein++;
            }
        }
        System.out.println(w);
    }
}
