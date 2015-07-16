package Chapter19;

/**
 * 可以覆盖toSting()方法，为枚举类型生成不同的字符串描述。
 * 
 * @author niushuai02
 * 
 */
public enum _03_SpaceShip {
    SCOUT, GARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lower = id.substring(1).toLowerCase();
        return id.charAt(0) + lower;
    }

    public static void main(String[] args) {
        for (_03_SpaceShip s : values()) {
            System.out.println(s);
        }
    }
}
