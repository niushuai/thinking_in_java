package Chapter03;

/***
 * 
 * @author niushuai
 * 
 *         如果自定义类需要判断对象是否相等，则最好重载equals，而且重载equals必须重载hashCode，可使用eclipse自带的重载函数
 */

class Student {
	String name;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

public class EqualValence2 {
	public static void main(String[] args) {
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		student1.name = "zhangsan";
		student2.name = "lisi";
		student3.name = "lisi";

		System.out.println(student1.equals(student2));
		System.out.println(student2.equals(student3));
	}
}
