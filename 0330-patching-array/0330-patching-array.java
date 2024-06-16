class Solution {
    public int minPatches(int[] nums, int n) {
        if(nums.length<0)
            return 0;
        int patch=0,i=0;
        long missing=1;
        while(missing<=n){
            if((i<nums.length) && (missing>=nums[i])){
                missing+=nums[i];
                i++;
            }else{
                patch++;
                missing+=missing;
            }
        }
        return patch;
    }
}