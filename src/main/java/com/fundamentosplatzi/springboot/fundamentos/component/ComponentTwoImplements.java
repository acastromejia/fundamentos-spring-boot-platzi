package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplements implements ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Saludo desde el TwoComponents");
    }
}
