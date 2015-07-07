package Chapter21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CompareEntity implements Comparable {

    private int rank;

    @Override
    public int compareTo(Object o) {
        CompareEntity c = (CompareEntity) o;
        return this.rank - c.rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public String toString() {
        return this.rank + "aa";
    }

}

public class TestCompare {
    public static void main(String[] args) {
        
        List<CompareEntity> a = new ArrayList<CompareEntity>();
        
        CompareEntity c1 = new CompareEntity();
        c1.setRank(102);
        
        
        CompareEntity c2 = new CompareEntity();
        c2.setRank(15);
        
        a.add(c1);
        a.add(c2);
        
        Collections.sort(a);
        
        System.out.println(Arrays.asList(a));
    }
}
