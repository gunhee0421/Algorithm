import java.util.*;
class Solution {
    class Node{
        public int x,y,step;
        
        public Node(int x, int y, int step){
            this.x=x;
            this.y=y;
            this.step=step;
        }
        public boolean equals(Node other){
            return this.x==other.x && this.y==other.y;
        }
    }
    public int solution(int[][] maps) {        
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited=new boolean[maps.length][maps[0].length];
        
        q.offer(new Node(0, 0 ,1));
        
        while(!q.isEmpty()){
            Node target = new Node(maps.length-1, maps[0].length-1, 0);
            
            Node cur = q.poll();
            
            if(cur.x<0 || cur.x>maps.length-1) continue;
            if(cur.y<0 || cur.y>maps[0].length-1) continue;
            if(maps[cur.x][cur.y]==0) continue;
            if(visited[cur.x][cur.y]) continue;
            if(cur.equals(target)) return cur.step;
            
            visited[cur.x][cur.y]=true;
            
            q.offer(new Node(cur.x, cur.y+1, cur.step+1));
            q.offer(new Node(cur.x, cur.y-1, cur.step+1));
            q.offer(new Node(cur.x+1, cur.y, cur.step+1));
            q.offer(new Node(cur.x-1, cur.y, cur.step+1));
            
        }
        
        return -1;
    }
}