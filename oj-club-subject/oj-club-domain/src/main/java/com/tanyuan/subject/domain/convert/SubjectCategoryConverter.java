package com.tanyuan.subject.domain.convert;

import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {
    SubjectCategoryConverter INSTANCE= Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBo subjectCategoryBo);

    List<SubjectCategoryBo> convertToCategoryBO(List<SubjectCategory> list);
}
