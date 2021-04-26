package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.system.domain.SysClitype;
import org.apache.ibatis.annotations.Param;

/**
 * 客户类型Mapper接口
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
public interface SysClitypeMapper 
{
    /**
     * 查询客户类型
     * 
     * @param clitypeId 客户类型ID
     * @return 客户类型
     */
    public SysClitype selectSysClitypeById(Long clitypeId);

    /**
     * 查询客户类型列表
     * 
     * @param sysClitype 客户类型
     * @return 客户类型集合
     */
    public List<SysClitype> selectSysClitypeList(SysClitype sysClitype);

    /**
     * 新增客户类型
     * 
     * @param sysClitype 客户类型
     * @return 结果
     */
    public int insertSysClitype(SysClitype sysClitype);

    /**
     * 修改客户类型
     * 
     * @param sysClitype 客户类型
     * @return 结果
     */
    public int updateSysClitype(SysClitype sysClitype);

    /**
     * 删除客户类型
     * 
     * @param clitypeId 客户类型ID
     * @return 结果
     */
    public int deleteSysClitypeById(Long clitypeId);

    /**
     * 批量删除客户类型
     * 
     * @param clitypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClitypeByIds(String[] clitypeIds);

    public List<SysClitype> selectChildrenClitypeById(Long clitypeId);

    public int updateClitypeChildren(@Param("clitypes") List<SysClitype> clitypes);


}
