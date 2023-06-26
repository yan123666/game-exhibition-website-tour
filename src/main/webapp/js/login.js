$(function(){
    //登录功能
    $("#login").on("submit",function(e){
        e.preventDefault();
        let data = $("#login").serializeArray();

        $.ajax({
            type:"POST",
            url:"loginServlet",
            data: {"username":data[0].value,"password":data[1].value},
            dataType:"text",
            success: function(data){
                if(data ==="用户名不能为空"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.usernameInput').addClass('form-error');
                    $('.usernameInput').append(info);
                    
                }else if(data ==="密码不能为空"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.passwordInput').addClass('form-error');
                    $('.passwordInput').append(info);

                }else if(data ==="用户名或密码错误"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.usernameInput').addClass('form-error');
                    $('.usernameInput').append(info);
                // }else{
                //     if($('.usernameInput>input').val().toLowerCase() == "azirkxs"){
                //         window.location.href="admin/index.html";
                //     }else{
                //         window.location.href="page/userIndex.html";
                //     }
                // }
                }else{
                    if($('.usernameInput>input').val().toLowerCase() == "azirkxs"){
                        window.location.href="admin/index.html";
                    }else{
                        window.location.href="museum-master/index.html";
                    }
                }
            } ,
            error: function(){
                alert("请求失败！");
            }
        })
    })
    //注册功能
    $("#register").on("submit",function(e){
        e.preventDefault();
        let data =$("#register").serializeArray();
        console.log(data);
        $.ajax({
            type:"POST",
            url:"registerServlet",
            data:{"Cusername":data[0].value,"Cpassword":data[1].value,"Cpassword2":data[2].value},
            dataType:"text",
            success:function(data){
                if(data === "用户名不能为空"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.CusernameInput').addClass('form-error');
                    $('.CusernameInput').append(info);
                }
                else if(data ==="密码不能为空"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.CpasswordInput').addClass('form-error');
                    $('.CpasswordInput').append(info);
                }
                else if(data == "用户名长度需要为长度为6~10位"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.CusernameInput').addClass('form-error');
                    $('.CusernameInput').append(info);
                }
                else if(data == "用户名需要0~9的数字组成,长度为6~10位"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.CusernameInput').addClass('form-error');
                    $('.CusernameInput').append(info);
                }
                else if(data == "密码长度需为6~12位"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.CpasswordInput').addClass('form-error');
                    $('.CpasswordInput').append(info);
                }
                else if(data =="两次输入的密码不一致"){
                    let info=$('<div class="error-info"></div>');
                    info.text(data);
                    $('.Cpassword2Input').addClass('form-error');
                    $('.CpasswordInput').append(info);
                }
                else if(data == "注册失败"){
                    let info=$('<div class="error-info"></div>');
                    info.text("此用户名已经存在");
                    $('.CusernameInput').addClass('form-error');
                    $('.CusernameInput').append(info);
                }else{
                    alert("注册成功");
                }

            },
            error:function(){
                alert("请求失败！")
            }
        })

    })
    //背景随鼠标移动
    window.addEventListener('mousemove',function(e){
        
        let x = e.clientX;
        let y = e.clientY;
        let width = window.innerWidth;
        let height = window.innerHeight;
        let setX = -(x-width/2)*0.1;
        let setY = -(y-height/2)*0.1;
        $('.box').css({
            "left": setX+"px",
            "top": setY+"px" 
        })
    })
    //背景切换
    let flag = 1;
    $("#form-type").on('change',function(){
        if(flag){
            $('.box').css({
                "background":"url(images/IndexImage/02.jpg) no-repeat",
                "background-size":"cover"
            })
            flag = 0;
        }else{
            $('.box').css({
                "background":"url(images/IndexImage/01.jpg) no-repeat",
                "background-size":"cover"
            })
            flag = 1;
        }
    })
   
    $('.form-input').on('click',function(){
        $('.form-input').removeClass('form-error');
        $('.form-input>.error-info').remove();
    })

})