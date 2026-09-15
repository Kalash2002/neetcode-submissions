class Solution {
    
    // public int[] topKFrequent(int[] nums, int k) {

    //     //O(nlogk)

    //     Map<Integer,Integer> map = new HashMap<>();

    //     for(int num:nums){
    //         freq.put(num,freq.getOrDefault(num,0)+1);
    //     }

    //     PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> a.getvalue()-b.getValue());

    //     for(Map.Entry<Integer,Integer> entry:freq.entrySet()){
    //         pq.offer(entry);
    //         if(pq.size()>k){
    //             pq.poll();
    //         }
    //     }

    //     int[] ans = new int[k];
    //     int index=0;
    //     while(!pq.isEmpty()){
    //         ans[index++]=pq.poll().getKey();
    //     }

    //     return ans;
    // Time: O(nlogk)
    // Space: O(n)
    // }


     public int[] topKFrequent(int[] nums, int k) {
// Since the maximum frequency of any element is n, create buckets where the index represents the frequency.

     Map<Integer,Integer> map = new HashMap<>();
     for(int num:nums){
        map.put(num,map.getOrDefault(num,0)+1);
     }

     PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());

     for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        pq.offer(entry);
        if(pq.size()>k){
            pq.poll();
        }
     }

     int[] ans = new int[k];
     int index=0;
     while(!pq.isEmpty()){
        ans[index++]=pq.poll().getKey();
     }

     return ans;
     //Time:O(nlogk)
     //space: O(n);


    }

}
