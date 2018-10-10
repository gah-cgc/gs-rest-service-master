package hello;

public class Greeting {

	private final long id;
	private final String content;
	private final AppConfig appConfig;

	public Greeting(final AppConfig appConfig, final long id, final String content) {
		this.appConfig = appConfig;
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getField1() {
		return appConfig.getField1();
	}

	public Double getField2() {
		return 12345678.12345678d;
	}
}
