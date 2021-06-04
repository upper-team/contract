package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClientMapper;
import com.ruoyi.system.domain.SysClient;
import com.ruoyi.system.service.ISysClientService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户档案Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Service
public class SysClientServiceImpl implements ISysClientService 
{
    @Autowired
    private SysClientMapper sysClientMapper;

    /**
     * 查询客户档案
     * 
     * @param clientId 客户档案ID
     * @return 客户档案
     */
    @Override
    public SysClient selectSysClientById(Long clientId)
    {
        return sysClientMapper.selectSysClientById(clientId);
    }

    /**
     * 查询客户档案列表
     * 
     * @param sysClient 客户档案
     * @return 客户档案
     */
    @Override
    public List<SysClient> selectSysClientList(SysClient sysClient)
    {
        return sysClientMapper.selectSysClientList(sysClient);
    }

    /**
     * 新增客户档案
     * 
     * @param sysClient 客户档案
     * @return 结果
     */
    @Override
    public int insertSysClient(SysClient sysClient)
    {
        return sysClientMapper.insertSysClient(sysClient);
    }

    /**
     * 修改客户档案
     * 
     * @param sysClient 客户档案
     * @return 结果
     */
    @Override
    public int updateSysClient(SysClient sysClient)
    {
        return sysClientMapper.updateSysClient(sysClient);
    }

    /**
     * 删除客户档案对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysClientByIds(String ids)
    {
        return sysClientMapper.deleteSysClientByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户档案信息
     * 
     * @param clientId 客户档案ID
     * @return 结果
     */
    @Override
    public int deleteSysClientById(Long clientId)
    {
        return sysClientMapper.deleteSysClientById(clientId);
    }

    @Override
    public List<SysClient> selectSysClientAll(){
        return sysClientMapper.selectSysClientAll();
    }


}
