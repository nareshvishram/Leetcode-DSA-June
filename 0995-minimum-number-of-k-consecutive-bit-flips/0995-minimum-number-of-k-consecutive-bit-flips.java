class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int res=0,flipped=0,n=nums.length;
        int[] isFlipped=new int[n];
        for(int i=0;i<n;i++){
            if(i>=k)
                flipped^=isFlipped[i-k];
            
            if(flipped==nums[i]){
                if(i+k>n)
                    return -1;
                flipped^=1;
                isFlipped[i]=1;
                res++;
            }

            // if(nums[i]==0){
            //     int flipTo=i+k-1;
            //     if(flipTo<n){
            //         for(int j=i;j<=flipTo;j++){
            //             nums[j]=nums[j]^1;
            //         }
            //     }
            //     res++;
            // }
            
        }
        // for(int x:nums)
        //     if(x==0)
        //         return -1;
        //System.out.println(Arrays.toString(nums));
        return res;
    }
}