package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("helloApp")
public class GreetingController {

	@Autowired
	private GreetingService service;

    // Endpoint name and versioning; e.g. /com/capgroup/api/equity-trading/{serviceName}/v{versionNumber}/{apiName}

	// e.g. HTTP GET - http://localhost:8080/helloApp/greetUser?name=GAH&uid=18
	@RequestMapping(method = RequestMethod.GET, value = "/greetUser", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Greeting greetUser(@RequestParam(value = "name", defaultValue = "World") final String name,
			@RequestParam(value = "uid", defaultValue = "0") final String uid) {
		return service.greetUser(name, uid);
	}

	// e.g. HTTP DELETE - http://localhost:8080/helloApp/deleteUser/18
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser/{uid}", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Greeting deleteUser(@PathVariable final String uid) {
		return service.deleteUser(uid);
	}

    // e.g. HTTP GET - http://localhost:8080/helloApp/startupTimestamp
    @RequestMapping(method = RequestMethod.GET, value = "/startupTimestamp", produces = {
            MediaType.APPLICATION_JSON_VALUE })
    public Greeting startupTimestamp() {
        return service.startupTimestamp();
    }

	// e.g. HTTP POST - http://localhost:8080/helloApp/deleteUser/18 returns status=201(created)
	/*
	 * @RequestMapping(method=RequestMethod.POST, value="createUser/{uid}") public ResponseEntity<Object>
	 * createUser(@PathVariable Long uid) { URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{uid}").bildAndExpand(uid).toUri(); return
	 * ResponseEntity.created(location).build(); }
	 */

	// See also: OneNote | Spring Boot | Exception handling

}
