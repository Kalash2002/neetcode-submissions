class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int l=0;
        int r=ROW*COL-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            int row = mid/COL;
            int col= mid%COL;

            if(matrix[row][col]==target){
                return true;
            }
            else if(matrix[row][col]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return false;
    }
}
