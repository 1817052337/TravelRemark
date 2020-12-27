$(document).ready(function(){
							
	$("#selectdw1 dd").click(function () {
		$(this).addClass("selectdwed").siblings().removeClass("selectdwed");
		if ($(this).hasClass("selectdw-all")) {
			$("#selectdwA").remove();
		} else {
			var copyThisA = $(this).clone();
			if ($("#selectdwA").length > 0) {
				$("#selectdwA a").html($(this).text());
			} else {
				$(".selectdw-result dl").append(copyThisA.attr("id", "selectdwA"));
			}
		}
	});
	
	$("#selectdw2 dd").click(function () {
		$(this).addClass("selectdwed").siblings().removeClass("selectdwed");
		if ($(this).hasClass("selectdw-all")) {
			$("#selectdwB").remove();
		} else {
			var copyThisB = $(this).clone();
			if ($("#selectdwB").length > 0) {
				$("#selectdwB a").html($(this).text());
			} else {
				$(".selectdw-result dl").append(copyThisB.attr("id", "selectdwB"));
			}
		}
	});
	
	$("#selectdw3 dd").click(function () {
		$(this).addClass("selectdwed").siblings().removeClass("selectdwed");
		if ($(this).hasClass("selectdw-all")) {
			$("#selectdwC").remove();
		} else {
			var copyThisC = $(this).clone();
			if ($("#selectdwC").length > 0) {
				$("#selectdwC a").html($(this).text());
			} else {
				$(".selectdw-result dl").append(copyThisC.attr("id", "selectdwC"));
			}
		}
	});
	
	$("#selectdwA").live("click", function () {
		$(this).remove();
		$("#selectdw1 .selectdw-all").addClass("selectdwed").siblings().removeClass("selectdwed");
	});
	
	$("#selectdwB").live("click", function () {
		$(this).remove();
		$("#selectdw2 .selectdw-all").addClass("selectdwed").siblings().removeClass("selectdwed");
	});
	
	$("#selectdwC").live("click", function () {
		$(this).remove();
		$("#selectdw3 .selectdw-all").addClass("selectdwed").siblings().removeClass("selectdwed");
	});
	
	$(".selectdw dd").live("click", function () {
		if ($(".selectdw-result dd").length > 1) {
			$(".selectdw-no").hide();
		} else {
			$(".selectdw-no").show();
		}
	});
	
});