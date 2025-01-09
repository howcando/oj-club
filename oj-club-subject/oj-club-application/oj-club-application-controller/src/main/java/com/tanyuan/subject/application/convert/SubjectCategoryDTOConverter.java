package com.tanyuan.subject.application.convert;

import com.tanyuan.subject.application.dto.SubjectCategoryDTO;
import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryDTOConverter {
    SubjectCategoryDTOConverter INSTANCE= Mappers.getMapper(SubjectCategoryDTOConverter.class);

    SubjectCategoryBo convertDTOToCategoryBo(SubjectCategoryDTO subjectCategoryDTO);

    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBo> list);

}
