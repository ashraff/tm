<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <p>	<a href="/"><img
				src="<c:url value="/resources/r10/logoNew.gif" />" alt="HTML Dog"
				width="80" height="58"><span></span></a>
        </p>
    </div>
    <p id="access_nav">	<a href="#main_nav">Skip to navigation</a>
    </p>
    <nav id="you_are_here">	<a href="/" id="home_link">Home</a><span> &rarr; </span><a href="/guides/">Tutorials</a><span> &rarr; </span><a href="/guides/html/">HTML</a><span id="yah_last"> &rarr; </span>
    </nav>
    <nav id="main_nav">
        <div>
            <table>
                <tr>
                    <td colspan="0">
                        <ul>
                            <li class="subli"><a href="javascript:ddtreemenu.flatten('treemenu2', 'expand')">-</a>
                            </li>
                        </ul>
                    </td>
                    <td colspan="0">
                        <ul>
                            <li class="subli"><a href="javascript:ddtreemenu.flatten('treemenu2', 'contact')">+</a>
                            </li>
                        </ul>
                    </td>
                </tr>
            </table>
        </div>
        <ul id="treemenu2">
            <li id="li_tut"><a href="#">Tutorials</a>
                <ul>
                    <li><a href="#" class="asec">HTML</a>
                        <ul>
                            <li><a href="/guides/html/beginner/">Beginner</a>
                            </li>
                            <li><a href="#" class="asec">Intermediate</a>
                                <ul>
                                    <li>
                                        <form action="<c:url value=" /page1.htm "/>" method="POST" id="page1Form" style="padding: 0px; margin: 0px;"></form> <a id="page1" href="#">Page Ashraff One</a>
                                    </li>
                                    <li>
                                        <form action="<c:url value=" /page2.htm "/>" method="POST" id="page2Form" style="padding: 0px; margin: 0px;"></form> <a id="page2" href="#">Page Ashraff Two</a>
                                    </li>
                                    <li><a href="/guides/html/intermediate/metatags/">Meta
											Tags</a>
                                    </li>
                                    <li><a href="/guides/html/intermediate/tables/">Tables:
											rowspan and colspan</a>
                                    </li>
                                    <li><a href="/guides/html/intermediate/definitionlists/">Definition
											Lists</a>
                                    </li>
                                    <li><a href="/guides/html/intermediate/text2/">Text:
											Addresses, Definitions, Bi-directional, and Editorial</a>
                                    </li>
                                    <li><a href="/guides/html/intermediate/sectioning/">Sectioning</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a href="/guides/html/advanced/">Advanced</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="/guides/css/">CSS</a>
                    </li>
                    <li><a href="/guides/javascript/">JavaScript</a>
                    </li>
                </ul>
            </li>
            <li id="li_tech"><a href="/techniques/">Techniques</a>
            </li>
            <li id="li_eg"><a href="/examples/">Examples</a>
            </li>
            <li id="li_ref"><a href="/reference/">References</a>
                <ul>
                    <li><a href="/reference/htmltags/">HTML Tags</a>
                    </li>
                    <li><a href="/reference/cssproperties/">CSS Properties</a>
                    </li>
                </ul>
            </li>
            <li id="li_wh" class="subli superli"><a href="/webhosting/">Web
					Hosting</a>
            </li>
            <li class="subli superli"><a href="/about/">About Us</a>
            </li>
            <li class="subli"><a href="/linkto/">Link to Us</a>
            </li>
            <li id="li_smap" class="subli"><a href="/sitemap/">Site Map</a>
            </li>
            <li id="access_top"><a href="#">&#8593; Top</a>
            </li>
        </ul>
    </nav>
    <br>
    <br>
    <br>
</body>

<script type="text/javascript">
	ddtreemenu.createTree("treemenu2", true, 5)
	Spring.addDecoration(new Spring.AjaxEventDecoration({
		elementId : "page1",
		formId : "page1Form",
		event : "onclick",
		params : {
			fragments : "content"
		}
	}));
	Spring.addDecoration(new Spring.AjaxEventDecoration({
		elementId : "page2",
		formId : "page2Form",
		event : "onclick",
		params : {
			fragments : "content"
		}
	}));
</script>

</html>
