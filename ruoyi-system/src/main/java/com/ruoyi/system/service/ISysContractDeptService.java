package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysContractDept;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 合同分类Service接口
 * 
 * @author ruoyi
 * @date 2021-04-18
 */
public interface ISysContractDeptService 
{
    /**
     * 查询合同分类
     * 
     * @param contractId 合同分类ID
     * @return 合同分类
     */
    public SysContractDept selectSysContractDeptById(Long contractId);

    /**
     * 查询合同分类列表
     * 
     * @param sysContractDept 合同分类
     * @return 合同分类集合
     */
    public List<SysContractDept> selectSysContractDeptList(SysContractDept sysContractDept);

    /**
     * 新增合同分类
     * 
     * @param sysContractDept 合同分类
     * @return 结果
     */
    public int insertSysContractDept(SysContractDept sysContractDept);

    /**
     * 修改合同分类
     * 
     * @param sysContractDept 合同分类
     * @return 结果
     */
    public int updateSysContractDept(SysContractDept sysContractDept);

    /**
     * 批量删除合同分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysContractDeptByIds(String ids);

    /**
     * 删除合同分类信息
     * 
     * @param contractId 合同分类ID
     * @return 结果
     */
    public int deleteSysContractDeptById(Long contractId);

    /**
     * 查询合同分类树列表
     * 
     * @return 所有合同分类信息
     */
    public List<Ztree> selectSysContractDeptTree();
}
