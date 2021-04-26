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
import com.ruoyi.system.domain.SysClient;
import com.ruoyi.system.service.ISysClientService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户档案Controller
 * 
 * @author ruoyi
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/client")
public class SysClientController extends BaseController
{
    private String prefix = "system/client";

    @Autowired
    private ISysClientService sysClientService;

    @RequiresPermissions("system:client:view")
    @GetMapping()
    public String client()
    {
        return prefix + "/client";
    }

    /**
     * 查询客户档案列表
     */
    @RequiresPermissions("system:client:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysClient sysClient)
    {
        startPage();
        List<SysClient> list = sysClientService.selectSysClientList(sysClient);
        return getDataTable(list);
    }

    /**
     * 导出客户档案列表
     */
    @RequiresPermissions("system:client:export")
    @Log(title = "客户档案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysClient sysClient)
    {
        List<SysClient> list = sysClientService.selectSysClientList(sysClient);
        ExcelUtil<SysClient> util = new ExcelUtil<SysClient>(SysClient.class);
        return util.exportExcel(list, "client");
    }

    /**
     * 新增客户档案
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户档案
     */
    @RequiresPermissions("system:client:add")
    @Log(title = "客户档案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysClient sysClient)
    {
        return toAjax(sysClientService.insertSysClient(sysClient));
    }

    /**
     * 修改客户档案
     */
    @GetMapping("/edit/{clientId}")
    public String edit(@PathVariable("clientId") Long clientId, ModelMap mmap)
    {
        SysClient sysClient = sysClientService.selectSysClientById(clientId);
        mmap.put("sysClient", sysClient);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户档案
     */
    @RequiresPermissions("system:client:edit")
    @Log(title = "客户档案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysClient sysClient)
    {
        return toAjax(sysClientService.updateSysClient(sysClient));
    }

    /**
     * 删除客户档案
     */
    @RequiresPermissions("system:client:remove")
    @Log(title = "客户档案", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysClientService.deleteSysClientByIds(ids));
    }
}
