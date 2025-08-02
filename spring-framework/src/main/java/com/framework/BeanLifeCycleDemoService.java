package com.framework;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanLifeCycleDemoService {

    @Autowired
    private ObjectProvider<SamplePrototypeBean> prototypeBeanProvider;

    @Autowired
    private ObjectProvider<SampleSingletonBean> singletonBeanObjectProvider;


    @Autowired
    private SampleSingletonBean sbean1;

    @Autowired
    private SampleSingletonBean sbean2;


    @PostConstruct
    @PreDestroy
    public void checkBeans() {
        SamplePrototypeBean bean1 = prototypeBeanProvider.getObject();
        SamplePrototypeBean bean2 = prototypeBeanProvider.getObject();

        System.out.println("Prototype bean1: " + bean1);
        System.out.println("Prototype bean2: " + bean2);
        System.out.println("Are prototype beans same? " + (bean1 == bean2)); // false

        System.out.println("Singleton bean1: " + sbean1);
        System.out.println("Singleton bean2: " + sbean2);
        System.out.println("Singleton bean3: " + singletonBeanObjectProvider.getObject());
        System.out.println("Are singleton beans same? " + (sbean1 == sbean2) + " " + (sbean1 == singletonBeanObjectProvider.getObject())); // true
    }
}
