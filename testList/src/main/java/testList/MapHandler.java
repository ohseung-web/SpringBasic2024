package testList;

import java.util.Map;

public class MapHandler {

	//filed
	Map<String, String> mymap;
	//Constructor
	public MapHandler() {}
	//method
	public void mapInfo() {
		// 확장 for문
		for(String key : mymap.keySet() ) {
			String value = mymap.get(key);
			System.out.println(key + ":"+ value);
		}
	}
	//getter/setter
	public Map<String, String> getMymap() {
		return mymap;
	}
	public void setMymap(Map<String, String> mymap) {
		this.mymap = mymap;
	}
	
	
}
