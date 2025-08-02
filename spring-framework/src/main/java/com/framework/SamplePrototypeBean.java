package com.framework;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "prototype")
@Getter
@Setter
@NoArgsConstructor
@Component
public class SamplePrototypeBean {
    private String id;
    private String name;
}
