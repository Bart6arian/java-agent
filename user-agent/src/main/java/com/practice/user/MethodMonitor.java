package com.practice.user;

import net.bytebuddy.asm.Advice;

public class MethodMonitor {

    @Advice.OnMethodEnter
    public static void enter(@Advice.Origin Class theClazz, @Advice.Origin("#m") String nameOfMethod) {
        System.out.println("Entered method " + nameOfMethod);
    }

    @Advice.OnMethodExit
    public static void exit() {
        System.out.println("Method exited");
    }
}
