import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> list=new ArrayList<>();
		list.add(89);
		list.add(84);
		list.add(76);
		Integer d=0;
		for(int i=0;i<list.size();i++) {
			Integer g=list.get(i);
			d+=g;
		}
		System.out.println(d);
	}

}
