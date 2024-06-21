class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;
        int totalCustomers=0,grumpyCustomers=0,maxSave=0,windowCustomers=0;
        for(int i=0;i<n;i++){
            totalCustomers+=customers[i];
            grumpyCustomers+=customers[i]*grumpy[i];
            windowCustomers+=customers[i]*grumpy[i];
            if(i>minutes-1){
                // when the window has reached to its limit.
                // just remove the start if its grumpy otherwise don't
                windowCustomers-=customers[i-minutes]*grumpy[i-minutes];
            }
            maxSave=Math.max(maxSave,windowCustomers);
        }
        return totalCustomers-grumpyCustomers+maxSave;
    }
}