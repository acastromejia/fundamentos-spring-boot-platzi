package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Hemos Ingresado al metodo printWithDependency");
        int numero=1;
        LOGGER.debug("el numero enviado como Parametro a la dependencia Operacion es: " + numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Print desde la clase MybeanWithDependencyImplement: Bean con Independencia");
    }
}
