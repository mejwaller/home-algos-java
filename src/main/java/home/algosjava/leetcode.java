package home.algosjava;

class leetcode {
    
    static public int hammingWeight(int n) {
        
        int retval = 0;
        while(n > 0) {
            retval+=n&1;
            n=n>>>1;
        }
        
        return retval;
    }
    
}