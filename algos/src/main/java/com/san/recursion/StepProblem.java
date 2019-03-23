package com.san.recursion;

public class StepProblem {

//    Step Problem: Given n find out number of ways you can reach nth step if you can go 1 step or two steps at a time
//    e.g.
//
//            n=1
//            1
//
//    n=2
//            1,1
//            2
//
//    n=3
//            1,1,1
//            2,1
//            1,2
//
//    n=4 —> n(2)+2, n(3)+1     so total 5 ways
//1,1,2
//        2,2,&
//        1,1,1,1
//        2,1,1
//        1,2,1
//
//
//    n=5  == n(3)+2  and n(4)+1  total 8 ways
//
//    f(0) = 0
//    f(1) = 1
//    f(2) = 2
//
//    f(n) = f(n-1) + f(n-2)
//
//    This is just a play on fibonacci series  if they say even 3 steps is allowed
//    f(n) = f(n-1) + f(n-2) + f(n-3)
//
//    use recursion and dynamic programming to achieve this
}
