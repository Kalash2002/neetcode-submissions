class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] inDegree = new int[numCourses];
        int[] res = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int finish=0;
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            res[finish]=curr;
            finish++;
            for(int nei:graph.get(curr)){
                inDegree[nei]--;
                if(inDegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        return finish==numCourses?res:new int[]{};
    }
}
