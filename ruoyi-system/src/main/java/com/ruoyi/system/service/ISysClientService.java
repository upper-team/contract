package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SysClient;
import com.ruoyi.system.domain.SysPost;

/**
 * 客户档案Service接口
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
public interface ISysClientService 
{
    /**
     * 查询客户档案
     * 
     * @param clientId 客户档案ID
     * @return 客户档案
     */
    public SysClient selectSysClientById(Long clientId);

    /**
     * 查询客户档案列表
     * 
     * @param sysClient 客户档案
     * @return 客户档案集合
     */
    public List<SysClient> selectSysClientList(SysClient sysClient);

    /**
     * 新增客户档案
     * 
     * @param sysClient 客户档案
     * @return 结果
     */
    public int insertSysClient(SysClient sysClient);

    /**
     * 修改客户档案
     * 
     * @param sysClient 客户档案
     * @return 结果
     */
    public int updateSysClient(SysClient sysClient);

    /**
     * 批量删除客户档案
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClientByIds(String ids);

    /**
     * 删除客户档案信息
     * 
     * @param clientId 客户档案ID
     * @return 结果
     */
    public int deleteSysClientById(Long clientId);

    public List<SysClient> selectSysClientAll();
}
