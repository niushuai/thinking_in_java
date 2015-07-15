package Chapter19;

import java.util.ArrayList;
import java.util.List;

import Chapter19.Recipe.American;
import Chapter19.Recipe.Chinese;
import Chapter19.Recipe.Japanese;

/**
 * 我们去饭店吃饭，都会有菜单，并且按照一定规则分类（比如热菜、凉菜、主食、饮料等)<br>
 * 那么，我们在程序中如何录入菜单呢？<br>
 * 如果可能，我希望是枚举嵌套枚举，但是不能实现...sigh
 * 
 * 因为枚举没法嵌套，这里使用接口将枚举按组罗列，整体还是很清晰的
 */
interface Recipe {
    enum Chinese implements Recipe {
        宫保鸡丁 {
            public String show() {
                return "招牌菜——宫保鸡丁，采用108道工序，宫廷秘方连续烹煮18个小时而成，具有滋阴补阳的功效...";
            }
        },
        鱼香肉丝("酸甜可口"), 酸辣土豆丝("我的最爱");

        private String des;

        // 转为招牌菜提供的招牌菜详细介绍构造函数
        private Chinese() {

        }

        // 为普通菜品提供的简介构造函数
        private Chinese(String des) {
            this.des = des;
        }

        @Override
        public String show() {
            return des;
        }
    }

    enum American implements Recipe {
        hotdog, hamburger, icecream;

        @Override
        public String show() {
            return "";
        }
    }

    enum Japanese implements Recipe {
        生鱼片, 寿司;

        @Override
        public String show() {
            return "";
        }
    }

    abstract String show();
}

public class _08_Food {
    public static void main(String[] args) {
        System.out.println("服务员：先森，你需要点什么？");

        List<Recipe> recipe = new ArrayList<Recipe>();
        System.out.println("客人：给我介绍个招牌菜");
        System.out.println("服务员：" + Chinese.宫保鸡丁.show());
        System.out.println("客人：好，来一个");
        recipe.add(Chinese.宫保鸡丁);
        System.out.println("客人：这个咋样？");
        System.out.println("服务员：" + Chinese.鱼香肉丝.show());
        System.out.println("客人：哦，我不喜欢甜的");
        recipe.add(American.hotdog);
        recipe.add(Japanese.寿司);

        System.out.println("你点的餐有：" + recipe);
    }
}/*output:
服务员：先森，你需要点什么？
客人：给我介绍个招牌菜
服务员：招牌菜——宫保鸡丁，采用108道工序，宫廷秘方连续烹煮18个小时而成，具有滋阴补阳的功效...
客人：好，来一个
客人：这个咋样？
服务员：酸甜可口
客人：哦，我不喜欢甜的
你点的餐有：[宫保鸡丁, hotdog, 寿司]
*/
