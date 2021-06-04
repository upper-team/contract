package com.ruoyi.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.SysClient;
import com.ruoyi.system.domain.SysEmployee;
import com.ruoyi.system.domain.SysProduct;
import com.ruoyi.system.mapper.SysEmployeeMapper;
import com.ruoyi.system.service.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.SysContractCollection;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 收款合同Controller
 * 
 * @author ruoyi
 * @date 2021-05-03
 */
@Controller
@RequestMapping("/system/contract_collection")
public class SysContractCollectionController extends BaseController
{
    private String prefix = "system/contract_collection";

    @Autowired
    private ISysClientService clientService;


    @Autowired
    private ISysProductService productService;

    @Autowired
    private ISysEmployeeService employeeService;

    @Autowired
    private ISysContractCollectionService sysContractCollectionService;

    @RequiresPermissions("system:contract_collection:view")
    @GetMapping()
    public String contract_collection()
    {
        return prefix + "/contract_collection";
    }

    /**
     * 查询收款合同列表
     */
    @RequiresPermissions("system:contract_collection:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysContractCollection sysContractCollection)
    {
        startPage();
        List<SysContractCollection> list = sysContractCollectionService.selectSysContractCollectionList(sysContractCollection);
        return getDataTable(list);
    }

    /**
     * 导出收款合同列表
     */
    @RequiresPermissions("system:contract_collection:export")
    @Log(title = "收款合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysContractCollection sysContractCollection)
    {
        List<SysContractCollection> list = sysContractCollectionService.selectSysContractCollectionList(sysContractCollection);
        ExcelUtil<SysContractCollection> util = new ExcelUtil<SysContractCollection>(SysContractCollection.class);
        return util.exportExcel(list, "contract_collection");
    }

    /**
     * 新增收款合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<SysProduct> productList = productService.selectSysProductAll();
        List<SysClient> clientList = clientService.selectSysClientAll();
        List<SysEmployee> employeeList = employeeService.selectSysEmployeeAll();
        mmap.put("clients", clientList);
        mmap.put("products", productList);
        mmap.put("employees", employeeList);
        return prefix + "/add";
    }

    /**
     * 新增保存收款合同
     */
    @RequiresPermissions("system:contract_collection:add")
    @Log(title = "收款合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysContractCollection sysContractCollection, MultipartFile file)
    {

        String scanningCopy = sysContractCollectionService.uploadFile(sysContractCollection, file);
        sysContractCollection.setScanningCopy(scanningCopy);
//        if(scanningCopy.equals("")){

//        }else{
//            sysContractCollection.setScanningCopy(scanningCopy);
//        }

        return toAjax(sysContractCollectionService.insertSysContractCollection(sysContractCollection));
    }

    /**
     * 修改收款合同
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysContractCollection sysContractCollection = sysContractCollectionService.selectSysContractCollectionById(contractId);
        mmap.put("sysContractCollection", sysContractCollection);
        List<SysProduct> productList = productService.selectSysProductAll();
        List<SysClient> clientList = clientService.selectSysClientAll();
        List<SysEmployee> employeeList = employeeService.selectSysEmployeeAll();
        mmap.put("clients", clientList);
        mmap.put("products", productList);
        mmap.put("employees", employeeList);

        return prefix + "/edit";
    }

    /**
     * 修改保存收款合同
     */
    @RequiresPermissions("system:contract_collection:edit")
    @Log(title = "收款合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysContractCollection sysContractCollection)
    {
        return toAjax(sysContractCollectionService.updateSysContractCollection(sysContractCollection));
    }

    /**
     * 删除收款合同
     */
    @RequiresPermissions("system:contract_collection:remove")
    @Log(title = "收款合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysContractCollectionService.deleteSysContractCollectionByIds(ids));
    }

    /**
     * 下载pdf
     */
    @RequiresPermissions("system:contract_collection:downPDF")
    @PostMapping("/downPDF")
    @ResponseBody
    public AjaxResult downPDF(String ids){
        SysContractCollection SysContractCollection = new SysContractCollection();
        SysContractCollection.setIdArr(Convert.toStrArray(ids));
        List<SysContractCollection> SysContractCollectionList = sysContractCollectionService.selectSysContractCollectionList(SysContractCollection);
        for(SysContractCollection SysContractCollection1 : SysContractCollectionList){
//            String id = SysContractCollection1.getIdArr();

            String pdfUrl = SysContractCollection1.getScanningCopy();//拿到pdf存储路径
            return AjaxResult.success(pdfUrl);
        }
        return AjaxResult.success("下载完毕");
    }



//    @RequiresPermissions("system:contract_collection:addFile")
//    @PostMapping("/addFile")
//    @ResponseBody
//    public AjaxResult insert(HttpServletRequest request,
//                             HttpServletResponse response,
//                             @RequestParam("file") MultipartFile[] file) throws Exception {
//
//        String id = request.getParameter("id");//当需对
//        logger.info("获取选中数据主键：{}", id);
//
//        if (file != null && file.length > 0) {
//            List<String> fileName = new ArrayList<String>();
//            // 上传文件路径
//            String filePath = RuoYiConfig.getUploadPath();
//            try {
//                for (int i = 0; i < file.length; i++) {
//                    if (!file[i].isEmpty()) {
//                        //上传文件
//                        fileName.add(uploadImage(request, filePath, file[i], false));
//                    }
//                }
//                //上传成功
//                if (fileName != null && fileName.size() > 0) {
//                    return AjaxResult.success("上传成功！");
//                } else {
//                    return AjaxResult.error("上传失败！文件格式错误！");
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                return AjaxResult.error("上传出现异常！");
//            }
//        } else {
//            return AjaxResult.error("未检测到文件！");
//        }
//    }

//    /**
//     * 上传文件
//     * 原名称
//     *
//     * @param request      请求
//     * @param path_deposit 存放位置(路径)
//     * @param file         文件
//     * @param isRandomName 是否随机名称
//     * @return 完整文件路径
//     */
//    public String uploadImage(HttpServletRequest request, String path_deposit, MultipartFile file, boolean isRandomName) {
//        try {
//            if (file != null) {
//                String origName = file.getOriginalFilename();// 文件原名称
//                System.out.println("上传的文件原名称:" + origName);
//                //路径+文件名称
//                String fileSrc = "";
//                //是否随机名称
////                if (isRandomName) {
////                    origName = DateUtil.today() + UUID.randomUUID().toString() + origName.substring(origName.lastIndexOf("."));
////                }
//                // 上传并返回新文件名称
//                String fileNameNew = FileUploadUtils.upload(path_deposit, file);
//                logger.info("新文件名称：{}", fileNameNew);
//                //判断是否存在目录
////                        File targetFile = new File(path, origName);
////                        if (!targetFile.exists()) {
////                            targetFile.mkdirs();//创建目录
////                        }
////                        //上传
////                        file.transferTo(targetFile);
//                //完整路径
//                fileSrc = request.getContextPath() + path_deposit + origName;
//                logger.info("图片上传路径:{}", fileSrc);
//                return fileSrc;
//            }
//            return null;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
