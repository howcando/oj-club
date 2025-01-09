package com.tanyuan.subject.domain.service;

import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {

    /**
     * 新增分类
     * @param subjectCategoryBo
     */
    void add (SubjectCategoryBo subjectCategoryBo);

    /**
     * 查询分类
     * @param subjectCategoryBo
     * @return
     */
    List<SubjectCategoryBo> queryCategory(SubjectCategoryBo subjectCategoryBo);

    /**
     * 更新分类
     * @param subjectCategoryBo
     * @return
     */
    Boolean update(SubjectCategoryBo subjectCategoryBo);

    /**
     * 删除分类
     * @param subjectCategoryBo
     * @return
     */
    Boolean delete(SubjectCategoryBo subjectCategoryBo);
}
