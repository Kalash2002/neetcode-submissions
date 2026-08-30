class Solution {

    public String encode(List<String> strs) {
        StringBuilder strB = new StringBuilder();

        for(String str:strs){
            strB.append(str.length())
                .append('#')
                .append(str);
        }

        return strB.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i=0;

        while(i<str.length()){
          int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(i,j));
            // skipping '#'
            j++;

            res.add(str.substring(j,j+len));

            i=j+len;
        }

        return res;
    }
}
