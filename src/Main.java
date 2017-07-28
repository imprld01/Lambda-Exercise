import java.util.ArrayList;
import java.util.Hashtable;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		Test t = (s) -> {
			System.out.println("No Problem: " + s);
		};
		t = (s) -> System.out.println("No Problem: " + s);
		t = s -> System.out.println("No Problem: " + s);
		
		t.todo("OKOK");
		
		Test t2 = Main::printItOut;
		t2.todo("Good to Use!");
		
		Test3 t3 = new Test3() {
			
			public Runnable r1 = () -> System.out.println("r1: " + this.getClass());
			
			public Runnable r2 = new Runnable(){
			    public void run(){
			    	System.out.println("r2: " + this.getClass());
			    }
			};
			
			public void run2() {
				
			}
			
			private void run() {
				
			}
			
			public void todo() {
				new Thread(r1).start();
				new Thread(r2).start();
			}
			
			public void todo2() {
				
				this.run();
			}
		};
		
		t3.todo();
		
		Test4 t4 = (s) -> {
			
			return Integer.parseInt(s) + 1000;
		};
		
		System.out.println(t4.convert("5"));
		
		Test4 t5 = s -> {
			
			return Integer.parseInt(s) + 2000;
		};
		
		System.out.println(t5.convert("33"));
		
		Test4 t6 = Main::parseIt;
		
		System.out.println(t6.convert("88"));
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("8");
		al.add("5");
		al.add("1");
		al.add("7");
		al.add("3");
		
		al.forEach(s -> System.out.print(s + " "));
		al.forEach((s) -> System.out.print(s + " "));
		al.forEach((String s) -> System.out.print(s + " "));
		al.forEach(s -> { System.out.print(s + " "); });
		
		System.out.println();
		
		al.forEach(Main::printItOut);
		
		al.stream().filter(s -> Integer.valueOf(s) > 3).forEach(s -> System.out.print(s + "/"));
		
		System.out.println();
		
		ArrayList<String> al2 = new ArrayList<String>();
		al2.addAll(al.stream().filter(s -> Integer.valueOf(s) < 3).collect(Collectors.toList()));
		
		System.out.println(al.stream().mapToInt(s->Integer.valueOf(s)).sum());
		System.out.println(al.stream().filter(s -> Integer.valueOf(s) > 3).mapToInt(s->Integer.valueOf(s)).average().getAsDouble());
		
		System.out.println();
		
		Hashtable<String, String> ht = new Hashtable<String, String>();
		
		ht.put("John", "1999/07/04");
		ht.put("Tommy", "1979/09/27");
		ht.put("Tim", "1959/11/01");
		ht.put("Jack", "1990/03/14");
		ht.put("Mary", "1993/10/18");
		
		ht.forEach((k, v) -> System.out.println("Name:" + k + " Birthday:" + v));
		ht.forEach((String k, String v) -> System.out.println("Name:" + k + " Birthday:" + v));
		ht.forEach((String k, String v) -> { System.out.println("Name:" + k + " Birthday:" + v); });
	}
	
	public static void printItOut(String string) {
		
		System.out.println("Ha: " + string);
	}
	
	public static int parseIt(String ss) {
		
		return Integer.parseInt(ss) + 5000;
	}
	
	public interface Test {
		
		public void todo(String t);
	}
	
	public interface Test3 {
		
		public void todo();
		public void todo2();
	}
	
	public interface Test4 {
		
		public int convert(String s);
	}
}