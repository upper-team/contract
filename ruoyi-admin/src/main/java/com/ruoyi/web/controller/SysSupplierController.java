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
import com.ruoyi.system.domain.SysSupplier;
import com.ruoyi.system.service.ISysSupplierService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 供应商档案Controller
 * 
 * @author ruoyi
 * @date 2021-04-24
 */
@Controller
@RequestMapping("/system/supplier")
public class SysSupplierController extends BaseController
{
    private String prefix = "system/supplier";

    @Autowired
    private ISysSupplierService sysSupplierService;

    @RequiresPermissions("system:supplier:view")
    @GetMapping()
    public String supplier()
    {
        return prefix + "/supplier";
    }

    /**
     * 查询供应商档案列表
     */
    @RequiresPermissions("system:supplier:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysSupplier sysSupplier)
    {
        startPage();
        List<SysSupplier> list = sysSupplierService.selectSysSupplierList(sysSupplier);
        return getDataTable(list);
    }

    /**
     * 导出供应商档案列表
     */
    @RequiresPermissions("system:supplier:export")
    @Log(title = "供应商档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysSupplier sysSupplier)
    {
        List<SysSupplier> list = sysSupplierService.selectSysSupplierList(sysSupplier);
        ExcelUtil<SysSupplier> util = new ExcelUtil<SysSupplier>(SysSupplier.class);
        return util.exportExcel(list, "supplier");
    }

    /**
     * 新增供应商档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存供应商档案
     */
    @RequiresPermissions("system:supplier:add")
    @Log(title = "供应商档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysSupplier sysSupplier)
    {
        return toAjax(sysSupplierService.insertSysSupplier(sysSupplier));
    }

    /**
     * 修改供应商档案
     */
    @GetMapping("/edit/{supplierId}")
    public String edit(@PathVariable("supplierId") Long supplierId, ModelMap mmap)
    {
        SysSupplier sysSupplier = sysSupplierService.selectSysSupplierById(supplierId);
        mmap.put("sysSupplier", sysSupplier);
        return prefix + "/edit";
    }

    /**
     * 修改保存供应商档案
     */
    @RequiresPermissions("system:supplier:edit")
    @Log(title = "供应商档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysSupplier sysSupplier)
    {
        return toAjax(sysSupplierService.updateSysSupplier(sysSupplier));
    }

    /**
     * 删除供应商档案
     */
    @RequiresPermissions("system:supplier:remove")
    @Log(title = "供应商档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysSupplierService.deleteSysSupplierByIds(ids));
    }
}
