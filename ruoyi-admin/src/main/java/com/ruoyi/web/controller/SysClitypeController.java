package com.ruoyi.web.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysClitype;
import com.ruoyi.system.service.ISysClitypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 客户类型Controller
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Controller
@RequestMapping("/system/clitype")
public class SysClitypeController extends BaseController
{
    private String prefix = "system/clitype";

    @Autowired
    private ISysClitypeService sysClitypeService;

    @RequiresPermissions("system:clitype:view")
    @GetMapping()
    public String clitype()
    {
        return prefix + "/clitype";
    }

    /**
     * 查询客户类型树列表
     */
    @RequiresPermissions("system:clitype:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysClitype> list(SysClitype sysClitype)
    {
        List<SysClitype> list = sysClitypeService.selectSysClitypeList(sysClitype);
        return list;
    }

    /**
     * 导出客户类型列表
     */
    @RequiresPermissions("system:clitype:export")
    @Log(title = "客户类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysClitype sysClitype)
    {
        List<SysClitype> list = sysClitypeService.selectSysClitypeList(sysClitype);
        ExcelUtil<SysClitype> util = new ExcelUtil<SysClitype>(SysClitype.class);
        return util.exportExcel(list, "clitype");
    }

    /**
     * 新增客户类型
     */
    @GetMapping(value = { "/add/{clitypeId}", "/add/" })
    public String add(@PathVariable(value = "clitypeId", required = false) Long clitypeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(clitypeId))
        {
            mmap.put("sysClitype", sysClitypeService.selectSysClitypeById(clitypeId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存客户类型
     */
    @RequiresPermissions("system:clitype:add")
    @Log(title = "客户类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysClitype sysClitype)
    {
        return toAjax(sysClitypeService.insertSysClitype(sysClitype));
    }

    /**
     * 修改客户类型
     */
    @GetMapping("/edit/{clitypeId}")
    public String edit(@PathVariable("clitypeId") Long clitypeId, ModelMap mmap)
    {
        SysClitype sysClitype = sysClitypeService.selectSysClitypeById(clitypeId);
        mmap.put("sysClitype", sysClitype);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户类型
     */
    @RequiresPermissions("system:clitype:edit")
    @Log(title = "客户类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysClitype sysClitype)
    {
        return toAjax(sysClitypeService.updateSysClitype(sysClitype));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:clitype:remove")
    @Log(title = "客户类型", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{clitypeId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("clitypeId") Long clitypeId)
    {
        return toAjax(sysClitypeService.deleteSysClitypeById(clitypeId));
    }

    /**
     * 选择客户类型树
     */
    @GetMapping(value = { "/selectClitypeTree/{clitypeId}", "/selectClitypeTree/" })
    public String selectClitypeTree(@PathVariable(value = "clitypeId", required = false) Long clitypeId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(clitypeId))
        {
            mmap.put("sysClitype", sysClitypeService.selectSysClitypeById(clitypeId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载客户类型树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysClitypeService.selectSysClitypeTree();
        return ztrees;
    }
}
