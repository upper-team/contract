//文件显示
$(function(){
    reflashFile();
})
//手动动刷新文件
function reflashFile(){
    $(".truefilePath").each(function (i, n) {
        var path=$(this).val();
        var linkElem=$(this).parent().find(".link");
        var that=this;
        if(path!=undefined&&path!=""){
            var delBtnElem=$(this).parent().find(".delBtn");
            $(linkElem).attr("href",path);
            var text=path;
            text=text.substring(text.lastIndexOf("/")+1);
            $(linkElem).html(text);
            $(delBtnElem).click(function(){
                $.modal.confirm("确认刪除吗", function() {
                    $.post("/common/delete",{fileName:path},function(data){
                        reloadAll(that);
                    })
                });
            });
            $(this).parent().find(".controlDiv").removeClass("hide");
        }else{
            reloadAll(that);
        }
    })
}
//重载上传事件和样式
function reloadAll(that){
    $(that).val("");
    var inputOutElem=$(that).parent().find(".inputOut");
    $(inputOutElem).html('<input class="form-control fileInput" type="file" onChange="uploadFile(this)" >');
    var linkElem=$(that).parent().find(".link");
    $(linkElem).attr("href","javascript:void(0)");
    $(linkElem).empty();
    var controlElem=$(that).parent().find(".controlDiv");
    $(controlElem).addClass("hide");
}
//文件上传事件
function uploadFile(that) {
    var uploadDivElem=$(that).parents(".uploadDiv");
    var formData = new FormData();
    var file0=$(uploadDivElem).find(".fileInput")[0].files[0];
    if ( file0==null) {
        $.modal.alertWarning("请先选择文件路径");
        return false;
    }
    formData.append('file',file0);
    $.modal.loading("正在上传，请稍后...");
    $.ajax({
        url: "/common/upload",
        type: 'post',
        cache: false,
        data: formData,
        processData: false,
        contentType: false,
        dataType: "json",
        success: function(result) {
            var truefilePathElem=$(uploadDivElem).find(".truefilePath");
            if(!!result.fileName){
                var controlElem=$(uploadDivElem).find(".controlDiv");
                var delBtnElem=$(uploadDivElem).find(".delBtn");
                var linkElem=$(uploadDivElem).find(".link");
                var fileInputElem=$(uploadDivElem).find(".fileInput");
                var inputOutElem=$(uploadDivElem).find(".inputOut");
                $(controlElem).removeClass("hide");
                $(inputOutElem).html('<input class="form-control fileInput" type="file" onChange="uploadFile(this)" >');
                $(delBtnElem).click(function(){
                    $.modal.confirm("确认刪除吗", function() {
                        $.post("/common/delete",{fileName:result.fileName},function(data){
                            reloadAll(truefilePathElem);
                        })
                    });
                });
                $(linkElem).attr("href",result.fileName);
                var text=result.fileName;
                text=text.substring(text.lastIndexOf("/")+1);
                $(linkElem).html(text);
                $(truefilePathElem).val(result.fileName);
                $.modal.closeLoading();
                $.modal.msgSuccess("上传成功!");
            }else{
                $.modal.closeLoading();
                $.modal.msgError("上传失败！");
                reloadAll(truefilePathElem);
            }
        }
    });
}
//显示格式控制
function formatterUrl(value){
    if(value!=undefined&&value!=null&&value!=''){
        var text=value;
        text=text.substring(text.lastIndexOf("/")+1);
        return '<a href="javascript:void(0);" onClick="$.modal.openTab(\''+text+'\',\''+value+'\');" class="link">'+text+'</a>';
    }else{
        return value;
    }
}
