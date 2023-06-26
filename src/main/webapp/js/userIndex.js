let timer2,img;

$(function(){
    
    $.ajax({
        type:"GET",
        url:"../contentServlet",
        data: {},
        dataType: "json",
        success: function(res){
            console.log(res);
            let dataImage = [];
            for(let i=0;i<res.length;i++){
                let imgElement = `<img class="img" src="../images/BannerImage/${res[i]['adImage']}">`
                dataImage.push(imgElement);
            }
            $(".banner").empty().append(dataImage.join(''));
            let width = window.innerWidth;
            init(width,res);
            bannerControl(width,res);
            textShow();
        },
        error:function(){
            alert("加载数据失败");
        }
    })

    $.ajax({
        type:"GET",
        url:"../hotGameServlet",
        data:{},
        dataType: "json",
        success: function(res){
            console.log(res);
            $(".hot-game-bg").each(function(index){
                $(this).css({
                    "background": "url(../images/GameImage/"+ res[index]['gameImage'],
                    "background-size":"cover",
                    "background-position":"center center"
                })
                
            })
            $(".hot-game-text").each(function(index){
                $(this).text(res[index]['cname']);
            })
        },
        error:function(){
            alert("加载数据失败");
        }
    })

    
})
function init(width,res){
     let banner = document.getElementsByClassName('banner')[0];
     img = banner.getElementsByTagName("img");
     img[0].style.left = 0;
     for(let i=1; i<img.length;i++){
        img[i].style.left = width+'px';
        console.log("执行");
    }
    $(".banner-title>.Cname").text(res[0]["adText"].split(";")[0]);
    $(".banner-title>.Ename").text(res[0]["adText"].split(";")[1]);
}
function bannerControl(width,res){
    let index = 0;
    let next =document.getElementsByClassName("next")[0];
    let prev = document.getElementsByClassName('prev')[0];
    next.addEventListener('click',function(){
        slowAnimate(img[index],{'left':-width});
        index+=1;
        if(index>=img.length){
            index=0;
        }
        img[index].style.left = width +"px";
        console.log(width);
        slowAnimate(img[index],{left:0});
        $(".banner-title>.Cname").text(res[index]["adText"].split(";")[0]);
        $(".banner-title>.Ename").text(res[index]["adText"].split(";")[1]);
        textShow();
    })
    prev.addEventListener('click',function(){
        slowAnimate(img[index],{'left':width});
        index-=1;
        if(index===-1){
            index=img.length-1;
        }
        img[index].style.left=-width+'px';
        slowAnimate(img[index],{'left':0});
        $(".banner-title>.Cname").text(res[index]["adText"].split(";")[0]);
        $(".banner-title>.Ename").text(res[index]["adText"].split(";")[1]);
        textShow();
    })
}
/* 支持透明度的缓动动画 */
function slowAnimate(obj,json,fn){
    let speed = 0;
    let begin = 0;
    let target = 0;
    let flag =false;
    clearInterval(obj.timer);
    obj.timer = setInterval(function(){
        flag = true;
        for (let key in json){
            if(key === "opacity"){
                begin =parseInt(getCss(obj,key) * 1000) || 1000;
                target = parseInt(json[key] * 1000);
            }else{
                begin = parseInt(getCss(obj,key));
                target = parseInt(json[key]);
            }
            speed = (target-begin)*0.1;
            speed = target > begin ? Math.ceil(speed) : Math.floor(speed);
            if (key === "opacity") {
                obj.style[key] = (speed + begin) /1000;
                obj.innerText=obj.style[key];
              } else {
                obj.style[key] = speed + begin + "px";
              }
              if (begin !== target) {
                flag = false;
              }
        }
        if(flag){
            clearInterval(timer2);
            clearInterval(obj.timer);
            fn && fn();
        }
    },20);
}
function getCss(obj, attr) {
    if (obj.currentStyle) {
      return obj.currentStyle(attr);
    } else {
      return window.getComputedStyle(obj, null)[attr];
    }
}
function textShow(){
    $(".banner-title").css({
        "opacity":"0",
        "top":"-2rem"
    })
    $(".banner-title").animate(
        {
            top: "-6rem",
            "opacity":1
        },500
    )
}
