<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html dir="ltr" lang="en">
<head>

<meta charset="utf-8">
<title>Task Manager</title>


<link href="<c:url value="/resources/r10/goldenjackal.css" />"
	rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Bree+Serif"
	rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,300,400,600,700"
	rel="stylesheet">

</head>


<body class="level3">
	<div id="dog_tag">
		<p>
			<a href="/"><img
				src="<c:url value="/resources/r10/logoNew.gif" />" alt="HTML Dog"
				width="80" height="58"><span></span></a>
		</p>
	</div>
	<p id="access_nav">
		<a href="#main_nav">Skip to navigation</a>
	</p>
	<nav id="you_are_here">
		<a href="/" id="home_link">Home</a><span> &rarr; </span><a
			href="/guides/">Tutorials</a><span> &rarr; </span><a
			href="/guides/html/">HTML</a><span id="yah_last"> &rarr; </span>
	</nav>
	<nav id="main_nav">
		<div>
			<table>
				<tr>
					<td colspan="0">
						<ul>
							<li class="subli"><a
								href="javascript:ddtreemenu.flatten('treemenu2', 'expand')">-</a>
							</li>
						</ul>
					</td>
					<td colspan="0">
						<ul>
							<li class="subli"><a
								href="javascript:ddtreemenu.flatten('treemenu2', 'contact')">+</a>
							</li>
						</ul>
					</td>
				</tr>
			</table>
		</div>
		<ul id="treemenu2">
			<li>
				<ul>
					<c:forEach var="menuItem" items="${menuList}">
						<li id="${menuItem.id}"><c:choose>
								<c:when test="${menuItem.selected == 1}">
									<a href="#" class="selected"><span><c:out
												value="${menuItem.menuText}" escapeXml="true" /></span></a>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${ ! empty menuItem.url }">


											<form action="<c:url value='${menuItem.url}'/>" method="POST"
												id="${menuItem.id}_f" style="padding: 0px; margin: 0px;"
												name="${fn:replace(menuItem.url,'/','')}"></form>
											<a id="${fn:replace(menuItem.url,'/','')}" class="asec"
												href="#">${menuItem.menuText}</a>

										</c:when>
										<c:otherwise>
											<a href="#" class="asec"><span><c:out
														value="${menuItem.menuText}" escapeXml="true" /></span></a>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose> <c:if test="${fn:length(menuItem.childItems) > 0}">
								<ul>
									<c:forEach var="secondMenuItem" items="${menuItem.childItems}">
										<li id="${secondMenuItem.id}"><c:choose>
												<c:when test="${secondMenuItem.selected == 1}">
													<a href="#" class="selected asec"><span><c:out
																value="${secondMenuItem.menuText}" escapeXml="true" /></span></a>
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="${ ! empty secondMenuItem.url }">
															<form action="<c:url value='${secondMenuItem.url}'/>"
																method="POST" id="${menuItem.id}_f"
																style="padding: 0px; margin: 0px;"
																name="${secondMenuItem.id}_a"></form>
															<a id="${secondMenuItem.id}_a" class="asec" href="#">${secondMenuItem.menuText}</a>
														</c:when>
														<c:otherwise>
															<span><c:out value="${secondMenuItem.menuText}"
																	escapeXml="true" /></span>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose> <c:if test="${fn:length(secondMenuItem.childItems) > 0}">
												<ul>
													<c:forEach var="thirdMenuItem"
														items="${secondMenuItem.childItems}">
														<li id="${thirdMenuItem.id}"><c:choose>
																<c:when test="${thirdMenuItem.selected == 1}">
																	<a href="#" class="selected asec"><span><c:out
																				value="${thirdMenuItem.menuText}" escapeXml="true" /></span></a>
																</c:when>
																<c:otherwise>
																	<c:choose>
																		<c:when test="${ ! empty thirdMenuItem.url }">
																			<a href="#"><span><c:out
																						value="${thirdMenuItem.menuText}" escapeXml="true" /></span></a>
																		</c:when>
																		<c:otherwise>
																			<span><c:out value="${thirdMenuItem.menuText}"
																					escapeXml="true" /></span>
																		</c:otherwise>
																	</c:choose>
																</c:otherwise>
															</c:choose> <c:if test="${fn:length(thirdMenuItem.childItems) > 0}">
																<ul>
																	<c:forEach var="fourthMenuItem"
																		items="${thirdMenuItem.childItems}">
																		<li id="${fourthMenuItem.id}"><c:choose>
																				<c:when test="${fourthMenuItem.selected == 1}">
																					<a href="#" class="selected asec"><span><c:out
																								value="${fourthMenuItem.menuText}"
																								escapeXml="true" /></span></a>
																				</c:when>
																				<c:otherwise>
																					<c:choose>
																						<c:when test="${ ! empty fourthMenuItem.url }">
																							<a href="#"><span><c:out
																										value="${fourthMenuItem.menuText}"
																										escapeXml="true" /></span></a>
																						</c:when>
																						<c:otherwise>
																							<span><c:out
																									value="${fourthMenuItem.menuText}"
																									escapeXml="true" /></span>
																						</c:otherwise>
																					</c:choose>
																				</c:otherwise>
																			</c:choose></li>
																	</c:forEach>
																</ul>
															</c:if></li>
													</c:forEach>
												</ul>
											</c:if></li>
									</c:forEach>
								</ul>
							</c:if></li>
					</c:forEach>
				</ul>

			</li>
		</ul>

	</nav>
	<br>
	<br>
	<br>
</body>

<script type="text/javascript">
	ddtreemenu.createTree("treemenu2", true, 5);
	$('#treemenu2 form').each(function() {
		Spring.addDecoration(new Spring.AjaxEventDecoration({
			elementId : this.name,
			formId : this.id,
			event : "onclick",
			params : {
				fragments : "content"
			}
		}));

	});
</script>

</html>
