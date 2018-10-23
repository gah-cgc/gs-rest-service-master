package hello;

public interface GreetingService {

	Greeting greetUser(String name, String uid);

	Greeting deleteUser(String uid);

    Greeting startupTimestamp();

}