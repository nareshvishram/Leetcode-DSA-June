class Solution {
    public int findCenter(int[][] edges) {
        int v=edges.length;
        int indeg[]=new int[v+2];
        for(int arr[]:edges){
            indeg[arr[0]]++;
            indeg[arr[1]]++;
        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i]==v)
                return i;
        }
        //System.out.println(Arrays.toString(indeg));
        return -1;
    }
}