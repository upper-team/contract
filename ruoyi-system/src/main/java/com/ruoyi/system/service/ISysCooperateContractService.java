package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysCooperateContract;

/**
 * 合作合同管理Service接口
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public interface ISysCooperateContractService 
{
    /**
     * 查询合作合同管理
     * 
     * @param contractId 合作合同管理ID
     * @return 合作合同管理
     */
    public SysCooperateContract selectSysCooperateContractById(Long contractId);

    /**
     * 查询合作合同管理列表
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 合作合同管理集合
     */
    public List<SysCooperateContract> selectSysCooperateContractList(SysCooperateContract sysCooperateContract);

    /**
     * 新增合作合同管理
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 结果
     */
    public int insertSysCooperateContract(SysCooperateContract sysCooperateContract);

    /**
     * 修改合作合同管理
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 结果
     */
    public int updateSysCooperateContract(SysCooperateContract sysCooperateContract);

    /**
     * 批量删除合作合同管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysCooperateContractByIds(String ids);

    /**
     * 删除合作合同管理信息
     * 
     * @param contractId 合作合同管理ID
     * @return 结果
     */
    public int deleteSysCooperateContractById(Long contractId);
}
