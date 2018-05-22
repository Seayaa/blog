/**
 * 
 */
$(function(){
	$("#register_form").bootstrapValidator({
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
	    	nick_name: {
	    		message: 	'输入有误',
                validators: {
                    notEmpty: {
                        message: '请输入昵称'
                    }
                }
	    	},
	    	password:{
	    		message: 	'输入有误',
                validators: {
                    notEmpty: {
                        message: '请输入密码'
                    },
                    stringLength:{
                    	message: '请输入六位数以上密码',
                    	min : 6
                    },
                    regexp: {
                    	message: '密码只能包含大小写字母、数字和部分特殊字符',
                    	regexp: /^[\w]+$/
                    }
                }
	    	},
	    	password_conf: {
	    		message: 	'输入有误',
                validators: {
                    notEmpty: {
                        message: '请确认密码'
                    },
                    identical: {
                    	message: '两次密码不一致',
                    	field : 'password'
                    }
                }
	    	}
	    }
	}).on('success.form.bv',function(e){
		e.preventDefault();
		var state = $(".checkbox").bootstrapSwitch("state");
		var sex = 0? state = true : 1;
		var account = $("#account").val();
		var nickName = $("#nick_name").val();
		var password = $("#password").val();
		var birth = $("#year").val() + '-' + $("#mon").val() + '-' + $("#day").val() ;
		var location = $("#location").val();
		var introduction = $("#introduction").val();
		$.ajax({
			type : 'get',
			url: 'doRegister',
			data:{'account':account,'nickName':nickName,'password':password,'sex':sex,'birth':birth,'location':location,'introduction':introduction},
			success:function(data){
				if(data == 1){
					window.location.href = 'index';
				}
				else{
					window.location.href = 'register';
				}
			}
		})
		
	});
	
	
});