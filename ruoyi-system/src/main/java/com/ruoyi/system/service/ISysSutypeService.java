package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.SysSutype;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 供应商分类Service接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface ISysSutypeService 
{
    /**
     * 查询供应商分类
     * 
     * @param sutypeId 供应商分类ID
     * @return 供应商分类
     */
    public SysSutype selectSysSutypeById(Long sutypeId);

    /**
     * 查询供应商分类列表
     * 
     * @param sysSutype 供应商分类
     * @return 供应商分类集合
     */
    public List<SysSutype> selectSysSutypeList(SysSutype sysSutype);






    public List<Ztree> selectSutypeTreeExcludeChild(SysSutype type);

    public int updateSutype(SysSutype sutype);




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
     * 批量删除供应商分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysSutypeByIds(String ids);

    /**
     * 删除供应商分类信息
     * 
     * @param sutypeId 供应商分类ID
     * @return 结果
     */
    public int deleteSysSutypeById(Long sutypeId);

    /**
     * 查询供应商分类树列表
     * 
     * @return 所有供应商分类信息
     */
    public List<Ztree> selectSysSutypeTree();
}
