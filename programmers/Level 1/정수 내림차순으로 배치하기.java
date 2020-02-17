import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public long solution(long n) {
        StringBuilder sb = new StringBuilder();
        List<Long> list = new ArrayList<>();
        while(true) {
            if (n <= 0) break;
            long digit = n % 10;
            list.add(digit);
            n /= 10;
        }
        Collections.sort(list);
        for(int i=list.size() - 1; i >= 0; i--)
            sb.append(list.get(i));
        return Long.valueOf(sb.toString());
    }
}