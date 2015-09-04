package Chapter15;

public class _12_SimpleHolder {
    private Object obj;

    public void set(Object obj) {
        this.obj = obj;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        _12_SimpleHolder holder = new _12_SimpleHolder();
        holder.set("item");
        String s = (String) holder.get();
    }
}
