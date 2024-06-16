class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int map1[]=new int[26];
        int map2[]=new int[26];
        for(char c:ransomNote.toCharArray())
            map1[c-'a']++;
        
        for(char c:magazine.toCharArray())
            map2[c-'a']++;

        for(int i=0;i<26;i++){
            if(map1[i]!=0 && map1[i]-map2[i]>0)
                return false;
        }
        return true;
        
    }
}