package Chapter09;

/**
 * 
 * @author niushuai
 * 
 *         使用了工厂模式，我们现在有一个产品的模具，可以生产2种型号，分配给两家工厂生产。
 *         现在我想要实现的功能是：我指定一家工厂，你就自动给我出产品。 所以在工厂和产品之 
 *         间加了一层GetProduct接口，这样消费者只要指定工厂就可以了。
 *         
 *         这个程序充分体现了面向接口编程的好处。复用性极强
 * 
 */

interface ProductModel {
	void fun1();

	void fun2();
}

class Product1 implements ProductModel {
	public void fun1() {
		System.out.println("Product1 fun1()");
	}

	public void fun2() {
		System.out.println("Product1 fun2()");
	}
}

class Product2 implements ProductModel {
	public void fun1() {
		System.out.println("Product2 fun1()");
	}

	public void fun2() {
		System.out.println("Product2 fun2()");
	}
}

interface GetProduct {
	public ProductModel getProduct();
}

class Factory1 implements GetProduct {
	public ProductModel getProduct() {
		return new Product1();
	}
}

class Factory2 implements GetProduct {
	public ProductModel getProduct() {
		return new Product2();
	}
}

public class Factories {

	public static void customer(GetProduct getProduct) {
		ProductModel productModel = getProduct.getProduct();
		productModel.fun1();
		productModel.fun2();
	}

	public static void main(String[] args) {
		customer(new Factory1());
		customer(new Factory2());
	}
}
