package test;

import java.util.HashMap;
import java.util.Map;

public class Hash2 {

    public boolean solution(String[] phone_book) {
    	boolean answer = true;
        
        
        Map<String, String> bookMap = new HashMap<String, String>();
        for(String a: phone_book) {
        	bookMap.put(a,a);
        }
        
        
        for(String aa : bookMap.keySet()) {
        	
        	for(String bb : bookMap.keySet()) {
        		if(!aa.equals(bb) && bookMap.get(bb).startsWith(aa)) {
        			answer = false;
        			break;
        		}
        	}
        	
        	if(!answer) {
        		break;
        	}
        }
        
        
        return answer;
    }
}
