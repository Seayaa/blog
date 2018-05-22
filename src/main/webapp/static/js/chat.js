/**
 * 
 */
$(function(){
	
	var userName ;
	
	var websocket;
	
	$("#connect_btn").on("click",function(){
		console.log("hello")
		userName = $("#userName").val();
		if(userName == ""){
			alert("请输入昵称!");
			return false;
		}
		if ("WebSocket" in window){
			websocket = new WebSocket("ws://172.16.6.67:8080/blog/websocket/" + userName);
			websocket.onopen = function(){
//				alert("连接建立!");
				$("#userName").attr("readonly",true);
				$("#connect_btn").attr("disabled",true);
				$("#userName_label").text("昵称:");
			}
			
			websocket.onerror = function(){
				alert("连接错误!");
			}
			
			websocket.onclose = function(){
				alert("关闭连接!");
			}
			
			websocket.onmessage = function(e){
				var data = JSON.parse(e.data);
				var flag = data.flag;
				var text = data.text;
				/*
				 * 第一次连接，返回大厅用户
				 */
				if(flag == "1"){
					var users = text.split(";");
					var user_html = "";
					var chat_html = "";
					for(var i = 0; i < users.length; i++){
						if(userName != users[i]){
							user_html += '<div class="user_div" id="' + users[i] + '">' + users[i] + '</div>';							
							chat_html += '<div class="show_div" id="show_' + users[i] +'"></div>';
						}
					}
					$(".left_div").append(user_html);
					$(".right_div").prepend(chat_html);
				}
				/*
				 * 更新大厅用户
				 */
				else if(flag == "2"){
					var add_html = '<div class="user_div" id="' + text + '">' + text + '</div>';
					var add_chat_html = '<div class="show_div" id="show_' + text +'"></div>';
					$(".left_div").append(add_html);
					$(".right_div").prepend(add_chat_html);
				}
				/*
				 * 发送消息
				 */
				else if(flag == "3"){
					$(".user_div").each(function(index, e){
						var user = $(this).attr("id");
						$("#show_" + user).css({'z-index':'-1'});
						$(this).removeClass("active");
						
					});
					var fromName = data.fromName;
					var text = data.text;

					$("#show_" + fromName).css({"z-index":'0'});
					$("#" + fromName).addClass("active");
					var send_html = '<div class="send_line"><font class="send_user">' + fromName + '</font><font class="send_font">' + text + '</font></div>';
					$("#show_" + fromName).append(send_html);
				}
				
			}
		}
	});
	
	$("#send_btn").on("click",function(){
		var text = $("#text").val();
		var toName = $(".active").attr("id");
		var message = text + "||" + toName;
		websocket.send(message);
		var self_html = '<div class="self_line"><font class="self_font">' + text + '</font><font class="self_user">你</font></div>';
		$("#show_" + toName).append(self_html);
		$("#text").val("");
	});
	
	$(document).on('click', '.user_div', function(){
		$(".user_div").each(function(index, e){
			var user = $(this).attr("id");
			$("#show_" + user).css({'z-index':'-1'});
			$(this).removeClass("active");
			
		})
		var user = $(this).attr("id");
		$(this).addClass("active");
		$("#show_" + user).css({'z-index':'0'});
	});
		
	
})