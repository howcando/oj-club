package com.tanyuan.subject.common.enums;

import lombok.Getter;


/**
 * 删除状态枚举
 */
@Getter
public enum CategoryTypeEnum {

    PRIMARY(1,"岗位大类"),
    SECOND(2,"二级分类");

    public int code;
    public String desc;

    CategoryTypeEnum(int code, String desc){
        this.code=code;
        this.desc=desc;
    }

    public static CategoryTypeEnum getById(int codeVal){
        for(CategoryTypeEnum resultCodeEnum: CategoryTypeEnum.values()){
            if(resultCodeEnum.getCode()==codeVal) {
                return resultCodeEnum;
            }
        }
        return null;
    }




}
