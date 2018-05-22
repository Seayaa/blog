package blog;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		
		/*doRun(() -> {
			System.out.println("hello");
		});
		
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("aa");
			System.exit(0);
		});
		
		Thread t2 = new Thread(() -> {
			System.out.println("bb");
		});
		
		t1.start();
		t2.start();*/
		
	/*	List<String> list = new ArrayList<>();
		list.add("v");
		list.add("b");
		list.add("a");
		
		list.stream().forEach(System.out::println);
*/
		
		List<User> list = new ArrayList<>();
		
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		User u4 = new User();
		list.add(u1);
		list.add(u2);
		list.add(u3);
		list.add(u4);
		
		u1.setName("Helen");
		u1.setAge(10);
		u1.setLocation("NewYork");
		
		u2.setName("David");
		u2.setAge(12);
		u2.setLocation("London");

		u3.setName("Nancy");
		u3.setAge(7);
		u3.setLocation("Paris");
		
		u4.setName("Jack");
		u4.setAge(6);
		u4.setLocation("Beijing");
		
		list.stream().forEach((u) -> {
			System.out.print(u.getName() + "---" + u.getAge() + "---" + u.getLocation());
			System.out.println("");
		});
		
		System.out.println("");
		System.out.println("sorted by name:");
		list.stream().sorted((User a, User b) -> {
			String aname = a.getName();
			String bname = b.getName();
			return aname.compareTo(bname);
			
		}).forEach((u) -> {
			System.out.print(u.getName() + "---" + u.getAge() + "---" + u.getLocation());
			System.out.println("");
		});;
		
		
		System.out.println("");
		System.out.println("sorted by age:");
		list.stream().sorted((User a, User b) -> {
			return a.getAge() - b.getAge();
		}).forEach((u) -> {
			System.out.print(u.getName() + "---" + u.getAge() + "---" + u.getLocation());
			System.out.println("");
		});
		
		System.out.println("");
		System.out.println("sorted by location:");
		list.stream().sorted((User a, User b) -> {
			return a.getLocation().compareTo(b.getLocation());
		}).forEach((u) -> {
			System.out.print(u.getName() + "---" + u.getAge() + "---" + u.getLocation());
			System.out.println("");
		});
		
		
	}
	
	public static void doRun(FuncInt funcInt) {
		System.out.println("aa");
		funcInt.run();
	}
	
}
