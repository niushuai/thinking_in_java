package Chapter19;

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
