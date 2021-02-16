package test;


import java.util.*;
import java.util.Map.Entry;

import static java.util.stream.Collectors.*;

public class Hash4 {

	static class Solution {
		public static void main(String[] args) {
			String genres[] = {
					  "classic"
					, "pop"
					, "classic"
					, "classic"
					, "pop"
					};
			int plays[] = {
					  500
					, 600
					, 150
					, 800
					, 2500
			};
			for(int a:solution(genres, plays)) System.out.println(a);
		}
		
	    public static int[] solution(String[] genres, int[] plays) {
	    	int[] answer = {};
	    	List<Integer> answerIntegerList = new ArrayList<Integer>();
	    	List<HashMap<String, Object>> answerNumList = new ArrayList<HashMap<String, Object>>();
	    	List<HashMap<String, Object>> musicOrgList = new ArrayList<HashMap<String, Object>>();
	    	List<HashMap<String, Object>> musicList = new ArrayList<HashMap<String, Object>>();
	        Map<String, Integer> musicMap = new HashMap<String, Integer>();
	        for(int i = 0; i< genres.length; i++) {
	        	if(musicMap.containsKey(genres[i])){
	        		musicMap.put(genres[i], (Integer)musicMap.get(genres[i])+plays[i]);
	        	}else {
	        		musicMap.put(genres[i], plays[i]);
	        	}
	        	HashMap<String, Object> musicOrgMap = new HashMap<String, Object>();
	        	musicOrgMap.put("index", i);
	        	musicOrgMap.put("gen", genres[i]);
	        	musicOrgMap.put("cnt", (Integer)plays[i]);	        	
	        	musicOrgList.add(musicOrgMap);
	        }
	    	
	        System.out.println( musicMap);
	        
	        int aa = 0;
	        for(String a: musicMap.keySet()) {
	        	HashMap<String, Object> musicObj = new HashMap<String, Object>();
	        	musicObj.put("index", aa);
	        	musicObj.put("gen", a);
	        	musicObj.put("cnt", (Integer)musicMap.get(a));
	        	musicList.add(musicObj);
	        	aa++;
	        }
	        
	        cusSort(musicList);
	        
	        for(HashMap<String, Object> musicObj : musicList) {
	        	List<HashMap<String, Object>> musicTempList = new ArrayList<HashMap<String, Object>>();
		        for(HashMap<String, Object> musicOrgObj : musicOrgList) {
		        	if(musicObj.get("gen").toString().equals(musicOrgObj.get("gen").toString())){
		        		musicTempList.add(musicOrgObj);
		        	}
	        	}
		        
		        cusSort(musicTempList);
	        	
		        int i = 0;
		        for(HashMap<String, Object> sortedObj: musicTempList) { 
		        	if(i > 1) break;
		        	answerNumList.add(sortedObj);
		        	i++;
		        }
		        
        	}

	        for(int i = 0; i < answerNumList.size(); i++) {
	        	HashMap<String, Object> sortedObj = answerNumList.get(i);
	        	answerIntegerList.add((Integer)sortedObj.get("index"));
	        }
	        
	        answer = Arrays.stream(answerIntegerList.toArray(new Integer[answerNumList.size()])).mapToInt(i->i).toArray(); 
	        
	        return answer;
	    }
	    
	    public static List<HashMap<String, Object>> cusSort(List<HashMap<String, Object>> orgList) {
	        Collections.sort(orgList, new Comparator<HashMap<String, Object>>()
	        { 			
	        	@Override
				public int compare(HashMap<String, Object> o1, HashMap<String, Object> o2) {
					// TODO Auto-generated method stub
	                if ((Integer)o1.get("cnt") < (Integer)o2.get("cnt")) {
	                    return 1;
	                } else if ((Integer)o1.get("cnt") > (Integer)o2.get("cnt")) {
	                    return -1;
	                }
	                return 0;
	            }

	        });
	        
	        return orgList;
        }	    
	}
}
