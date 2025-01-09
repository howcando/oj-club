package com.tanyuan.subject.domain.convert;

import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.infra.basic.entity.SubjectCategory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-08T23:43:04+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
public class SubjectCategoryConverterImpl implements SubjectCategoryConverter {

    @Override
    public SubjectCategory convertBoToCategory(SubjectCategoryBo subjectCategoryBo) {
        if ( subjectCategoryBo == null ) {
            return null;
        }

        SubjectCategory subjectCategory = new SubjectCategory();

        subjectCategory.setId( subjectCategoryBo.getId() );
        subjectCategory.setCategoryName( subjectCategoryBo.getCategoryName() );
        subjectCategory.setCategoryType( subjectCategoryBo.getCategoryType() );
        subjectCategory.setImageUrl( subjectCategoryBo.getImageUrl() );
        subjectCategory.setParentId( subjectCategoryBo.getParentId() );

        return subjectCategory;
    }

    @Override
    public List<SubjectCategoryBo> convertToCategoryBO(List<SubjectCategory> list) {
        if ( list == null ) {
            return null;
        }

        List<SubjectCategoryBo> list1 = new ArrayList<SubjectCategoryBo>( list.size() );
        for ( SubjectCategory subjectCategory : list ) {
            list1.add( subjectCategoryToSubjectCategoryBo( subjectCategory ) );
        }

        return list1;
    }

    protected SubjectCategoryBo subjectCategoryToSubjectCategoryBo(SubjectCategory subjectCategory) {
        if ( subjectCategory == null ) {
            return null;
        }

        SubjectCategoryBo subjectCategoryBo = new SubjectCategoryBo();

        subjectCategoryBo.setId( subjectCategory.getId() );
        subjectCategoryBo.setCategoryName( subjectCategory.getCategoryName() );
        subjectCategoryBo.setCategoryType( subjectCategory.getCategoryType() );
        subjectCategoryBo.setImageUrl( subjectCategory.getImageUrl() );
        subjectCategoryBo.setParentId( subjectCategory.getParentId() );

        return subjectCategoryBo;
    }
}
