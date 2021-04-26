package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysContractDeptMapper;
import com.ruoyi.system.domain.SysContractDept;
import com.ruoyi.system.service.ISysContractDeptService;
import com.ruoyi.common.core.text.Convert;

/**
 * 合同分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-18
 */
@Service
public class SysContractDeptServiceImpl implements ISysContractDeptService 
{
    @Autowired
    private SysContractDeptMapper sysContractDeptMapper;

    /**
     * 查询合同分类
     * 
     * @param contractId 合同分类ID
     * @return 合同分类
     */
    @Override
    public SysContractDept selectSysContractDeptById(Long contractId)
    {
        return sysContractDeptMapper.selectSysContractDeptById(contractId);
    }

    /**
     * 查询合同分类列表
     * 
     * @param sysContractDept 合同分类
     * @return 合同分类
     */
    @Override
    public List<SysContractDept> selectSysContractDeptList(SysContractDept sysContractDept)
    {
        return sysContractDeptMapper.selectSysContractDeptList(sysContractDept);
    }

    /**
     * 新增合同分类
     * 
     * @param sysContractDept 合同分类
     * @return 结果
     */
    @Override
    public int insertSysContractDept(SysContractDept sysContractDept)
    {
        return sysContractDeptMapper.insertSysContractDept(sysContractDept);
    }

    /**
     * 修改合同分类
     * 
     * @param sysContractDept 合同分类
     * @return 结果
     */
    @Override
    public int updateSysContractDept(SysContractDept sysContractDept)
    {
        return sysContractDeptMapper.updateSysContractDept(sysContractDept);
    }

    /**
     * 删除合同分类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysContractDeptByIds(String ids)
    {
        return sysContractDeptMapper.deleteSysContractDeptByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除合同分类信息
     * 
     * @param contractId 合同分类ID
     * @return 结果
     */
    @Override
    public int deleteSysContractDeptById(Long contractId)
    {
        return sysContractDeptMapper.deleteSysContractDeptById(contractId);
    }

    /**
     * 查询合同分类树列表
     * 
     * @return 所有合同分类信息
     */
    @Override
    public List<Ztree> selectSysContractDeptTree()
    {
        List<SysContractDept> sysContractDeptList = sysContractDeptMapper.selectSysContractDeptList(new SysContractDept());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysContractDept sysContractDept : sysContractDeptList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysContractDept.getContractId());
            ztree.setpId(sysContractDept.getParentId());
            ztree.setName(sysContractDept.getContractDeptName());
            ztree.setTitle(sysContractDept.getContractDeptName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
