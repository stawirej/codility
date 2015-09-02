package codility.timecomplexity;

/**
 * Created by Peter on 2015-05-02.
 */
public class FrogJmp {

    public int solution(int X, int Y, int D) {
        return (int)Math.ceil((Y - X) / (double)D);
    }
}
