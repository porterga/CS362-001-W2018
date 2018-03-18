package finalprojectB;

public class Pair {

	private final String value;
	private final boolean status;

	public Pair(String value, boolean status){
		this.value = value;
		this.status = status;
	}

	public String getValue() {
		return value;
	}

	public boolean getStatus() {
		return status;
	}
}
