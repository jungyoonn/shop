package com.anymall.common;

import java.util.Scanner;
import java.util.function.Predicate;

public class Utils {
     static Scanner scan = new Scanner(System.in);

    // 입력 통합
    static <T> T next(String msg, Class<T> clazz) {
        System.out.println(msg);
        System.out.print("> ");
        String str = scan.nextLine();
        if (clazz == Integer.class) {
            return clazz.cast(Integer.parseInt(str));
        } else if (clazz == String.class) {
            return clazz.cast(str);
        } else {
            throw new RuntimeException("잘못된 타입");
        }
    }

    // 입력 반복
    public static <T> T next(String msg, Class<T> clazz, Predicate<T> con, String errMsg) {
        while (true) {
            try {
                T t = next(msg, clazz);
                if (con.test(t)) {
                    return t;
                } else {
                    throw new IllegalArgumentException(errMsg);
                }
            } catch (NumberFormatException e) {
                System.out.println("해당 입력 칸은 필수 입력이며 숫자만 입력할 수 있습니다.");
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
