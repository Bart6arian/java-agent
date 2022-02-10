package com.practice.user;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String args, Instrumentation instrumentation) {
        AgentBuilder agentBuilder = new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.practice"))
                .transform((builder, typeDescription, classLoader, module) -> {
                    System.out.println("For class " + typeDescription);
                    return builder.visit(Advice.to(MethodMonitor.class).on(ElementMatchers.any()));
                });
        agentBuilder.installOn(instrumentation);
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        premain(args, instrumentation);
    }
}
