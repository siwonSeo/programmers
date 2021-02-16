package test;


import java.util.*;

import static java.util.stream.Collectors.*;

public class Hash3 {

	static class Solution {
		public static void main(String[] args) {
			String aa[][] = {
					 {"yellow_hat", "headgear"}
					,{"blue_sunglasses", "eyewear"}
					,{"green_turban", "headgear"}
					,{"green_turban2", "headgear"}
					,{"green_turban3", "headgear"}
					,{"green_turban3", "headgear2"}
					,{"green_turban3", "headgear3"}
					,{"green_turban33", "face"}
					,{"green_turban332", "face"}
					};
			solution(aa);
		}
		
	    public static void solution(String[][] clothes) {
	    	/*
	        return Arrays.stream(clothes)
	                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
	                .values()
	                .stream()
	                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1;
	                */
	    	
    		Collection<Long> aa = Arrays.stream(clothes)
		            .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
		            .values();
            
	        System.out.println( 
	        		aa
	        		);
	        System.out.println( 
	    	        aa.stream()
	                .collect(reducing(1L, (x, y) -> x * (y + 1))).intValue() - 1
	        		);

	        
	    }
	}
}
