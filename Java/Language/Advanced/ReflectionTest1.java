import java.lang.reflect.Field;

record Student(int id, String course, float score){}

class ReflectionTest1 {

	/*
	private static void printAsXml(Interval obj) {
		System.out.println("<Interval>");
		System.out.printf("  <min>%s</min>%n", obj.minutes());
		System.out.printf("  <sec>%s</sec>%n", obj.seconds());
		System.out.println("</Interval>");
		System.out.println();
	}

	public static void printAsXml(Student obj) {
		System.out.println("<Student>");
		System.out.printf("  <id>%s</id>%n", obj.id());
		System.out.printf("  <course>%s</course>%n", obj.course());
		System.out.printf("  <score>%s</score>%n", obj.score());
		System.out.println("</Student>");
		System.out.println();

	}
	*/

	public static void printAsXml(Object obj) {
		Class<?> c = obj.getClass();
		System.out.printf("<%s>%n", c.getSimpleName());
		for(Field f : c.getDeclaredFields()){
			System.out.printf("  <%s>", f.getName());
			try{
				f.setAccessible(true);
				System.out.print(f.get(obj));
			}catch(Exception e){
				System.out.print(e);
			}
			System.out.printf("</%s>%n", f.getName());
		}
		System.out.printf("</%s>%n", c.getSimpleName());
		System.out.println();
	}

	public static void main(String[] args) {
		printAsXml(new Interval(3, 45));
		printAsXml(new Student(13, "Java", 81));
	}
}

