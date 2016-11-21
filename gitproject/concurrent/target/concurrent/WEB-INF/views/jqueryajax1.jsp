<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>CreateElement的两种创建方式</title>
<script type="text/JavaScript" src="https://code.jquery.com/jquery-3.1.1.min.js" mce_src="https://code.jquery.com/jquery-3.1.1.js"></script>   
  
    <!--这里不需要form,因为提交时call一个函数   -->
    <script type="text/javascript">  
     
      function CreateText() {
     
      var obj1 = document.getElementById("GetURL");
      if(obj1){
      posturl()
      changeid()
      }
  var txt = document.createElement("input");
  var p = document.createElement("p");
   var obj = document.getElementById("getform");//获取原来的id = aa的div 
  txt.type = "text";
  txt.value = "";
  txt.name="URL1";
  txt.id="GetURL";
  txt.style="width:500px;";
  obj.appendChild(p);
  obj.appendChild(txt);
 
 
 
 }
 
  function CreatePostText() {
     
     var obj1 = document.getElementById("PostURL");
     
      if(obj1){
       postposturl()
      changepostid()
      }
     
     
  var txt = document.createElement("input");
   var btn1 = document.createElement("input");
    var btn2 = document.createElement("input");
    
     
  
  var p = document.createElement("p");
   var obj = document.getElementById("postform");//获取原来的id = aa的div 
  txt.type = "text";
  txt.value = "";
  txt.name="URL1";
  txt.id="PostURL";
  txt.style="width:500px;";
  obj.appendChild(p);
  
  
  btn1.type = "button";
  btn1.value = "AddParam";

 
   btn2.type = "button";
  btn2.value = "ParamDone";
  obj.appendChild(txt);
   
    btn1.setAttribute('onclick',"CreateParamText()");
     btn2.setAttribute('onclick',"postparamdone()");  
  obj.appendChild(btn1);
  obj.appendChild(btn2);
 
  
 
 
 }
 
  
  function CreateParamText() {
     
       var obj1 = document.getElementById("Param");
      if(obj1){
        postparam()
      
  changeparamid()
      }
    
  var txt = document.createElement("input");
  var txt1 = document.createElement("input");
  var p = document.createElement("p");
   var obj = document.getElementById("parambingform");//获取原来的id = aa的div 
  txt.type = "text";
  txt.value = "";
  txt.name="URL1";
  txt.id="Param";
  txt.style="width:200px;";
  
    txt1.type = "text";
  txt1.value = "";
  txt1.name="URL1";
  txt1.id="ParamValue";
  txt1.style="width:200px;";
  obj.appendChild(p);
  obj.appendChild(txt);
  obj.appendChild(txt1);
 
 
 }
 
 function CreateBingParamText() {
       var obj1 = document.getElementById("Param");
      if(obj1){
        postparam()
  changeparamid()
      }
    
  var txt = document.createElement("input");
  var txt1 = document.createElement("input");
  var p = document.createElement("p");
   var obj = document.getElementById("parambingform");//获取原来的id = aa的div 
  txt.type = "text";
  txt.value = "";
  txt.name="Param";
  txt.id="Param";
  txt.style="width:200px;";
  
    txt1.type = "text";
  txt1.value = "";
  txt1.name="ParamValue";
  txt1.id="ParamValue";
  txt1.style="width:200px;";
  obj.appendChild(p);
  obj.appendChild(txt);
  obj.appendChild(txt1);
 
 }
 
  function changeid() {
   var obj = document.getElementById("GetURL");//获取原来的id = aa的div 
   obj.setAttribute("id","bb");
 }
 
   function changepostid() {
   var obj = document.getElementById("PostURL");//获取原来的id = PostURL的div 
   obj.setAttribute("id","bb");
 }
  function changeparamid() {
   var obj = document.getElementById("Param");//获取原来的id = PostURL的div 
    var obj1 = document.getElementById("ParamValue");//获取原来的id = PostURL的div 
  /* obj.setAttribute("id","bbb");
    obj1.setAttribute("id","bbb");
   */
   obj.remove();
     obj1.remove();
   
 }
 
  function posturl(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "ok.do",                                       //把数据提交到ok.php   
        data: "GetURL="+$("#GetURL").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
   }   
 
 
   function postposturl(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "post.do",                                       //把数据提交到ok.php   
        data: "PostURL="+$("#PostURL").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
   }   
   
    function postparam(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "param.do",                                       //把数据提交到ok.php   
        data: "Param="+$("#Param").val()+"&ParamValue="+$("#ParamValue").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
   }   
   
       function postparamdone(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "paramdone.do",                                       //把数据提交到ok.php   
        data: "Param="+$("#Param").val()+"&ParamValue="+$("#ParamValue").val()+"&PostURL="+$("#PostURL").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
      
      changeparamid()
   }   
   
    function bing(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "bing.do",                                       //把数据提交到ok.php   
        data: "Param="+$("#Param").val()+"&ParamValue="+$("#ParamValue").val()+"&BingURL="+$("#BingURL").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
      changeparamid()
   }   
 
     
    $(document).ready(function(){         //DOM的onload事件处理函数   
       $("#button").click(function(){           //当按钮button被点击时的处理函数   
         postdata();   
                                             //button被点击时执行postdata函数   
     });   
   });   
   
   function postdata(){                              //提交数据函数   
      $.ajax({                                                  //调用jquery的ajax方法   
        type: "POST",                                      //设置ajax方法提交数据的形式   
        url: "ok.do",                                       //把数据提交到ok.php   
        data: "writer="+$("#writer").val()+"&pass="+$("#pass").val(),     //输入框writer中的值作为提交的数据   
        success: function(msg){                  //提交成功后的回调，msg变量是ok.php输出的内容。   
          alert("数据提交成功");                      //如果有必要，可以把msg变量的值显示到某个DIV元素中 
          $("#writer").val('');  
          $("#pass").val('');           
        }   
      });   
   }   
   </script> 
</head>
<body>	
<form id="getform" method="post" type="hidden">
  <input type="hidden" value="AddGet" onclick="CreateText()"/><input type="hidden" value="GetDone" onclick="posturl()"/><p>
  </form> 
  <form id="postform" method="post">
  <input type="button" value="AddPost" onclick="CreatePostText()"/><input type="hidden" value="PostDone" onclick="postposturl()"/><p>
  </form>  
 <form id="bingform" method="post" action="bing.do">
    BingURL:<input type="text" name = "BingURL" id="BingURL" style="width:500px;"/> 
  <span id="parambingform" method="post">
  <input type="button" value="AddParam" onclick="CreateBingParamText()"/><input type="hidden" value="Bing" onclick="bing()"/><p>
  </span>
 </form>  
  <input type="submit" value="bing" />  
</body>
</html>