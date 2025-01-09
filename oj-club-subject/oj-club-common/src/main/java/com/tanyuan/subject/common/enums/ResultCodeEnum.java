package com.tanyuan.subject.common.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    FAIL(500,"失败"),
    SUCCESS(200,"成功");

    public int code;
    public String desc;

    ResultCodeEnum(int code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public static ResultCodeEnum getById(int codeVal){
        for(ResultCodeEnum resultCodeEnum:ResultCodeEnum.values()){
            if(resultCodeEnum.getCode()==codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }




}
