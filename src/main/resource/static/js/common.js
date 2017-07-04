/**
 * Created by xuxiaobao on 2017/7/5.
 */

//自定义弹出模态框
function myAlert(message) {
    var modal = "<div class='modal fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel' aria-hidden='true'>"
        +"<div class='modal-dialog'>"
        +"<div class='modal-content'>"
        +"<div class='modal-header'>"
        +"<button type='button' class='close' data-dismiss='modal' aria-hidden='true'>×</button>"
        +"</div>"
        +"<div class='modal-body text-center'>"+message+"</div>"
        +"<div class='modal-footer'>"
        +"<button type='button' class='btn btn-default' data-dismiss='modal'>关闭</button>"
        +"</div>"
        +"</div>"
        +"</div>"
        +"</div>";
    $(modal).modal('show');
}
