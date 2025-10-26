package org.example.numberformat;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatDemo {
    public static void main(String[] args) {
        NumberFormat nm=NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println(nm.format(113548812345641.789));

        DecimalFormat df3 = new DecimalFormat("₹#,##,###.##");
        System.out.println("Custom currency: " + df3.format(113548812345641.789));


    }
}

