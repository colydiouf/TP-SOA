package coursService;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.example.cours.CourseDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	private static final Map<String, CourseDetails> coursDetails = new HashMap<>();
	@PostConstruct
	public void initData() {
	// initialize courseDetails map
		CourseDetails courseDetails1 =new CourseDetails();
		courseDetails1.setId(123);
		courseDetails1.setName("diouf");
		courseDetails1.setDescription("TD1 soap ");
		
		CourseDetails courseDetails2 =new CourseDetails();
		courseDetails2.setId(123);
		courseDetails2.setName("diouf");
		courseDetails2.setDescription("TD1 soap ");
		
		
		coursDetails.put(courseDetails1.getName(),courseDetails1);
		coursDetails.put(courseDetails1.getDescription(),courseDetails1);
		coursDetails.put(courseDetails2.getName(),courseDetails2);
		coursDetails.put(courseDetails2.getDescription(),courseDetails2);
		
	}
	public CourseDetails findCourseDetails(BigInteger id) {
	     return coursDetails.get(id);
	}
	
	
}
