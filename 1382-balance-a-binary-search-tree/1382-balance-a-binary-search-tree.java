/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //TreeNode root;
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> v=new ArrayList<>();
        fillVector(root,v);
        return buildBalancedBST(v,0,v.size()-1);
    }
    TreeNode buildBalancedBST(List<Integer> v,int l,int r){
        if(l>r)
            return null;
        
        int mid=l+(r-l)/2;
        //if(root==null)
        TreeNode root=new TreeNode(v.get(mid));
        root.left=buildBalancedBST(v,l,mid-1);
        root.right=buildBalancedBST(v,mid+1,r);
        return root;
    }
    void fillVector(TreeNode root,List<Integer> v){
        if(root==null)
            return;
        fillVector(root.left,v);
        v.add(root.val);
        fillVector(root.right,v);
    }
}