
public class Profile {
	private int id;
	private String login;
	private String fio;
	private String phone;
	
	public Profile(int id, String login, String fio, String phone) {
		this.id = id;
		this.login = login;
		this.fio = fio;
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id: ");
		sb.append(id);
		sb.append("\nlogin: ");
		sb.append(login);
		sb.append("\nfio: ");
		sb.append(fio);
		sb.append("\nphone: ");
		sb.append(phone);
		return sb.toString();
	}
}
