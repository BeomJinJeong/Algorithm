package com.ssafy.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q12886_돌그룹 {
    static Queue<Com> que = new LinkedList<Com>();
    static boolean [][] visited = new boolean[1501][1501];
    public static class Com{
        int a,b,c;
        public Com(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if((a+b+c)%3 !=0) {
            System.out.println("0");
            return;
        }

        Com com = new Com(a,b,c);
        que.add(com);
        visited[a][b] = true;
        while(!que.isEmpty()) {
            Com node = que.poll();
            if(node.a == node.b && node.b == node.c) {
                System.out.println(1);
                return;
            }
            //a랑 b비교
            if(node.a != node.b) {
                if(node.a<node.b) {
                    if(!visited[node.a+node.a][node.b-node.a]) {
                        que.add(new Com(node.a+node.a,node.b-node.a,node.c));
                        visited[node.a+node.a][node.b-node.a] = true;
                    }
                }else if(node.a>node.b) {
                    if(!visited[node.a-node.b][node.b+node.b]) {
                        que.add(new Com(node.a-node.b,node.b+node.b,node.c));
                        visited[node.a-node.b][node.b+node.b] = true;
                    }
                }
            }
            //a랑 C비교
            if(node.a != node.c) {
                if(node.a<node.c) {
                    if(!visited[node.a+node.a][node.c-node.a]) {
                        que.add(new Com(node.a+node.a,node.b,node.c-node.a));
                        visited[node.a+node.a][node.c-node.a]=true;
                    }
                }else if(node.a>node.c) {
                    if(!visited[node.a-node.c][node.c+node.c]) {
                        que.add(new Com(node.a-node.c,node.b,node.c+node.c));
                        visited[node.a-node.c][node.c+node.c]=true;
                    }
                }
            }
            //b랑 c비교
            if(node.b != node.c) {
                if(node.b<node.c) {
                    if(!visited[node.b+node.b][node.c-node.b]) {
                        que.add(new Com(node.a,node.b+node.b,node.c-node.b));
                        visited[node.b+node.b][node.c-node.b]=true;
                    }
                }else if(node.b>node.c) {
                    if(!visited[node.b-node.c][node.c+node.c]) {
                        que.add(new Com(node.a,node.b-node.c,node.c+node.c));
                        visited[node.b-node.c][node.c+node.c]=true;
                    }
                }

            }
        }
        System.out.println(0);
    }
}