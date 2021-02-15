package test;

import java.util.HashMap;
import java.util.Map;

public class Hash1 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        
        Map<String, Integer> partMap = new HashMap<String, Integer>();
        Map<String, Integer> compMap = new HashMap<String, Integer>();
        for(String a: participant) {
        	if(partMap.containsKey(a)){
        		partMap.put(a, (Integer)partMap.get(a)+1);
        	}else {
        		partMap.put(a, 1);
        	}
        }
        
        for(String b: completion) {
        	if(compMap.containsKey(b)){
        		compMap.put(b, (Integer)compMap.get(b)+1);
        	}else {
        		compMap.put(b, 1);
        	}
        }
        
        for(String aa : partMap.keySet()) {
        	Integer partCnt = (Integer)partMap.get(aa);
        	Integer compCnt = 0;
        	
            if((Integer)compMap.get(aa) != null) {
            	compCnt = (Integer)compMap.get(aa);
            }
            
            if(partCnt > compCnt) {
            	answer = aa;
            	break;
            }
        }
        
        
        return answer;
    }
}
