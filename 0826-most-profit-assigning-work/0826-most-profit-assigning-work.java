class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=difficulty.length,m=worker.length;
        int prefixMax[]=new int[n];
        int totalProfit=0;

        Data newData[]=new Data[n];

        int max=Integer.MIN_VALUE;
        
        
        for(int i=0;i<n;i++)
            newData[i]=new Data(difficulty[i],profit[i]);

        
        Arrays.sort(newData, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.getD()==o2.getD()?o2.getP()-o1.getP():o1.getD()-o2.getD();
            }
        });
        
        for(int i=0;i<n;i++) {
            max = Math.max(max, newData[i].getP());
            prefixMax[i]=max;
        }

        

        //System.out.println(Arrays.toString(newData));

        for(int i=0;i<m;i++){
            int idx=getIndex(newData,worker[i]);
            totalProfit+= idx==-1?0:prefixMax[idx];
        }

        //System.out.println(Arrays.toString(prefixMax));

        return totalProfit;

    }

    private int getIndex(Data[] difficulty, int i) {
        int l=0,r=difficulty.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(difficulty[mid].getD()==i)
                    return mid;
            else if(difficulty[mid].getD()<i)
                l=mid+1;
            else
                r=mid-1;
        }
        return r;
    }

    class Data {
        int d;
        int p;

        public Data(int d, int p) {
            this.d = d;
            this.p = p;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "d=" + d +
                    ", p=" + p +
                    '}';
        }

        public int getD() {
            return d;
        }

        public int getP() {
            return p;
        }
    }
}