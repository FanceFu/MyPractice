package javavaluebookstring;

import javafx.util.Builder;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 对 1 2 2 3 4 5 求全排列 且3 与5不能相连， 4不能出现在第3个位置  ：可转换为图的遍历
 */
public class TestGraph {
    private int[] numbers=new int[]{1 ,2 ,2, 3 ,4 ,5};
    private int n=numbers.length;

    private boolean[] visited=new boolean[n];

    private int[][] graph=new int[n][n];

    private String combination="";

    private void buildGraph(){
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i!=j)
                    graph[i][j]=1;
            }
        }

        //使 3和 5 不连通
        graph[3][5]=0;
        graph[5][3]=0;

    }

    public Set<String> getAllCombinations(){
        //构造图
        buildGraph();
        Set<String> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            depthFirstSearch(i,set);
        }
        return set;
    }



    private void depthFirstSearch(int start,Set<String> set){
        visited[start]=true;
        combination=combination+numbers[start];
        if(combination.length()==n){
            if(combination.indexOf("4")!=2)
                set.add(combination);
        }

        for (int i = 0; i <n ; i++) {
            if(graph[start][i]==1&&visited[i]==false)
                depthFirstSearch(i,set);
        }

        combination=combination.substring(0,combination.length()-1);
        visited[start]=false;
    }


    public static void main(String[] args) {
        TestGraph t=new TestGraph();
        Set<String> set=t.getAllCombinations();
        Iterator<String> it=set.iterator();
        while (it.hasNext()){
            String str=it.next();
            System.out.println(str);
        }
    }
}
