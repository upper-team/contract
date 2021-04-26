package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysCooperateContractMapper;
import com.ruoyi.system.domain.SysCooperateContract;
import com.ruoyi.system.service.ISysCooperateContractService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合作合同管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Service
public class SysCooperateContractServiceImpl implements ISysCooperateContractService 
{
    @Autowired
    private SysCooperateContractMapper sysCooperateContractMapper;

    /**
     * 查询合作合同管理
     * 
     * @param contractId 合作合同管理ID
     * @return 合作合同管理
     */
    @Override
    public SysCooperateContract selectSysCooperateContractById(Long contractId)
    {
        return sysCooperateContractMapper.selectSysCooperateContractById(contractId);
    }

    /**
     * 查询合作合同管理列表
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 合作合同管理
     */
    @Override
    public List<SysCooperateContract> selectSysCooperateContractList(SysCooperateContract sysCooperateContract)
    {
        return sysCooperateContractMapper.selectSysCooperateContractList(sysCooperateContract);
    }

    /**
     * 新增合作合同管理
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 结果
     */
    @Override
    public int insertSysCooperateContract(SysCooperateContract sysCooperateContract)
    {
        return sysCooperateContractMapper.insertSysCooperateContract(sysCooperateContract);
    }

    /**
     * 修改合作合同管理
     * 
     * @param sysCooperateContract 合作合同管理
     * @return 结果
     */
    @Override
    public int updateSysCooperateContract(SysCooperateContract sysCooperateContract)
    {
        return sysCooperateContractMapper.updateSysCooperateContract(sysCooperateContract);
    }

    /**
     * 删除合作合同管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysCooperateContractByIds(String ids)
    {
        return sysCooperateContractMapper.deleteSysCooperateContractByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合作合同管理信息
     * 
     * @param contractId 合作合同管理ID
     * @return 结果
     */
    @Override
    public int deleteSysCooperateContractById(Long contractId)
    {
        return sysCooperateContractMapper.deleteSysCooperateContractById(contractId);
    }
}
