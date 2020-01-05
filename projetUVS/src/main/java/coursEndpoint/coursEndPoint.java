package coursEndpoint;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.cours.CourseDetails;
import org.example.cours.GetCourseDetailsRequest;
import org.example.cours.GetCourseDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import coursService.CourseService;

@Endpoint
public class coursEndPoint {
	
	private static final String NAMESPACE_URI = "http://www.example.org/cours";
	       @Autowired
			private CourseService courseService;
		
			@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
			@ResponsePayload
			public GetCourseDetailsResponse getCourseDetailsResponse(@RequestPayload GetCourseDetailsRequest request) {
			GetCourseDetailsResponse response = new GetCourseDetailsResponse();
			response.setCourseDetails(courseService.findCourseDetails(request.getId()));
			return response;
			}
			@ResponsePayload
			public Map<String,CourseDetails> getallCourseDetailsResponse() {
			Map<String,CourseDetails> response =new HashMap<>();
			response=courseService.findCourseDetails();
			return response;
           }
			@ResponsePayload
			public void deletCourseDetailsResponse(@RequestPayload BigInteger id) {
			courseService.deletById(id);
			
			}
}