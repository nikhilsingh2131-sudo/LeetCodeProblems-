class Solution {
    public int repeatedStringMatch(String a, String b) {

        int count = 0;
        String s = "";

      while(s.length()<b.length()){
        s+=a;
        count++;
      }
      if(s.contains(b)){
        return count;
      }

      s+=a;
      count++;

       if(s.contains(b)){
        return count;
      }

      return -1;
    }
}