package com.ruoyi.web.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysContractCooperative;
import com.ruoyi.system.domain.SysEmployee;
import com.ruoyi.system.domain.SysProduct;
import com.ruoyi.system.service.ISysContractCooperativeService;
import com.ruoyi.system.service.ISysEmployeeService;
import com.ruoyi.system.service.ISysProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 合作合同Controller
 * 
 * @author ruoyi
 * @date 2021-05-04
 */
@Controller
@RequestMapping("/system/cooperative")
public class SysContractCooperativeController extends BaseController
{
    private String prefix = "system/cooperative";

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ISysProductService productService;

    @Autowired
    private ISysEmployeeService employeeService;

    @Autowired
    private ISysContractCooperativeService sysContractCooperativeService;

    @RequiresPermissions("system:cooperative:view")
    @GetMapping()
    public String cooperative()
    {
        return prefix + "/cooperative";
    }

    /**
     * 查询合作合同列表
     */
    @RequiresPermissions("system:cooperative:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysContractCooperative sysContractCooperative)
    {
        startPage();
        List<SysContractCooperative> list = sysContractCooperativeService.selectSysContractCooperativeList(sysContractCooperative);
        return getDataTable(list);
    }

    /**
     * 导出合作合同列表
     */
    @RequiresPermissions("system:cooperative:export")
    @Log(title = "合作合同", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysContractCooperative sysContractCooperative)
    {
        List<SysContractCooperative> list = sysContractCooperativeService.selectSysContractCooperativeList(sysContractCooperative);
        ExcelUtil<SysContractCooperative> util = new ExcelUtil<SysContractCooperative>(SysContractCooperative.class);
        return util.exportExcel(list, "cooperative");
    }

    /**
     * 新增合作合同
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        List<SysProduct> list = productService.selectSysProductAll();
        mmap.put("products", list);
        List<SysEmployee> list_e = employeeService.selectSysEmployeeAll();
        mmap.put("employees", list_e);
        return prefix + "/add";
    }

    /**
     * 新增保存合作合同
     */
    @RequiresPermissions("system:cooperative:add")
    @Log(title = "合作合同", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysContractCooperative sysContractCooperative, MultipartFile file)
    {
        String scanningCopy = sysContractCooperativeService.uploadFile(sysContractCooperative, file);
        sysContractCooperative.setScanningCopy(scanningCopy);
        return toAjax(sysContractCooperativeService.insertSysContractCooperative(sysContractCooperative));
    }

    /**
     * 修改合作合同
     */
    @GetMapping("/edit/{contractId}")
    public String edit(@PathVariable("contractId") Long contractId, ModelMap mmap)
    {
        SysContractCooperative sysContractCooperative = sysContractCooperativeService.selectSysContractCooperativeById(contractId);
        mmap.put("sysContractCooperative", sysContractCooperative);
        List<SysProduct> list = productService.selectSysProductAll();
        mmap.put("products", list);
        List<SysEmployee> list_e = employeeService.selectSysEmployeeAll();
        mmap.put("employees", list_e);
        return prefix + "/edit";
    }

    /**
     * 修改保存合作合同
     */
    @RequiresPermissions("system:cooperative:edit")
    @Log(title = "合作合同", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysContractCooperative sysContractCooperative)
    {
        return toAjax(sysContractCooperativeService.updateSysContractCooperative(sysContractCooperative));
    }

    /**
     * 删除合作合同
     */
    @RequiresPermissions("system:cooperative:remove")
    @Log(title = "合作合同", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysContractCooperativeService.deleteSysContractCooperativeByIds(ids));
    }

    /**
     * 下载pdf
     */
    @RequiresPermissions("system:cooperative:downPDF")
    @PostMapping("/downPDF")
    @ResponseBody
    public AjaxResult downPDF(String ids){
        SysContractCooperative SysContractCooperative = new SysContractCooperative();
        SysContractCooperative.setIdArr(Convert.toStrArray(ids));
        List<SysContractCooperative> SysContractCooperativeList = sysContractCooperativeService.selectSysContractCooperativeList(SysContractCooperative);
        for(SysContractCooperative SysContractCooperative1 : SysContractCooperativeList){
            String pdfUrl = SysContractCooperative1.getScanningCopy(); // 拿到pdf存储路径
            return AjaxResult.success(pdfUrl);
        }
        return AjaxResult.success("下载完毕");
    }

//    /** 上传&下载 */
//    @RequiresPermissions("system:cooperative:upload")
//    @PostMapping("/upload")
//    @ResponseBody
//    public AjaxResult uploadFile(MultipartFile file) throws Exception {
//        try {
//            // 上传文件路径(可自定义)
//            String filePath = "D:\\ruoyi";
//            // 上传并返回新文件名称
//            String fileName = FileUploadUtils.upload(filePath, file);
//            String url = serverConfig.getUrl() + fileName;
//            AjaxResult ajax = AjaxResult.success();
//            ajax.put("fileName", fileName);
//            ajax.put("url", url);
//            return ajax;
//        } catch (Exception e) {
//            return AjaxResult.error(e.getMessage());
//        }
//    }

//    @RequiresPermissions("system:file:download")
//    @GetMapping("/download")
//    public void download(HttpServletResponse response) throws Exception {
//        // 下载本地文件
//        String fileName = "example.pdf".toString(); // 文件的默认保存名
//        // 读到流中
//        InputStream inStream = new FileInputStream("D:/example.pdf");// 文件的存放路径
//        // 设置输出的格式
//        response.reset();
//        response.setContentType("bin");
//        response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        // 循环取出流中的数据
//        byte[] b = new byte[100];
//        int len;
//        try {
//            while ((len = inStream.read(b)) > 0)
//                response.getOutputStream().write(b, 0, len);
//            inStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


//
//    @RequiresPermissions("system:cooperative:addFile")
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
//            // 在已有方法中定义并包装了路径
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
//
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
//
//    /**
//     * 下载
//     * */
//    @GetMapping("/common/download/resource")
//    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        // 本地资源路径
//        String localPath = RuoYiConfig.getProfile();
//        // 数据库资源地址
//        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
//        // 下载名称
//        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("multipart/form-data");
//        response.setHeader("Content-Disposition",
//                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
//        FileUtils.writeBytes(downloadPath, response.getOutputStream());
//    }


}
