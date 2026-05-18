class Solution {
    public String multiply(String num1, String num2) {
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        String a = s1.reverse().toString();
        String b = s2.reverse().toString();
        char[] n = a.toCharArray();
        char[] m = b.toCharArray();
        int[] r = new int[n.length + m.length];
        for(int i=0;i<num1.length();i++)
        {
            for(int j=0;j<num2.length();j++)
            {
                int d = ((int)n[i] - '0') * ((int)m[j] - '0') + r[i + j];
                r[i + j] = d%10;
                r[i + j + 1] += d/10;
            }
        }
        StringBuilder sb = new StringBuilder();

        int i = r.length - 1;

        while(i > 0 && r[i] == 0)
        i--;

        while(i >= 0) 
        {
            sb.append(r[i]);
            i--;
        }
        return sb.toString();
    }
}