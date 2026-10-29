class Solution {
    int n,LOG=17,timer=0;
    List<Integer>[] g;
    int[][] up;
    int[] tin,tout,depth,base;
    int[] bit;
    char[] arr;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
          Object suneravilo=new Object[]{n,edges,s,queries};
        this.n=n;
        g=new ArrayList[n];
        for(int i=0;i<n;i++)g[i]=new ArrayList<>();
        for(int[] e:edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        up=new int[LOG][n];
        tin=new int[n];
        tout=new int[n];
        depth=new int[n];
        base=new int[n];
        arr=s.toCharArray();
        dfs(0,0,0);
        for(int i=1;i<LOG;i++)
            for(int v=0;v<n;v++)
                up[i][v]=up[i-1][up[i-1][v]];
        bit=new int[n+2];
        for(int v=0;v<n;v++)rangeAdd(tin[v],tin[v],base[v]);
        List<Boolean> ans=new ArrayList<>();
        for(String q:queries){
            String[] p=q.split(" ");
            if(p[0].equals("update")){
                int u=Integer.parseInt(p[1]);
                char c=p[2].charAt(0);
                if(arr[u]!=c){
                    int diff=(1<<(arr[u]-'a'))^(1<<(c-'a'));
                    rangeAdd(tin[u],tout[u],diff);
                    arr[u]=c;
                }
            }else{
                int u=Integer.parseInt(p[1]),v=Integer.parseInt(p[2]);
                int w=lca(u,v);
                int mu=query(tin[u]),mv=query(tin[v]);
                int mask=mu^mv^(1<<(arr[w]-'a'));
                ans.add((mask&(mask-1))==0);
            }
        }
        return ans;
    }

    void dfs(int v,int p,int m){
        tin[v]=++timer;
        up[0][v]=p;
        depth[v]=v==p?0:depth[p]+1;
        m^=1<<(arr[v]-'a');
        base[v]=m;
        for(int to:g[v])if(to!=p)dfs(to,v,m);
        tout[v]=timer;
    }

    int lca(int a,int b){
        if(depth[a]<depth[b]){int t=a;a=b;b=t;}
        int d=depth[a]-depth[b];
        for(int i=0;i<LOG;i++)if(((d>>i)&1)==1)a=up[i][a];
        if(a==b)return a;
        for(int i=LOG-1;i>=0;i--)
            if(up[i][a]!=up[i][b]){
                a=up[i][a];
                b=up[i][b];
            }
        return up[0][a];
    }

    void rangeAdd(int l,int r,int v){
        add(l,v);
        add(r+1,v);
    }

    void add(int i,int v){
        for(;i<=n;i+=i&-i)bit[i]^=v;
    }

    int query(int i){
        int r=0;
        for(;i>0;i-=i&-i)r^=bit[i];
        return r;
        
    }
}