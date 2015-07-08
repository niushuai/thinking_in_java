package Chapter19;

import java.util.ArrayList;
import java.util.List;

import Chapter19.Recipe.American;
import Chapter19.Recipe.Chinese;
import Chapter19.Recipe.Japanese;

/**
 * 我们去饭店吃饭，都会有菜单，并且按照一定规则分类（比如热菜、凉菜、主食、饮料等） 那么，我们在程序中如何录入菜单呢？
 * 
 * 如果可能，我希望是枚举嵌套枚举，但是貌似不能实现？
 * 
 * @author niushuai02
 * 
 */
interface Recipe {
    enum Chinese implements Recipe {
        宫保鸡丁, 鱼香肉丝, 酸辣土豆丝;
    }

    enum American implements Recipe {
        hotdog, hamburger, icecream;
    }

    enum Japanese implements Recipe {
        生鱼片, 寿司;
    }
}

public class _08_Food {
    public static void main(String[] args) {
        System.out.println("先森，你需要点什么？");

        List<Recipe> recipe = new ArrayList<Recipe>();
        recipe.add(Chinese.宫保鸡丁);
        recipe.add(American.hotdog);
        recipe.add(Japanese.寿司);

        System.out.println("好的，你需要的餐点有：" + recipe);
    }
}
