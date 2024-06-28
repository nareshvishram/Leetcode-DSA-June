
class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int arr[]=new int[n];
        List<Data> l=new ArrayList<>();
        for(int x[]:roads){
            arr[x[0]]++;
            arr[x[1]]++;
        }
        for(int i=0;i<arr.length;i++){
            l.add(new Data(i,arr[i],0));
        }
        Map<Integer,Data> map=new TreeMap<>();
        Collections.sort(l, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.deg==o2.deg?o1.v-o2.v:o1.deg-o2.deg;
            }
        });
        System.out.println(l);
        for(int i=l.size()-1;i>=0;i--){
            Data d=l.get(i);
            d.imp=i+1;
            l.set(i,d);
            map.put(d.v,d);
        }
        System.out.println(map);
        long total=0;
        for(int x[]:roads){
            System.out.println(l.get(x[0]).imp+" "+l.get(x[1]).imp);
            total+=map.get(x[0]).imp+map.get(x[1]).imp;

        }
        return total;
    }
}
class Data{
    int v;
    int deg;
    int imp;

    public Data(int v, int deg,int imp) {
        this.v = v;
        this.deg = deg;
        this.imp=imp;
    }

    @Override
    public String toString() {
        return "Data{" +
                "v=" + v +
                ", deg=" + deg +
                ", imp=" + imp +
                '}';
    }
}