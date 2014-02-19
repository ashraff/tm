<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>

<link href="<c:url value="/resources/jquery/css/start/ui.jqgrid.css" />"
	rel="stylesheet">

<link
	href="<c:url value="/resources/jquery/css/start/jquery-ui-1.10.4.custom.min.css" />"
	rel="stylesheet">


<script src="<c:url value="/resources/jquery/js/jquery-1.10.2.js" />"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/jquery/js/jquery-ui-1.10.4.custom.min.js" />"
	type="text/javascript"></script>

<script
	src="<c:url value="/resources/jquery/js/jquery.jqGrid.min.js" />"
	type="text/javascript"></script>



</head>
<div class="content">
	<header>
		<h1>HTML Tutorials</h1>
		<p>
			HTML is where the magic of web page design begins. It isn&#8217;t
			presentational - <a href="../css/">that&#8217;s what CSS is for</a> -
			<em>HyperText Markup Language</em> is a simple, elegant way to
			structure <em>content</em>.
		</p>
	</header>
	<section id="main_content">
		<aside class="note five">
			<p>
				These tutorials use <em>HTML5</em>. You might have heard of it.
				It&#8217;s a cool buzzword that kids use in the playground. If you
				don&#8217;t know what that implies, don&#8217;t fret - just know
				that it&#8217;s the best, most modern flavor of HTML to use.
			</p>
		</aside>
		<!-- 	<h2>
			<a href="beginner/">HTML Beginner Tutorial</a>
		</h2>
		<p>A step-by-step guide to HTML basics. If you&#8217;re completely
			new to web design, start here.</p>

		<ul>
			<li><a href="beginner/gettingstarted/">Getting Started</a>: What
				you need to do to get going and make your first HTML page.</li>
			<li><a href="beginner/tags/">Tags, Attributes and Elements</a>:
				The stuff that makes up HTML.</li>
			<li><a href="beginner/titles/">Page Titles</a>: Titles. For
				Pages. A difficult concept, we know&#8230;</li>
			<li><a href="beginner/paragraphs/">Paragraphs</a>: Structuring
				your content with paragraphs.</li>
			<li><a href="beginner/headings/">Headings</a>: The six levels of
				headings.</li>
			<li><a href="beginner/lists/">Lists</a>: How to define ordered
				and unordered lists.</li>
			<li><a href="beginner/links/">Links</a>: How to makes links to
				other pages, and elsewhere.</li>
			<li><a href="beginner/images/">Images</a>: Adding something a
				bit more than text&#8230;</li>
			<li><a href="beginner/tables/">Tables</a>: How to use tabular
				data.</li>
			<li><a href="beginner/forms/">Forms</a>: Text boxes and other
				user-input thingamajigs.</li>
			<li><a href="beginner/conclusion/">Putting It All Together</a>:
				Taking all of the above stuff and shoving it together. Sort of in a
				recap groove.</li>
		</ul>
		<h2>
			<a href="intermediate/">HTML Intermediate Tutorial</a>
		</h2>
		<p>Some HTML bits-and-bobs that might be useful to beginners and
			advanced HTMLers alike.</p>
		<ul>
			<li><a href="intermediate/spandiv/">Span and Div</a>: The
				&#8220;meaningless&#8221; elements, used with CSS.</li>
			<li><a href="intermediate/text/">Text: Abbreviations,
					Quotations, and Code</a></li>
			<li><a href="intermediate/metatags/">Meta Tags</a>: Bolting on
				extra information about your web page.</li>
			<li><a href="intermediate/tables/">Tables: rowspan and
					colspan</a>: Expanding on the Tables page of the HTML Beginner
				Tutorial, looking at header-cells and merging cells.</li>
			<li><a href="intermediate/definitionlists/">Definition Lists</a>:
				The forgotten lists.</li>
			<li><a href="intermediate/text2/">Text: Addresses,
					Definitions, Bi-directional, and Editorial</a></li>
			<li><a href="intermediate/sectioning/">Sectioning</a>: Greater
				semantic structures for documents.</li>
		</ul>
		<h2>
			<a href="advanced/">HTML Advanced Tutorial</a>
		</h2>
		<p>Pushing HTML to its full standards-compliant, semantic,
			accessible potential.</p>
		<ul>
			<li><a href="advanced/text/">Text: Time, Mark, and
					&#8220;Presentational&#8221;</a>: Yet more tags for ultra-specific
				textual elements.</li>
			<li><a href="advanced/conditionalcomments/">Conditional
					Comments</a>: Targeting inept and misbehaving elderly browsers.</li>
			<li><a href="advanced/tables/">Tables: Columns, Headers, and
					Footers</a></li>
			<li><a href="advanced/links/">Accessible Links</a>: Making
				hypertext more accessible to users with disabilities.</li>
			<li><a href="advanced/forms/">Accessible Forms</a>: Making forms
				more accessible for users with disabilities.</li>
			<li><a href="advanced/html5forms1/">HTML5 Forms Pt. 1: Input
					Types</a>: More specific form fields.</li>
			<li><a href="advanced/html5forms2/">HTML5 Forms Pt. 2:
					Attributes and Data Lists</a>: Extending the semantics of input and
				textarea.</li>
			<li><a href="advanced/embeddedcontent/">Embedded Content:
					Video, Audio, and Canvas</a></li>
		</ul> -->
		<table id="list4"></table>
	</section>
	
		
	

	<footer id="related">
		<h2>Related pages</h2>
		<ul>
			<li><a href="../css/">CSS Tutorials</a></li>
			<li><a href="../javascript/">JavaScript Tutorials</a></li>
		</ul>
	</footer>
</div>



<script lang="javascript">
	jQuery("#list4").jqGrid(
			{
				datatype : "local",
				height : 250,
				colNames : [ 'Inv No', 'Date', 'Client', 'Amount', 'Tax',
						'Total', 'Notes' ],
				colModel : [ {
					name : 'id',
					index : 'id',
					width : 60,
					sorttype : "int"
				}, {
					name : 'invdate',
					index : 'invdate',
					width : 90,
					sorttype : "date"
				}, {
					name : 'name',
					index : 'name',
					width : 100
				}, {
					name : 'amount',
					index : 'amount',
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : 'tax',
					index : 'tax',
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : 'total',
					index : 'total',
					width : 80,
					align : "right",
					sorttype : "float"
				}, {
					name : 'note',
					index : 'note',
					width : 150,
					sortable : false
				} ],
				multiselect : true,
				caption : "Manipulating Array Data"
			});
	var mydata = [ {
		id : "1",
		invdate : "2007-10-01",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "2",
		invdate : "2007-10-02",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "3",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "4",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "5",
		invdate : "2007-10-05",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "6",
		invdate : "2007-09-06",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	}, {
		id : "7",
		invdate : "2007-10-04",
		name : "test",
		note : "note",
		amount : "200.00",
		tax : "10.00",
		total : "210.00"
	}, {
		id : "8",
		invdate : "2007-10-03",
		name : "test2",
		note : "note2",
		amount : "300.00",
		tax : "20.00",
		total : "320.00"
	}, {
		id : "9",
		invdate : "2007-09-01",
		name : "test3",
		note : "note3",
		amount : "400.00",
		tax : "30.00",
		total : "430.00"
	} ];
	for (var i = 0; i <= mydata.length; i++)
		jQuery("#list4").jqGrid('addRowData', i + 1, mydata[i]);
</script>