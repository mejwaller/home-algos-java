package home.algosjava;


class mainpkg
{
	public static void main(String[] args) 
	{
		
	    for(int i=0; i<= 32; i++) {
	        
	        //int res = leetcode.hammingWeight(i);
	        String binrep = googleplay.fromDecimal(i,2);
	        
	        int nbits = 0;
	        for(int j = 0; j < binrep.length();j++) {
	            if(binrep.charAt(j) == '1') {
	                nbits++;
	            }	            
	        }
	        
	        //if(nbits!=res) {
	            System.out.println(leetcode.hammingWeight(i) + "  " + nbits + " " + googleplay.fromDecimal(i,2));
	        //}
	    }
	    
	    
	    
		//System.out.println(googleplay.gcd(1314,2336));
		//System.out.println(googleplay.gcd(25, 12));
	    
	    
		
		//System.out.println(googleplay.lcm(6,9));
		
		//System.out.println(googleplay.toDecimal(1111,2));
		
		//int[] frac1={4,9};
		//int[] frac2={1,6};
		
		//int[] res = googleplay.multFrac(frac1,frac2);
		
		//System.out.println("Multplying " + frac1[0] + "/" + frac1[1] + " by " + frac2[0] + "/" + frac2[1] + " = " + res[0] + "/" + res[1]);
		
		//int[] res = googleplay.addFrac(frac1,frac2);
		
		//System.out.println("Adding " + frac1[0] + "/" + frac1[1] + " to " + frac2[0] + "/" + frac2[1] + " = " + res[0] + "/" + res[1]);
		//googleplay.simplifyFrac(res);
		//System.out.println("Simplified, that's " + res[0] + "/" + res[1]);
		
		//int[] res = googleplay.subFrac(frac1,frac2);
		
		//System.out.println("Subtracting " + frac1[0] + "/" + frac1[1] + " from " + frac2[0] + "/" + frac2[1] + " = " + res[0] + "/" + res[1]);
		//googleplay.simplifyFrac(res);
		//System.out.println("Simplified, that's " + res[0] + "/" + res[1]);
		
		//int number = 31;
		//int base = 16;
		
		//System.out.println(number + " in base" + base + " is " + googleplay.fromDecimal(number, base));
		
		//String strnum = "FFF";
		
		//System.out.println(strnum + " in decimal is " + googleplay.baseToDecimal(strnum,base));
		
		/*int[][] validGrid = {
				{5,3,4,6,7,8,9,1,2},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,6,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}
			};
		
		int[][] invalidGrid = {
				{5,3,4,6,7,8,9,1,2},
				{6,7,2,1,9,5,3,4,8},
				{1,9,8,3,4,2,5,6,7},
				{8,5,9,7,6,1,4,2,3},
				{4,2,6,8,5,3,7,9,1},
				{7,1,3,9,2,4,8,5,6},
				{9,4,1,5,3,7,2,8,4},
				{2,8,7,4,1,9,6,3,5},
				{3,4,5,2,8,6,1,7,9}
			};
		
		boolean valid = true;
		
		for(int i = 0; i < 9; i++)
		{
			if(!googleplay.validateCol(i, invalidGrid))
			{
				valid = false;
				System.out.println("Grid col " + i + " was found to be invalid");
			}
		}
		
		if(valid)
		{
			System.out.println("Grid cols were valid");
		}
		*/
		
		//int[] val1 = {4,2};
		//int[] val2 = {9,9,9};
		
		//int[] val11 = googleplay.arrIncrementer(val1);
		//int[] val21 = googleplay.arrIncrementer(val2);
		
		/*for(int i = 0; i< val11.length;i++)
		{
			System.out.println("val11[" + i + "] is " + val11[i]);
		}
		
		System.out.println("");
		
		for(int i = 0; i< val21.length;i++)
		{
			System.out.println("val21[" + i + "] is " + val21[i]);
		}*/
		
		
		
		
		
		
		
		/*
        System.out.println("Hello."); // Display the string.
        
        int[] anarray = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
        
        int[] orig=anarray;
        
        System.out.println("Sorting by insertionSort:");
        
        for(int i = 0;i < anarray.length;i++)
        {
        	System.out.print(anarray[i] + ",");
        }
        
        System.out.println();
        
        SortersApp.insertionSort(anarray);
        
        System.out.println("Sorted array is:");
        
        for(int i = 0;i < anarray.length;i++)
        {
        	System.out.print(anarray[i] + ",");
        }
        
        System.out.println();
        */      
        
        /*
        int[] ar2 = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
                
        System.out.println("Partitoning ar3 on pivot inedx 9:");
        
        int index = partition(ar2,0,ar2.length-1,9);
        
        System.out.println("partition returned " + index + " and array is ");
        
        for(int i=0;i<ar2.length;i++)
        {
        	System.out.print(ar2[i] + ",");
        }
        System.out.println();   
        
        int[] ar3 = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
        
        index = selectKth(ar3,8,0,ar3.length-1);
        
        System.out.println("selectKth(8) for array returned " + index + " and array is ");
        
        for(int i=0;i<ar3.length;i++)
        {
        	System.out.print(ar3[i] + ",");
        }
        System.out.println();
        */        
        
        /*int[] ar4 = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
        
        System.out.println("Sorting by mediansort:");
        
        for(int i=0;i<ar4.length;i++)
        {
        	System.out.print(ar4[i] + ",");
        }
        System.out.println();
        
        SortersApp.mediansort(ar4,0,ar4.length-1);
        
        System.out.println("sorted array is now:");
        
        for(int i=0;i<ar4.length;i++)
        {
        	System.out.print(ar4[i] + ",");
        }
        System.out.println();  
        */
        
         
		/*
        int[] ar5 = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
        
        System.out.println("Sorting by qsort:");
        
        for(int i=0;i<ar5.length;i++)
        {
        	System.out.print(ar5[i] + ",");
        }
        System.out.println();
        
        SortersApp.qsort(ar5,0,ar5.length-1);
        
        System.out.println("sorted array is now:");
        
        for(int i=0;i<ar5.length;i++)
        {
        	System.out.print(ar5[i] + ",");
        }
        System.out.println();
        */ 
        
        /*
        
        int[] ar6 = {15,9,8,1,4,11,7,12,13,6,5,3,16,2,10,14};
        
        System.out.println("Heap sorting array:");
        for(int i=0;i<ar6.length;i++)
        {
        	System.out.print(ar6[i] + ",");
        }
        System.out.println();
        
        SortersApp.heapSort(ar6);
        

        System.out.println("after heap sorting array:");
        for(int i=0;i<ar6.length;i++)
        {
        	System.out.print(ar6[i] + ",");
        }
        System.out.println();
        
        SortersApp.buildHeap(ar6);
        
        System.out.println("after heapifying sorted array:");
        for(int i=0;i<ar6.length;i++)
        {
        	System.out.print(ar6[i] + ",");
        }
        System.out.println();
        
        int[] n1 = {9,9,9};
        int[] n2 = {1,2,3};
        int[] sum = {0,0,0,0};
        
        System.out.println(n1[0] + "" + n1[1] + "" + n1[2] + " + " + n2[0] + n2[1] + n2[2]);
        
        SortersApp.add(n1,n2,sum);
        
        System.out.println(" = " +  sum[0] + sum[1] + sum[2] + sum[3]);
        
        sum[0] = sum[1] = sum[2] = sum[3] = 0;       
        
        System.out.println();
        
        SortersApp.last(n1,n2,sum);
        
        System.out.println(n1[0] + "" + n1[1] + "" + n1[2] + " + " + n2[0] + n2[1] + n2[2] + " = " +  sum[0] + sum[1] + sum[2] + sum[3]);
        
        System.out.println();
        */
        
        /*
        System.out.println("Euclids gcd");
        
        int n1[] = {1,2,3,4,5,6,7,8,9};
        int n2[] = {9,8,7,6,5,4,3,2,1};
        
        int[] gcd = new int[n1.length];
        
        System.out.println("Euclids gcd of 123456789 and 987654321 is :");
        
        gcds.Euclidgcd(n1,n2,gcd);       
        
        for(int i = 0; i < gcd.length; i++)
        {
        	System.out.print(gcd[i]);
        }
        
       	System.out.println();
       	       	
       	System.out.println("Mod gcd");
       	
       	System.out.println("Mod gcd of 123456789 and 987654321 is :");
       	
       	gcds.modgcd(n1,n2,gcd);       
        
        for(int i = 0; i < gcd.length; i++)
        {
        	System.out.print(gcd[i]);
        }
        
       	System.out.println();
       	*/
       	
       	
    
	
	
        
        
                
                      	
    }
}
