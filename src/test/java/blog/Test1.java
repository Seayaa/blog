package blog;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import redis.clients.jedis.Jedis;

public class Test1 {

	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		String num = jedis.get("num");
		System.out.println(num);
		
		System.out.println(jedis.get("a"));
		
		System.out.println(jedis.get("b"));
		
		List<Object> list = new ArrayList<>();
		list.stream()
			.filter(obj -> obj.equals(null))
			.collect(Collectors.toList());
		Comparator<Object> a = new Comparator<Object>() {
			
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}
	
}
