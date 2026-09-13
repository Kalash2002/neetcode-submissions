class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));

        for(int stone:stones){
            pq.offer(stone);
        }

        while(pq.size()>1){
            int stone1=pq.poll();
            int stone2=pq.poll();
            
            int leftStone = Math.abs(stone1-stone2);
            if(leftStone!=0){
                pq.offer(leftStone);
            }
        }

        pq.offer(0);
        return pq.peek();


    }
}
