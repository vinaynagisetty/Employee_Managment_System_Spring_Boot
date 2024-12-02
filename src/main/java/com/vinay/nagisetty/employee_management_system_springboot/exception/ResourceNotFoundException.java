package com.vinay.nagisetty.employee_management_system_springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String filedname;
    private Object filedvalue;

    public ResourceNotFoundException(String resourceName, String filedname, Object filedvalue) {
        super(String.format("%s  not found  with %s : '%s'",resourceName,filedname,filedvalue));
        this.resourceName = resourceName;
        this.filedname = filedname;
        this.filedvalue = filedvalue;
    }

    public String getFiledname() {
        return filedname;
    }

    public Object getFiledvalue() {
        return filedvalue;
    }

    public String getResourceName() {
        return resourceName;
    }
}
