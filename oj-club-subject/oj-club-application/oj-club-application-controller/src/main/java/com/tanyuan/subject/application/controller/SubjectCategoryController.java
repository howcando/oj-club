package com.tanyuan.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.tanyuan.subject.application.convert.SubjectCategoryDTOConverter;
import com.tanyuan.subject.application.dto.SubjectCategoryDTO;
import com.tanyuan.subject.common.entity.Result;
import com.tanyuan.subject.domain.entity.SubjectCategoryBo;
import com.tanyuan.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {

    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;


    /**
     * 新增分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.add.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(),"分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()),"分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类父类id不能为空");
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToCategoryBo(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBo);
            return Result.ok(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }

    }

    /**
     * 查询大分类
     * @return
     */
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToCategoryBo(subjectCategoryDTO);
            List<SubjectCategoryBo> subjectCategoryBoList = subjectCategoryDomainService.queryCategory(subjectCategoryBo);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategoryDTOList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }

    }

    /**
     * 查询大分类下面的小分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/queryCategoryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryCategoryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(),"分类id不能为空");

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToCategoryBo(subjectCategoryDTO);

            List<SubjectCategoryBo> subjectCategoryBoList = subjectCategoryDomainService.queryCategory(subjectCategoryBo);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategoryDTOList(subjectCategoryBoList);
            return Result.ok(subjectCategoryDTOList);
        } catch (Exception e) {
            log.error("SubjectCategoryController.queryCategoryByPrimary.error:{}",e.getMessage(),e);
            return Result.fail(e.getMessage());
        }

    }


    /**
     * 更新分类
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.queryCategoryByPrimary.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToCategoryBo(subjectCategoryDTO);

            Boolean result = subjectCategoryDomainService.update(subjectCategoryBo);

            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.update.error:{}",e.getMessage(),e);
            return Result.fail("更新失败");
        }
    }

    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO){
        try {
            if(log.isInfoEnabled()){
                log.info("SubjectCategoryController.delete.dto:{}",JSON.toJSONString(subjectCategoryDTO));
            }

            SubjectCategoryBo subjectCategoryBo = SubjectCategoryDTOConverter.INSTANCE
                    .convertDTOToCategoryBo(subjectCategoryDTO);

            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBo);

            return Result.ok(result);
        } catch (Exception e) {
            log.error("SubjectCategoryController.delete.error:{}",e.getMessage(),e);
            return Result.fail("更新失败");
        }
    }
}
