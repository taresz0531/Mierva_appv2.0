<meta charset="utf-8">
<#include "header.ftl">

<div class="main-div container">
	<#list MainPageObject as mpo>
		<div class="foldal-main-div">
			<p>cím: ${mpo.cim}</p>
		</div>
	</#list>
</div>

<#include "footer.ftl">