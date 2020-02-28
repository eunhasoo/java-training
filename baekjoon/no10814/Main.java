package baekjoon.no10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class User {
	private int age;
	private String name;
	private int signUpNo;
	
	public User(int age, String name, int signUpNo) {
		this.age = age;
		this.name = name;
		this.signUpNo = signUpNo;
	}

	public int getAge() {
		return age;
	}
	
	public int getSignUpNo() {
		return signUpNo;
	}
	
	@Override
	public String toString() {
		return this.age + " " + this.name + "\n";
	}
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		int N = Integer.valueOf(reader.readLine());
		List<User> userList = new ArrayList<>();
		StringTokenizer st;
		int signUpNo = 0;
		while (N-- > 0) {
			st = new StringTokenizer(reader.readLine());
			int age = Integer.valueOf(st.nextToken());
			String name = st.nextToken();
			userList.add(new User(age, name, ++signUpNo));
		}
		userList.sort((u1, u2) -> {
			int r = u1.getAge() - u2.getAge();
			if (r == 0)
				r = u1.getSignUpNo() - u2.getSignUpNo();
			return r;
		});
		for(int i=0; i<userList.size(); i++)
			builder.append(userList.get(i));
		System.out.print(builder);
	}

}
