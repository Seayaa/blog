/**
 * 
 */
$(function(){

	/* 改变验证码 */
	function changeCode(){
		var timestamp = (new Date()).valueOf();
		var url = "getCodeImg/timestamp=" + timestamp; 
		$("#codeImg").attr("src", url);
	};
	
	$("#change_code").on("click",function(){
		changeCode();
	})

	/* 初始化表单验证 */
	$("#login_form").bootstrapValidator({
		message:	'输入有误',
		feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields:{
	    	account:	{
	    		message: 	'输入有误',
	            validators: {
	                notEmpty: {
	                    message: '请输入账户名'
	                }
	            }
	    	},
	    	password:{
	    		message: 	'输入有误',
	            validators: {
	                notEmpty: {
	                    message: '请输入密码'
	                },
	            }
	    	},
	    	code: {
	    		message: '输入有误',
	    		validators: {
	    			notEmpty: {
	    				message: '请输入验证码'
	    			},
	    			stringLength: {
	    				min : 4,
	    				max: 4,
	    				message:'请输入四位验证码',
	    			},
	    			regexp: {
	    				message: '请输入有效字母或数字',
	    				regexp: /^\w+$/
	    			}
	    		}
	    	}
	    }
	}).on('success.form.bv',function(e){
		e.preventDefault();
		var account = $("#account").val();
		var password = $("#password").val();
		var code = $("#code").val();
		$.getJSON("loginDo", {'account':account, 'password':password, 'code':code}, function(data){
			console.log(data)
			if(data.flag == "1"){
				/*$(".cover_div").hide();
				$(".login_div").hide();*/
				window.location.href="personal";
			}
			else{
				alert(data.msg);
				$("#login_form").bootstrapValidator("resetForm",true);
				changeCode();
			}
		});
	});

	/* 登录按钮  */	
	$("#login_btn").on('click',function(){
		changeCode();
		$(".blur_div").addClass('blur');
		$(".cover_div").show();
		$(".login_div").show();
	});
	
	/* 关闭登录窗口 */
	$(".close_login").on("click",function(){
		$("#login_form").bootstrapValidator("resetForm",true);
		$(".login_div").hide();
		$(".cover_div").hide();
		$(".blur_div").removeClass('blur');
	});
})