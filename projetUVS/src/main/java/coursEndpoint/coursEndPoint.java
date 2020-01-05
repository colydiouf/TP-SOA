package coursEndpoint;

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
			public GetCourseDetailsResponse getCountry(@RequestPayload GetCourseDetailsRequest request) {
			GetCourseDetailsResponse response = new GetCourseDetailsResponse();
			response.setCourseDetails(courseService.findCourseDetails(request.getId()));
			return response;

}
}