package StreamPrac;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practice1 {

    public static void main(String[] args) {
        HashMap<String,Integer> h1=new HashMap<>();
        h1.put("A",100);
        h1.put("B",500);
        h1.put("C",900);
        h1.put("D",200);
        Comparator<Map.Entry<String,Integer>> comp=(a,b)->{
            return a.getValue()>b.getValue()?1:-1;
        };
        List<Map.Entry<String, Integer>> collect = h1.entrySet().stream().sorted(comp).collect(Collectors.toList());

//        System.out.println("key: "+max.get().getKey()+"value: "+max.get().getValue());
    }


}
