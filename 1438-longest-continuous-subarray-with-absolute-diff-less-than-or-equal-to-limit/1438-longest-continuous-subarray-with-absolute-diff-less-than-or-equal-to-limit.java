class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        int ans=1,start=0,end=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        int max=0,min=0;
        while(end<n && start<=end){
            minHeap.add(nums[end]);
            maxHeap.add(nums[end]);
            max=maxHeap.peek();
            min=minHeap.peek();
            if(max-min<=limit){
                end++;
                ans=Math.max(ans,end-start);
            }else{
                minHeap.remove(nums[start]);
                maxHeap.remove(nums[start]);
                end++;
                start++;
                
            }
        }
        return ans;
    }
}