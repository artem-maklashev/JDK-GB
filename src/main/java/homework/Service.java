package homework;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private volatile List<Fork> forks;
    public Service(int count) {
        forks = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            forks.add(new Fork(i+1));
        }
    }
    public void takeFork(int left, int right) {
        forks.get(left -1).take();
        forks.get(right -1).take();
    }
    public void putFork(int left, int right) {
        forks.get(left -1).put();
        forks.get(right -1).put();
    }

    public Fork getFork(int index) {
        return forks.get(index-1);
    }


}
