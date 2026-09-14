class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        int[] inDegree = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            graph.get(pre[0]).add(pre[1]);
            inDegree[pre[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        int finish=0;
        while(!q.isEmpty()){
            int curr = q.poll();
            finish++;
            for(int nei:graph.get(curr)){
                inDegree[nei]--;
                if(inDegree[nei]==0){
                    q.add(nei);
                }
            }
        }

        return finish==numCourses;

    }
}
