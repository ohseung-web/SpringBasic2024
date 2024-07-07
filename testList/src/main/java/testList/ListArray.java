package testList;

import java.util.ArrayList;
import java.util.List;

public class ListArray {

	//private List<String> list;
	
	private ArrayList<String> list;
	
	public ListArray() {}
	public void ListInfo() {
		for(int i=0; i<list.size(); i++) {
			System.out.println(i + "번째 요소 : "+ list.get(i));
		}
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = (ArrayList<String>) list; //다운캐스팅한다.
	}
	
	
}

