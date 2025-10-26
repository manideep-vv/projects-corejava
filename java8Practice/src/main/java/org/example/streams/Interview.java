package org.example.streams;

public class Interview {
    public static void main(String[] args) {
        int score=1;
        switch (score){
            case 1 :
                System.out.println("one");
            case 2:
                System.out.println("two");
            default:
                System.out.println("default");
        }
        int five=5;
        int two=2;
        int total=five + (five >6 ? ++two: --two);
        System.out.println("result is "+total);
        String s1 =new String("one");
        String s2 =new String("two");
        String s3 =new String("three");
        s3=s1;
        s2=s3;
        s1=s2;

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }

}
