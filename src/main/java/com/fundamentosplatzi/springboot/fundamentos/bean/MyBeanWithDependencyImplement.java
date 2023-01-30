package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero=1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Print desde la clase MybeanWithDependencyImplement: Bean con Independencia");
    }
}
