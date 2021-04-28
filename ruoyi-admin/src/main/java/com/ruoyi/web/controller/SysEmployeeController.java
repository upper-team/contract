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
import com.ruoyi.system.domain.SysEmployee;
import com.ruoyi.system.service.ISysEmployeeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工档案Controller
 * 
 * @author ruoyi
 * @date 2021-04-19
 */
@Controller
@RequestMapping("/system/employee")
public class SysEmployeeController extends BaseController
{
    private String prefix = "system/employee";

    @Autowired
    private ISysEmployeeService sysEmployeeService;

    @RequiresPermissions("system:employee:view")
    @GetMapping()
    public String employee()
    {
        return prefix + "/employee";
    }

    /**
     * 查询员工档案列表
     */
    @RequiresPermissions("system:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysEmployee sysEmployee)
    {
        startPage();
        List<SysEmployee> list = sysEmployeeService.selectSysEmployeeList(sysEmployee);
        return getDataTable(list);
    }

    /**
     * 导出员工档案列表
     */
    @RequiresPermissions("system:employee:export")
    @Log(title = "员工档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysEmployee sysEmployee)
    {
        List<SysEmployee> list = sysEmployeeService.selectSysEmployeeList(sysEmployee);
        ExcelUtil<SysEmployee> util = new ExcelUtil<SysEmployee>(SysEmployee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存员工档案
     */
    @RequiresPermissions("system:employee:add")
    @Log(title = "员工档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysEmployee sysEmployee)
    {
        return toAjax(sysEmployeeService.insertSysEmployee(sysEmployee));
    }

    /**
     * 修改员工档案
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Long employeeId, ModelMap mmap)
    {
        SysEmployee sysEmployee = sysEmployeeService.selectSysEmployeeById(employeeId);
        mmap.put("sysEmployee", sysEmployee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工档案
     */
    @RequiresPermissions("system:employee:edit")
    @Log(title = "员工档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysEmployee sysEmployee)
    {
        return toAjax(sysEmployeeService.updateSysEmployee(sysEmployee));
    }

    /**
     * 删除员工档案
     */
    @RequiresPermissions("system:employee:remove")
    @Log(title = "员工档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysEmployeeService.deleteSysEmployeeByIds(ids));
    }
}
