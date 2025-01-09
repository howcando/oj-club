package com.tanyuan.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.tanyuan.subject.common.enums.IsDeletedFlagEnum;
import com.tanyuan.subject.domain.convert.SubjectCategoryConverter;
import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.domain.service.SubjectCategoryDomainService;
import com.tanyuan.subject.infra.basic.entity.SubjectCategory;
import com.tanyuan.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBo subjectCategoryBo) {
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBo));
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    @Override
    public List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList=subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBo> boList = SubjectCategoryConverter.INSTANCE
                .convertToCategoryBO(subjectCategoryList);
        if(log.isInfoEnabled()){
            log.info("SubjectCategoryDomainServiceImpl.queryPrimaryCategory.boList:{}", JSON.toJSONString(boList));
        }

        return boList;
    }

    @Override
    public Boolean update(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        int count = subjectCategoryService.update(subjectCategory);
        return count>0;
    }

    @Override
    public Boolean delete(SubjectCategoryBo subjectCategoryBo) {
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBo);
        subjectCategory.setIsDeleted(IsDeletedFlagEnum.DELETED.getCode());
        int count = subjectCategoryService.update(subjectCategory);
        return count>0;
    }
}
