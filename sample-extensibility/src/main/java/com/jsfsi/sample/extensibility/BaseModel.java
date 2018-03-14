package com.jsfsi.sample.extensibility;

import java.io.Serializable;

public abstract class BaseModel  implements Serializable {
    private String resolvePropertyGetter(String property){
        String getter = String.format("get%s",property.substring(0,1).toUpperCase());
        if(property.length() > 1){
            getter += property.substring(1,property.length());
        }
        return getter;
    }
}
