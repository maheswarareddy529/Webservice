package in.nit.model;

import java.util.List;
import java.util.Set;

import lombok.Data;
@Data
public class Student {
	private int stdId;
	private String stdName;
	private double stdFees;
	private List<Integer> marks;
	private Set<String> subjects;
	private String grades[];

}
