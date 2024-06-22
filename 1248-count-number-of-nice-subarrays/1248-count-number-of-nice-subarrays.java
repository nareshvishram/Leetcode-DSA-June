class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
     int i=0,j=0,count=0,odd=0,total=0;
     for(i=0;i<nums.length;i++){
        if((nums[i]%2)!=0){
            odd++;
        
            if(odd>=k){
                count=1;
                while(j<nums.length && (nums[j++]%2==0)){
                    count++;
                }
                total+=count;
            }
        }
        else if(odd>=k)
            total+=count;
     }  
     return total;
    }
}