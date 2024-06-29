class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<>());
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        for(int i=0;i<n;i++){
            dfs(i,i,graph,ans);
        }

        return ans;
    }

    private void dfs(int src, int curr, Map<Integer, List<Integer>> graph, List<List<Integer>> ans) {
        for(int child:graph.get(curr)){
            if(ans.get(child).size()==0 || ans.get(child).get(ans.get(child).size()-1)!=src){
                ans.get(child).add(src);
                dfs(src,child,graph,ans);
            }
        }
    }
}