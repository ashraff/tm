<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head></head>
<div class="content" id="content">
	<header>
		<h1>Resources</h1>
	</header>
	<section id="main_content">
		<table id="resourcelist"></table>
		<div id="pagination"></div>
		<div id="buttonpanel" class="buttonpanel">
			<button id="addrow">Add</button>
			<button id="deleterow">Delete</button>
			<button id="modifyrow">Modify</button>
			<button id="searchrows">Search</button>
		</div>
	</section>
	<footer id="related"> </footer>
</div>
<script lang="javascript">
	$(function() {
		$("#buttonpanel button").button().click(function(event) {
			event.preventDefault();
		});
	});
	jQuery("#resourcelist").jqGrid(
			{
				url : 'resource/getList',
				datatype : "json",
				autowidth : true,
				height : 250,
				rowNum : 10,
				pager : '#pagination',
				rowList : [20, 40, 60],
				colNames : ['Soe Id', 'Name', 'Email', 'Primary Skill',
						'Sec. Skill', 'Add. Skill', 'Projects', 'Start Date',
						'End Date', 'Version'],
				colModel : [{
					name : 'soeId',
					index : 'soeId',
					width : 60,
					editable : true,
					editrules : {
						required : true
					},
					search : true
				/*,
									searchoptions : {
										sopt : ['eq', 'cn']
									}*/
				}, {
					name : 'resourceName',
					index : 'resourceName',
					width : 90,
					editable : true,
					editrules : {
						required : true
					},
					formoptions : {
						colpos : 1,
						rowpos : 2
					},
					search : true
				}, {
					name : 'resourceEmail',
					index : 'resourceEmail',
					width : 100,
					editable : true,
					editrules : {
						email : true,
						required : true
					},
					formoptions : {
						colpos : 2,
						rowpos : 2
					},
					search : true
				}, {
					name : 'primarySkill',
					index : 'primarySkill',
					width : 80,
					align : "right",
					sorttype : "float",
					editable : true,
					editrules : {
						required : true
					},
					edittype : "select",
					editoptions : {
						multiple : false,
						dataUrl : "resource/getSkills",
						size : 3
					},
					formoptions : {
						colpos : 1,
						rowpos : 3
					},
					search : true
				}, {
					name : 'secondarySkill',
					index : 'secondarySkill',
					width : 80,
					align : "right",
					sorttype : "float",
					editable : true,
					edittype : "select",
					editoptions : {
						multiple : false,
						dataUrl : "resource/getSkills",
						size : 3
					},
					formoptions : {
						colpos : 2,
						rowpos : 3
					},
					search : true
				}, {
					name : 'tertiarySkill',
					index : 'tertiarySkill',
					width : 80,
					align : "right",
					editable : true,
					abc : "",
					edittype : "select",
					editoptions : {
						multiple : false,
						dataUrl : "resource/getSkills",
						size : 3
					},
					search : true
				}, {
					name : 'projectListAsString',
					index : 'projectListAsString',
					width : 150,
					sortable : false,
					edittype : "select",
					editoptions : {
						multiple : true,
						dataUrl : "resource/getProjects",
						size : 3
					},
					editable : true,
					search : false
				}, {
					name : 'dateStart',
					index : 'dateStart',
					width : 80,
					align : "right",
					editable : true,
					formoptions : {
						colpos : 1,
						rowpos : 5
					},
					editrules:{date:true, minValue:0}, 
					editoptions:{dataInit: function (elem) {$(elem).datepicker({dateFormat:"yy-MM-dd"});}},
					datefmt:'y-M-d',
					search : true
				}, {
					name : 'dateEnd',
					index : 'dateEnd',
					width : 80,
					align : "right",
					editable : true,					
					formoptions : {
						colpos : 2,
						rowpos : 5
					},
					editrules:{date:true, minValue:0}, 
					editoptions:{dataInit: function (elem) {$(elem).datepicker({dateFormat:"yy-MM-dd"});}}, 
					datefmt:'y-M-d',
					search : true
				}, {
					name : 'versionNo',
					index : 'versionNo',
					hidden : true,
					editable : true,
					editrules : {
						edithidden : false
					}
				}],
				multiselect : false,
				caption : "Resources By Project"
			}).navGrid("#pagination", {
		edit : false,
		add : false,
		del : false,
		excelExport : true,
		view : true
	}, {
		ajaxEditOptions : jsonOptions,
		serializeEditData : createJSON
	}, {
		ajaxEditOptions : jsonOptions,
		serializeEditData : createJSON
	}, {
		ajaxEditOptions : jsonOptions,
		serializeEditData : createJSON
	}, {
		multipleSearch : true,
		multipleGroup : true,
		closeAfterSearch : true
	});

	var jsonOptions = {
		type : "POST",
		contentType : "application/json",
		accepts : {
			json : "application/json"
		},
		dataType : "json"
	};

	function createJSON(postdata) {
		if (postdata.id === '_empty')
			postdata.id = null;
		delete postdata.oper;
		return JSON.stringify(postdata);
	}

	$("#searchrows").click(function() {
		jQuery("#resourcelist").jqGrid('searchGrid', {
			multipleSearch : true,
			multipleGroup : true,
			closeAfterSearch : true
		});
	});
	$("#addrow").click(function() {
		jQuery("#resourcelist").jqGrid('editGridRow', "new", {
			height : 400,
			width : 600,
			reloadAfterSubmit : true,
			ajaxEditOptions : jsonOptions,
			serializeEditData : createJSON,
			closeAfterAdd : true,
			url : 'resource/add'
		});
	});
	$("#modifyrow").click(function() {
		var gr = jQuery("#resourcelist").jqGrid('getGridParam', 'selrow');
		if (gr != null)
			jQuery("#resourcelist").jqGrid('editGridRow', gr, {
				height : 335,
				width : 600,
				reloadAfterSubmit : true,
				ajaxEditOptions : jsonOptions,
				serializeEditData : createJSON,
				closeAfterEdit : true,
				url : 'resource/edit'
			});
		else
			alert("Please select a row to edit.");
	});
	$("#deleterow")
			.click(
					function() {
						var gr = jQuery("#resourcelist").jqGrid('getGridParam',
								'selrow');
						if (gr != null)
							jQuery("#resourcelist")
									.jqGrid(
											'delGridRow',
											gr,
											{
												reloadAfterSubmit : true,
												recreateForm : true,
												closeAfterDelete : true,
												url : 'resource/delete',
												beforeShowForm : function(form) {
													//change title
													$(".delmsg")
															.replaceWith(
																	'<span style="white-space: pre;">'
																			+ 'Delete selected record?'
																			+ '</span>');

													//hide arrows
													$('#pData').hide();
													$('#nData').hide();
												},

												//--
												afterSubmit : function(
														response, postdata) {
													var result = eval('('
															+ response.responseText
															+ ')');
													var errors = "";

													if (result.success == false) {
														for (var i = 0; i < result.message.length; i++) {
															errors += result.message[i]
																	+ "";
														}
													} else {
														$("#dialog")
																.text(
																		'Entry has been deleted successfully');
														$("#dialog")
																.dialog(
																		{
																			title : 'Success',
																			modal : true,
																			buttons : {
																				"Ok" : function() {
																					jq(
																							this)
																							.dialog(
																									"close");
																				}
																			}
																		});
													}
													// only used for adding new records
													var new_id = null;
													return [result.success,
															errors, new_id];
												}

											//--
											});
						else
							alert("Please Select Row to delete!");
					});
</script>