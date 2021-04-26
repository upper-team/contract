package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.SysSutype;
import org.apache.ibatis.annotations.Param;

/**
 * 供应商分类Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface SysSutypeMapper 
{
    /**
     * 查询供应商分类
     * 
     * @param sutypeId 供应商分类ID
     * @return 供应商分类
     */
    public SysSutype selectSysSutypeById(Long sutypeId);

    public int selectNormalChildrenSutypeById(Long sutypeId);


    /**
     * 修改子元素关系
     *
     * @param depts 子元素
     * @return 结果
     */
    public int updateSutypeChildren(@Param("depts") List<SysSutype> depts);

    public List<SysSutype> selectChildrenSutypeById(Long sutypeId);

    /**
     * 查询供应商分类列表
     * 
     * @param sysSutype 供应商分类
     * @return 供应商分类集合
     */
    public List<SysSutype> selectSysSutypeList(SysSutype sysSutype);

    /**
     * 新增供应商分类
     * 
     * @param sysSutype 供应商分类
     * @return 结果
     */
    public int insertSysSutype(SysSutype sysSutype);

    /**
     * 修改供应商分类
     * 
     * @param sysSutype 供应商分类
     * @return 结果
     */
    public int updateSysSutype(SysSutype sysSutype);

    /**
     * 删除供应商分类
     * 
     * @param sutypeId 供应商分类ID
     * @return 结果
     */
    public int deleteSysSutypeById(Long sutypeId);

    /**
     * 批量删除供应商分类
     * 
     * @param sutypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSutypeByIds(String[] sutypeIds);
}
