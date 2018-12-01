public static void GetSmallestPrime(int arr[]) {
	System.out.println(" Finding Smallest Prime ");
	ArrayList<Integer>primes=new ArrayList<Integer>();
	for(int i=0 ; i<arr.length;i++) {
		boolean flag=false;
		if(arr[i]==0||arr[i]==1) {
			flag=true;
			
		}
		
		for(int j=2; j<arr[i]/2 ;j++) {
			if(arr[i]%j==0) {
				flag=true;
				break;
			}
		}
		
		if(!flag) {primes.add(arr[i]);}
	}
		  int minValue = primes.get(0);
		  int indexx=0;
		  for(int i=1;i<primes.size();i++){
		    if(primes.get(i)< minValue){
			  minValue = primes.get(i);
			  indexx=i;
			}
		  }
		  System.out.println(primes.get(indexx));
		}
