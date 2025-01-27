package GoldmanSachs;

import java.util.*;

class DataStream {
    ArrayList<Integer> array = new ArrayList<>();
    Deque<Integer> dq = new ArrayDeque<>();
    int target;
    int valCount = 0;
    int size;

    public DataStream(int value, int k) {
        target = value;
        size = k;
    }

    public boolean consec(int num) {
        if(dq.size() >= size) {
            int removed = dq.removeFirst();
            if(removed == target) valCount--;
        }

        if(num == target) valCount++;
        dq.addLast(num);
        if(valCount == size) return true;
        return false;
    }
}

public class Find_Consecutivr_Integers_From_A_Data_Stream {
    public static void main(String[] args) {
        DataStream dataStream = new DataStream(4,3);
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(4));
        System.out.println(dataStream.consec(3));
    }
}
