import java.util.BitSet;

/**
 * @author hjh
 * @version 1.0.0
 * @date 2021/2/15
 * @since 1.8
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BitSet bitSet = new BitSet();
        bitSet.set(0,10,true);
        boolean b = bitSet.get(11);
        boolean b1 = bitSet.get(1);
    }


}
