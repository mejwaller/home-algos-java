class gcds
{
	
	private static int []subProcessSign = new int[1]; // unused.
		
	public static void Euclidgcd(int a[], int[] b, int gcd[])
	{
		//handle cases wher a or b are zero
		if(isZero(a))
		{
			assign(gcd, a);
			return;
		}
		if(isZero(b))
		{
			assign(gcd, b);
			return;
		}
		
		//unsure a and b a re not modified (??)
		a = copy(a);
		b = copy(b);
		
		while(!isZero(b))
		{
			//last argument to subtract represents sign of result which
			//we can ignore since we only subtract smaller from larger
			if(compareTo(a,b) > 0)
			{
				subtract(a,b,gcd, new int[1]);
				assign(a,gcd);				
			}
			else
			{
				subtract(b,a,gcd, new int[1]);
				assign(b,gcd);
			}
		}
		
		// value held in a is the computed gcd of original (a,b)
		assign(gcd,a);
		
	}
	
	public static void modgcd(int[] a, int[] b, int[] gcd)
	{
		//account for zero values
		if(isZero(a))
		{
			assign(gcd, a);
			return;
		}
		if(isZero(b))
		{
			assign(gcd,b);
			return;
		}
		
		//align a and b to have same number of digits and work on copies
		a = copy(normalize(a, b.length));
		b = copy(normalize(b, a.length));
		
		//ensure that a is greater than b. Also return trivial gcd
		int rc = compareTo(a,b);
		
		if(rc==0)
		{
			assign(gcd,a);
			return;
		}
		
		if(rc < 0)
		{
			int[] t = b;
			b = a;
			a = t;
		}
		
		int[] quot = new int[a.length];
		int[] remainder = new int[a.length];
		
		while(!isZero(b))
		{
			int[] t = copy(b);
			divide(a,b,quot, remainder);
			assign(b,remainder);
			assign(a,t);
		}
		
		//value held in a is the gcd of (a,b)
		assign(gcd,a);				
	}
	
	public static boolean isZero (int []n) 
	{
		for (int i = 0; i < n.length; i++) 
		{
			if (n[i] != 0) 
			{ 
				return false; 
			}
		}
		
		return true;
	}
	
	/**
	 * Assign n1 to be the same value as n2.
	 * 
	 * n1's length must be >= n2's length
	 * 
	 * @param n
	 * @param n2
	 */
	public static void assign (int []n1, int n2[])
	{
		int idx = n1.length-1;
		int i;
		for (i = n2.length-1; i >=0; i--) 
		{
			n1[idx--] = n2[i];
		}
		
		while (idx > 0) 
		{
			n1[idx--] = 0;
		}
	}
	
	public static int[] copy (int []n)
	{
		int []n2 = new int[n.length];
		
		extract(n2,0,n,0,n.length);
		
		return n2;
	}
	
	/**
	 * Extract len2 digits from n2 at off2 and copy into n1 at off1 
	 * 
	 * @param n
	 * @param n2
	 */
	public static void extract (int []n1, int off1, int n2[], int off2, int len2) 
	{
		for (int i = 0; i < len2; i++) 
		{
			n1[off1+i] = n2[off2+i];
		}
	}
	
	/**
	 * Return 0 if same, -1 if n1 is less than n2, and +1 is n1 > n2
	 * 
	 * If don't have same length, then take into account leading zeros.
	 * 
	 * @param n1
	 * @param n2
	 */
	public static int compareTo (int []n1, int[]n2) 
	{
		int off1 = 0;
		int off2 = 0;
		
		boolean z1 = isZero(n1);
		boolean z2 = isZero(n2);
		if (z1 && z2) 
		{ 
			return 0; 
		} //both zero.
		
		if (z1) 
		{ 
			return -1; 
		} // second number is not zero.
		
		if (z2) 
		{ 
			return +1; 
		} // first number is not zero.
		
		while (n1[off1] == 0)
		{ 
			off1++;
		} // compute leading zeros.
		
		while (n2[off2] == 0){
			off2++;
		}

		int sz1 = n1.length-off1;
		int sz2 = n2.length-off2;
		
		if (sz1 < sz2)
		{ 
			return -1;
		} // first number has less digits (after removing leading zeros)
		
		if (sz2 < sz1) 
		{ 
			return +1; 
		} // second number has less digits (after removing leading zeros)
		
		// same number of digits, compare 1-by-1		
		for (int i = 0; i < sz1; i++) 
		{
			if (n1[off1+i] == n2[off2+i]) 
			{ 
				continue;
			}
			
			// Must be able to report by now...
			if (n2[off2+i] > n1[off1+i]) 
			{
				return -1;
			} 
			else 
			{
				return +1;
			}
		}
		
		// must be the same!
		return 0;
	}

	/**
	 * Subtract n2 from n1 two integers accurately.
	 * 
	 * @param n1
	 * @param n2
	 * @param sum
	 */
	public static void subtract(int[] n1, int[] n2, int[] result, int[]sign) 
	{
		int b = n1.length-1;
		int carry = 0;
		
		boolean smaller = (compareTo(n2, n1) < 0);
//		// confirm that n2 is smaller than n1. If so, we reverse. Assume that
//		// n2 is smaller.
//		boolean smaller = true;
//		for (int i = 0; i < n1.length; i++) {
//			if (n2[i] == n1[i]) { 
//				continue;
//			}
//
//			// Must be able to report by now...
//			if (n2[i] > n1[i]) {
//				smaller = false;
//			}
//			break;
//		}
		
		while (b >= 0) {
			
			int s = n1[b] - n2[b];
			if (!smaller) 
			{ 
				s = -s; 
			}
			
			s += carry;
			
			if (s >= 0) 
			{
				result[b] = s;
				carry = 0;
			} 
			else 
			{
				carry = -1;
				result[b] = s + 10;
			}
			
			b--;
		}
		
		if (!smaller) 
		{
			sign[0] = -1;
		}
		else 
		{
			sign[0] = carry+0;
		}
	}
	
	/**
	 * Expand a to be at least as large as length.
	 * 
	 * @param a
	 * @param length
	 * @return
	 */
	public static int[] normalize(int[] a, int length)
	{
		if (a.length >= length) 
		{ 
			return a; 
		}
		
		while (a.length < length) 
		{
			a = expand(a);
		}
		
		return a;
	}
	
	/**
	 * Expand by one.
	 * 
	 * @param n
	 * @param n2
	 */
	public static int[] expand (int []n) 
	{
		int []n2 = new int[n.length+1];
		extract(n2,1,n,0,n.length);
		
		return n2;
	}
	
	/**
	 * Return n1/n2 as result and quotient.
	 * 
	 * Note that n1 and n2 are unaffected.
	 * 
	 * Work this as reducing problem into smaller problems, from which the result
	 * is generated.
	 * 
	 * Take 0074 divide into 6928
	 * 
	 * 1. 074 divide into 692    (9)
	 * 2. 074 divide into 268    (3)
	 * 3. 74  divide into 46     (+46) 
	 * 
	 * @param n1
	 * @param n2
	 * @param result
	 * @param quotient
	 */
	private static void divide(int[] n1, int[] n2, int[] quotient, int []remainder)
	{
		if (isZero(n2)) 
		{
			throw new ArithmeticException ("Divide by Zero");
		}
		
		clear(remainder);
		clear(quotient);
		
		// if clearly greater, then copy integer remainder
		if (compareTo(n2,n1) > 0) 
		{
			int idx = remainder.length-1;
			
			for (int i = 0; i < n1.length; i++ ) 
			{ 
				remainder[idx--] = n1[i];
			}
			
			return;
		}
		
		// This returns a copy of n1/n2
		n1 = reduce(n1);
		n2 = reduce(n2);

		// we have to extend, and reduce length. Note that this WILL terminate because
		// we would have left earlier if n2 were greater than n1.
		while (compareTo(n2,0,n2.length,n1,0) > 0) 
		{
			n2 = expand(n2);
		}
		
		// return string "quot+remainder";
		String result = subProcess(n1, n2);
		
		// pack into quotient/remainder.
		int idx = result.indexOf("+");
		if (idx == -1) 
		{
			for (int i = 0; i < quotient.length; i++) 
			{
				quotient[i] = 0;
			}
			pack(remainder,result);  // ever happen?
		} 
		else 
		{
			pack(quotient,result.substring(0,idx));
			pack(remainder,result.substring(idx+1));
		}
	}
	
	/**
	 * Set to zero.	
	 */
	public static void clear (int []n)
	{
		for (int i = 0; i < n.length; i++) 
		{
			n[i] = 0;
		}
	}
	
	/**
	 * Strip leading zeros to reduce.
	 * 
	 * Always returns a new copy of the value, never the input even when no zeros.	 
	 */
	public static int[] reduce (int []n1) 
	{
		for (int i = 0; i < n1.length; i++) 
		{
			if (n1[i] != 0) 
			{
				if (i == 0)
				{
					return copy(n1);
				}
				
				int []newVal = new int[n1.length-i];
				extract(newVal,0,n1,i,n1.length-i);
				
				return newVal;
			}
		}
		
		// just zero.
		return new int[]{0};
	}
	
	/**
	 * Return 0 if same, -1 if n1 is less than n2, and +1 is n1 > n2
	 * 
	 * compare len1 digits of n1 to same number of digits in n2, all starting
	 * at the appropriate offset (off1 or off2) in the different numbers.	 
	 */
	public static int compareTo (int []n1, int off1, int len1, int[]n2, int off2)
	{
		for (int i = 0; i < len1; i++) 
		{
			if (n2[off2+i] == n1[off1+i]) 
			{ 
				continue;
			}
			
			// Must be able to report by now...
			if (n2[off2+i] > n1[off1+i]) 
			{
				return -1;
			}
			else 
			{
				return +1;
			}
		}
		
		// must be the same!
		return 0;
	}
	
	/** 
	 * Return String representing n1/n2
	 *
	 * Recursive iterations.
	 */
	private static String subProcess(int[] n1, int[] n2)
	{

		// if n1.length is smaller than n2.length, we are going to be too small.
		if (n1.length < n2.length) 
		{
			return "+" + toString (n1);
		}
		
		// we have to extend, and reduce length. Note that this WILL terminate because
		// we would have left earlier if n2 were greater than n1.
		int off = 0;
		int length = n2.length;
		while (compareTo(n2,0,length,n1,off) > 0) 
		{
			n2 = expand(n2);
			length = n2.length;
			
			if (length > n1.length) 
			{
				// gone too far! We at last have our remainder! Return as "+remainder".
				return "+" + toString(n1);
			}
		}
		
		
		int []innerSum = new int[n1.length+1];  // add 1 just in case we get too high
		int []result = new int[length]; 
		int start;
		
		// initial set.
		if (n2[0] == 0) 
		{
			start = 9; 
			}
		else 
		{ 
			start = n1[0]/n2[0]; 
		}
		
		multiply(n2, start, innerSum);
		innerSum = reduce(innerSum);
		
		if (innerSum.length < n2.length) 
		{
			// perfect fit. Expand back out to work with subtractDown. REALLY UGLY CODE
			innerSum = expand(innerSum);
		} 
		else 
		{
			// must reduce and continue....
			while (n2.length < innerSum.length) 
			{
				start--;   // had gone too far! Back down.
				innerSum = new int[n1.length+1];
				multiply (n2, start, innerSum);
				innerSum = reduce(innerSum);
			}
		}
		
		boolean subtractDown = compareTo(innerSum, n1, innerSum.length) > 0;  // if false, we have to add up
		while (true) 
		{
			if (subtractDown) 
			{
				start--;
				subtract(innerSum, n2, result, subProcessSign);
				assign(innerSum, result);
				
				subtractDown = compareTo(innerSum, n1, innerSum.length) > 0;
			}
			else 
			{
				// found. Note that 'start' is the digit in the quotient. Subtract from and replace.
				int []newTop = new int[innerSum.length];
				extract(newTop,0,n1,0,innerSum.length);
				
				result = new int[innerSum.length];
				subtract(newTop, innerSum, result, subProcessSign);   
				extract(n1,0,result,0,result.length);     // copy back in
				
				int[]normalized_n1 = reduce(n1);
				int[]normalized_n2 = reduce(n2);
				String s = start + subProcess(normalized_n1, normalized_n2);
				return s;
			}
		}		
	}
	
	private static String toString (int []n) 
	{
		StringBuilder sb = new StringBuilder();
		for (int i : n) 
		{
			sb.append(i);
		}
		return sb.toString();
	}
	
	/**
	 * Multiply a number by a single digit.
	 * 
	 * Note that result.length = n1.length + 1
	 */
	public static void multiply(int[] n1, int d, int[] result) 
	{
		int[]n2 = new int[n1.length];
		n2[n2.length-1] = d;
		multiply (n2, n1, result);
	}
	
	/**
	 * Multiply two integers accurately.
	 * 
	 * @param n1
	 * @param n2
	 * @param result
	 */
	public static void multiply(int[] n1, int[] n2, int[] result) 
	{
		int pos = result.length-1;
		// clear all values....
		for (int i = 0; i < result.length; i++) 
		{
			result[i] = 0; 
		}
		
		int off;
		for (int m = n1.length-1; m>=0; m--) 
		{
			off = n1.length-1 - m;
			if (n1[m] == 0) 
			{
				continue; // skip zero multiplier! Won't affect total.
			}
			for (int n = n2.length-1; n>=0; n--) 
			{
				int prod = n1[m]*n2[n];
				
				result[pos-off] += prod % 10;
				if (result[pos-off] > 9) 
				{   // carry internally
					do 
					{
						result[pos-off] -= 10;
						result[pos-off-1]++;
					} 
					while (result[pos-off] > 9);
				}
				
				if (prod > 9) 
				{
					result[pos-off-1] += prod / 10;   // deal with carry sum later
				}
				off++;
			}
		}
	}
	
	/**
	 * Return 0 if same, -1 if n1 is less than n2, and +1 is n1 > n2
	 * 
	 * Simply compare len digits in sequence.
	 * 
	 * @param n1
	 * @param n2
	 */
	public static int compareTo (int []n1, int[]n2, int len) 
	{
		
		for (int i = 0; i < len; i++) 
		{
			if (n2[i] == n1[i]) 
			{ 
				continue;
			}
			
			// Must be able to report by now...
			if (n2[i] > n1[i]) 
			{
				return -1;
			}
			else 
			{
				return +1;
			}
		}
		
		// must be the same!
		return 0;
	}
	
	/**
	 * Pack from string into array.
	 * 
	 * @param n
	 * @param s
	 */
	public static void pack (int []n, String s) 
	{
		for (int i = 0; i < n.length; i++)
		{
			n[i] = 0; 
		}
		
		int idx = n.length-1;
		for (int i = s.length()-1; i >= 0; i--) 
		{
			n[idx--] = s.charAt(i) - '0';
		}
	}

	
	
	
	
	
	
	



	
	



}