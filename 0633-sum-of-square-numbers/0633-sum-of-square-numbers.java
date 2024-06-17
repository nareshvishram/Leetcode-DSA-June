class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set=new HashSet<>();
        for(int b=0;b<=Math.sqrt(c);b++){
            set.add(b*b);
            if(set.contains(c-b*b))
                return true;
        }
        System.out.println(set);
        return false;
    }
}