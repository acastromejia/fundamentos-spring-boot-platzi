package com.fundamentosplatzi.springboot.fundamentos.component;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Print desde ComponentImplements");
    }
}
