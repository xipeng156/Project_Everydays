package day0908;

import java.util.BitSet;

public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();

        for (int i = 0; i < 16; i++) {
            if (i%2==0)
                bitSet1.set(i);
            if (i%5!=0)
                bitSet2.set(i);
        }

        System.out.println("bitset1:"+bitSet1);
        System.out.println("bitset2:"+bitSet2);

//        将1中的数据放入2中（求交集）
//        bitSet2.and(bitSet1);
//        System.out.println("合并后"+bitSet2);
//        求并集
        bitSet2.or(bitSet1);
        System.out.println(bitSet2);

    }
}
