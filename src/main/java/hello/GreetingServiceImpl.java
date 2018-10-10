package hello;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class GreetingServiceImpl implements GreetingService {
	private static final String templateString = "Hello, %s(uid=%s)!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private AppConfig appConfig;

	@Override
	public Greeting greetUser(final String name, final String uid) {
		return new Greeting(appConfig, counter.incrementAndGet(), String.format(templateString, name, uid));
	}

	@Override
	public Greeting deleteUser(final String uid) {
		return new Greeting(appConfig, counter.incrementAndGet(), String.format("Delete uid=%s", uid));
	}

    //GAH: this is to test Spring SpEL injection of Map<> data structure
    //@Autowired
    //@Value("#{myTestMap}")
    @Resource
    private Map<String, String> myTestMap;

    //@Autowired(required = true)
    //@Resource(name="myTestMap")
    //@Resource
    //@Required
    public void setMyTestMap(Map<String, String> myTestMap) {
        this.myTestMap = myTestMap;
        System.out.println(String.format("### GAH: loaded map with size %s", myTestMap.size()));

    }

    @Value(value = "8")
    private int myInt;
    public void setMyInt(int myInt) {
        this.myInt = myInt;
    }

}
