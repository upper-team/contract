package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SysClitypeMapper;
import com.ruoyi.system.domain.SysClitype;
import com.ruoyi.system.service.ISysClitypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Service
public class SysClitypeServiceImpl implements ISysClitypeService 
{
    @Autowired
    private SysClitypeMapper sysClitypeMapper;

    /**
     * 查询客户类型
     * 
     * @param clitypeId 客户类型ID
     * @return 客户类型
     */
    @Override
    public SysClitype selectSysClitypeById(Long clitypeId)
    {
        return sysClitypeMapper.selectSysClitypeById(clitypeId);
    }

    /**
     * 查询客户类型列表
     * 
     * @param sysClitype 客户类型
     * @return 客户类型
     */
    @Override
    public List<SysClitype> selectSysClitypeList(SysClitype sysClitype)
    {
        return sysClitypeMapper.selectSysClitypeList(sysClitype);
    }

    /**
     * 新增客户类型
     * 
     * @param sysClitype 客户类型
     * @return 结果
     */
    @Override
    public int insertSysClitype(SysClitype sysClitype)
    {
        SysClitype info = sysClitypeMapper.selectSysClitypeById(sysClitype.getParentId());
        sysClitype.setAncestors(info.getAncestors() + "," + sysClitype.getParentId());
        return sysClitypeMapper.insertSysClitype(sysClitype);
    }

    /**
     * 修改客户类型
     * 
     * @param sysClitype 客户类型
     * @return 结果
     */
    @Override
    public int updateSysClitype(SysClitype sysClitype)
    {
        SysClitype newParentClitype = sysClitypeMapper.selectSysClitypeById(sysClitype.getParentId());
        SysClitype oldClitype = selectSysClitypeById(sysClitype.getClitypeId());
        if (StringUtils.isNotNull(newParentClitype) && StringUtils.isNotNull(oldClitype))
        {
            String newAncestors = newParentClitype.getAncestors() + "," + newParentClitype.getClitypeId();
            String oldAncestors = oldClitype.getAncestors();
            sysClitype.setAncestors(newAncestors);
            updateClitypeChildren(sysClitype.getClitypeId(), newAncestors, oldAncestors);
        }
        return sysClitypeMapper.updateSysClitype(sysClitype);
    }

    public void updateClitypeChildren(Long clitypeId, String newAncestors, String oldAncestors)
    {
        List<SysClitype> children = sysClitypeMapper.selectChildrenClitypeById(clitypeId);
        for (SysClitype child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            sysClitypeMapper.updateClitypeChildren(children);
        }
    }

    /**
     * 删除客户类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysClitypeByIds(String ids)
    {
        return sysClitypeMapper.deleteSysClitypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户类型信息
     * 
     * @param clitypeId 客户类型ID
     * @return 结果
     */
    @Override
    public int deleteSysClitypeById(Long clitypeId)
    {
        return sysClitypeMapper.deleteSysClitypeById(clitypeId);
    }

    /**
     * 查询客户类型树列表
     * 
     * @return 所有客户类型信息
     */
    @Override
    public List<Ztree> selectSysClitypeTree()
    {
        List<SysClitype> sysClitypeList = sysClitypeMapper.selectSysClitypeList(new SysClitype());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (SysClitype sysClitype : sysClitypeList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(sysClitype.getClitypeId());
            ztree.setpId(sysClitype.getParentId());
            ztree.setName(sysClitype.getClitypeName());
            ztree.setTitle(sysClitype.getClitypeName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
