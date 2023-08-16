package com.ayush;


import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

interface CompareSingleAndLp {
    void compare(List<Single> singles, List<Lp> lps);
}

public class Client {
    public static void main(String[] args) {


        List<Single> singles = List.of(
                new Single(1962,
                        "Love me do", new Date(1962, Calendar.OCTOBER, 5)),
                new Single(1963,
                        "Please Please me", new Date(1963, Calendar.JANUARY, 11)),
                new Single(1963,
                        "From Me To You / Thank You Girl", new Date(1963, Calendar.APRIL, 12)),
                new Single(1963,
                        "She Loves You / I’ll Get You", new Date(1963, Calendar.AUGUST, 23))
        );
        List<Lp> lps = List.of(

                new Lp(1963,
                        "Please Please me", new Date(1963, Calendar.MARCH, 22)),
                new Lp(1963,
                        "With The Beatles", new Date(1963, Calendar.NOVEMBER, 22)),
                new Lp(1964,
                        "A  Hard Day’s Night", new Date(1964, Calendar.JULY, 10))
        );
        List<Ep> eps = List.of(
                new Ep(1963,
                        "Long Tall Sally / I Call Your Name /" +
                                " Slow Down / Match Box", new Date(1963, Calendar.JULY, 10))
        );
//        System.out.println(singles);
//        System.out.println(eps);
//        System.out.println(lps);

        System.out.println("*****************Task2**********************");
        singlesBeforeThanksgiving(singles);
        System.out.println("*****************Task3**********************");
        findSameInSinglesAndLp(singles,lps);
        System.out.println("*****************Task4**********************");
        countNoOfItemInAll(singles, lps, eps);
        System.out.println("*****************Task5**********************");
        countByYear(singles, lps, eps);


    }

    public static void singlesBeforeThanksgiving(List<Single> singles) {
        Predicate<Single> pSingle = (s) -> s.getDate()
                .before(new Date(1963, Calendar.APRIL, 12));

        for (Single s : singles) {
            if (pSingle.test(s)) {
                System.out.println(s);
            }
        }
    }

    public static void findSameInSinglesAndLp(List<Single> singles, List<Lp> lps) {
        List<Beatles> res = new ArrayList<>();
        CompareSingleAndLp comp = (single, lp) -> {
            for (Single s : single) {
                for (Lp l : lp) {
                    if (s.getName().equalsIgnoreCase(l.getName())) {
                        res.add(s);
                        res.add(l);
                    }
                }
            }
        };
        comp.compare(singles, lps);
        res.sort(((o1, o2) -> o1.getDate().compareTo(o2.getDate())));
        System.out.println(res);


    }

    public static void countNoOfItemInAll(List<Single> singles, List<Lp> lps, List<Ep> eps) {

        long count = singles.stream().count() + lps.stream().count() + eps.stream().count();
        System.out.println("Count of all the items are : " + count);

    }

    public static void countByYear(List<Single> singles, List<Lp> lps, List<Ep> eps) {
        Map<Integer, Long> singlesPerYr = singles.stream().collect(Collectors.groupingBy(Beatles::getYear, Collectors.counting()));
        Map<Integer, Long> epsPerYr = eps.stream().collect(Collectors.groupingBy(Beatles::getYear, Collectors.counting()));
        Map<Integer, Long> lpsPerYr = lps.stream().collect(Collectors.groupingBy(Beatles::getYear, Collectors.counting()));

        double avgSinglePY = (double) singles.stream().count() / singlesPerYr.size();
        double avgLpPerYear = (double) lps.stream().count() / lpsPerYr.size();
        double avgEpsPerYear = (double) eps.stream().count() / epsPerYr.size();

        System.out.println("Avg Singles per year  = " + avgSinglePY);
        System.out.println("Avg Eps per year  = " + avgEpsPerYear);
        System.out.println("Avg Lps per year  = " + avgLpPerYear);


    }

}
