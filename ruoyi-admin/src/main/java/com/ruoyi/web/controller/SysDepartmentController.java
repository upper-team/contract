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
import com.ruoyi.system.domain.SysDepartment;
import com.ruoyi.system.service.ISysDepartmentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 部门档案Controller
 * 
 * @author ruoyi
 * @date 2021-04-21
 */
@Controller
@RequestMapping("/system/department")
public class SysDepartmentController extends BaseController
{
    private String prefix = "system/department";

    @Autowired
    private ISysDepartmentService sysDepartmentService;

    @RequiresPermissions("system:department:view")
    @GetMapping()
    public String department()
    {
        return prefix + "/department";
    }

    /**
     * 查询部门档案树列表
     */
    @RequiresPermissions("system:department:list")
    @PostMapping("/list")
    @ResponseBody
    public List<SysDepartment> list(SysDepartment sysDepartment)
    {
        List<SysDepartment> list = sysDepartmentService.selectSysDepartmentList(sysDepartment);
        return list;
    }

    /**
     * 导出部门档案列表
     */
    @RequiresPermissions("system:department:export")
    @Log(title = "部门档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysDepartment sysDepartment)
    {
        List<SysDepartment> list = sysDepartmentService.selectSysDepartmentList(sysDepartment);
        ExcelUtil<SysDepartment> util = new ExcelUtil<SysDepartment>(SysDepartment.class);
        return util.exportExcel(list, "department");
    }

    /**
     * 新增部门档案
     */
    @GetMapping(value = { "/add/{departmentId}", "/add/" })
    public String add(@PathVariable(value = "departmentId", required = false) Long departmentId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(departmentId))
        {
            mmap.put("sysDepartment", sysDepartmentService.selectSysDepartmentById(departmentId));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存部门档案
     */
    @RequiresPermissions("system:department:add")
    @Log(title = "部门档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDepartment sysDepartment)
    {
        return toAjax(sysDepartmentService.insertSysDepartment(sysDepartment));
    }

    /**
     * 修改部门档案
     */
    @GetMapping("/edit/{departmentId}")
    public String edit(@PathVariable("departmentId") Long departmentId, ModelMap mmap)
    {
        SysDepartment sysDepartment = sysDepartmentService.selectSysDepartmentById(departmentId);
        mmap.put("sysDepartment", sysDepartment);
        return prefix + "/edit";
    }

    /**
     * 修改保存部门档案
     */
    @RequiresPermissions("system:department:edit")
    @Log(title = "部门档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDepartment sysDepartment)
    {
        return toAjax(sysDepartmentService.updateSysDepartment(sysDepartment));
    }

    /**
     * 删除
     */
    @RequiresPermissions("system:department:remove")
    @Log(title = "部门档案", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{departmentId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("departmentId") Long departmentId)
    {
        return toAjax(sysDepartmentService.deleteSysDepartmentById(departmentId));
    }

    /**
     * 选择部门档案树
     */
    @GetMapping(value = { "/selectDepartmentTree/{departmentId}", "/selectDepartmentTree/" })
    public String selectDepartmentTree(@PathVariable(value = "departmentId", required = false) Long departmentId, ModelMap mmap)
    {
        if (StringUtils.isNotNull(departmentId))
        {
            mmap.put("sysDepartment", sysDepartmentService.selectSysDepartmentById(departmentId));
        }
        return prefix + "/tree";
    }

    /**
     * 加载部门档案树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = sysDepartmentService.selectSysDepartmentTree();
        return ztrees;
    }
}
