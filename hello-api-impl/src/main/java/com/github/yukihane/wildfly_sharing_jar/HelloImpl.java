package com.github.yukihane.wildfly_sharing_jar;

import javax.enterprise.context.Dependent;

@Dependent
public class HelloImpl implements Hello {

    @Override
    public String hello() {
        return "hello";
    }
}
