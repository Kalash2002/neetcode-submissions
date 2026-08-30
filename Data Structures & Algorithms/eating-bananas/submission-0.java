class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right = Arrays.stream(piles).max().getAsInt();

        int res=0;

        while(left<=right){
            int totalHour=0;
             int mid = left +(right-left)/2;

             for(int pile:piles){
                totalHour+= Math.ceil((double)pile/mid);
             }

             if(totalHour<=h){
                res=mid;
                right=mid-1;
             }else{
                left=mid+1;
             }
        }
        return res;
    }
}
