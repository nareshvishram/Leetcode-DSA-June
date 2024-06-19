class Solution {
    public int minDays(int[] arr, int m, int k) {
        if(arr.length<m*k)
            return -1;
        int l=Arrays.stream(arr).min().getAsInt();
        int r= Arrays.stream(arr).max().getAsInt();
        System.out.println(l+" "+r);
        while(l<=r){
            int mid=l+(r-l)/2;
            // System.out.println("mid "+mid);
            int possibleBq=getPossibleBq(arr,mid,m,k);
            if(possibleBq>=m)
                r=mid-1;
            else
                l=mid+1;
        }
        return l==Arrays.stream(arr).max().getAsInt()+1?-1:l;
    }
    int getPossibleBq(int arr[],int day,int m,int k){
        int cnt=0,bq=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day)
                cnt++;
            else
                cnt=0;
            // System.out.println("cnt "+cnt);
            if(cnt==k) {
                bq++;
                cnt=0;
            }


        }
        // System.out.println("bq "+bq);
        return bq;
    }
}