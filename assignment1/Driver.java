package assignment01;

public class Driver {
	public static void main(String[] args)
	{
		Person person1 = new Person("Doe", "Jane", 'E');
		Person person2 = new Person("Doe", "John", 'F');
		Person person3 = new Person("Deer", "Jack", 'G');
		
		Student student1 = new Student(person1);
		Student student2 = new Student(person2);
		Student student3 = new Student(person3);
		
		Class math = new Class("Calculus", "227", 2, 1048);
		Class science = new Class("Biology", "117", 4, 8205);
		Class history = new Class("Animal Rights", "280A", 3, 10582);
		Class adv_math = new Class("Calculus 3", "327", 4, 2958);
		Class adv_science = new Class("Advanced Biology", "317", 4, 8206);
		Class adv_history = new Class("American History", "422", 3, 10058);
		Class adv_writing = new Class("Writing", "112", 4, 10448);

		student2.setClass1(math);
		student2.setClass2(science);
		student2.setClass3(history);
		
		student2.setQualPoints1(4.0 * math.getNumCredits());
		student2.setQualPoints2(2.3 * science.getNumCredits());
		student2.setQualPoints3(4.0 * history.getNumCredits());
		
		student3.setClass1(adv_math);
		student3.setClass2(adv_science);
		student3.setClass3(adv_history);
		student3.setClass4(adv_writing);
		
		student3.setQualPoints1(4.0 * adv_math.getNumCredits());
		student3.setQualPoints2(4.0 * adv_science.getNumCredits());
		student3.setQualPoints3(3.7 * adv_history.getNumCredits());
		student3.setQualPoints4(4.0 * adv_writing.getNumCredits());
		
		System.out.printf("%.3f\n", student1.computeSemesterGPA());
		System.out.printf("%.3f\n", student2.computeSemesterGPA());
		System.out.printf("%.3f\n", student3.computeSemesterGPA());
	}
}