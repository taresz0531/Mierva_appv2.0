<meta charset="utf-8">
<div id="header">
	<#include "header.ftl">
</div>
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Bejegyzés Módosítás</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
<div class="admin-div">
<#if foldalList??>
	<#list foldalList as r>
		<div class="row" style="margin-bottom: 10px; padding-left: 20px;">
			<form role="form" action="foldalModosit" method="post" id="form${r.id}">
				<input type="hidden" id="id" name="id" value="${r.id}"/>
				<input type="hidden" id="originalCim" name="originalCim" value="${r.cim}"/>
				<div style="display: none;" id="leiras${r.id}" name="leiras${r.id}">${r.leiras}</div>
				<input type="hidden" id="date" name="date" value="${r.date}">
				<input type="hidden" id="dateTo" name="dateTo" value="${r.dateTo}">
				<input type="hidden" id="nyelv" name="nyelv" value="${r.nyelv}">
				<input type="hidden" id="stat" name="stat" value="${r.stat}">
				<input type="hidden" id="autoOpen" name="autoO" value="${r.autoOpen}"/>
			  	<input type="text" class="col-xs-6 form-control" id="cim" name="cim" value="${r.cim}" disabled style="max-width: 280px; margin-right: 5px;"/>
			  	<button type="button" class="btn col-xs-2" style="max-width: 80px; margin-right: 5px;" onclick="foldalModosit('form${r.id}','leiras${r.id}')">Módosít</button>
			  	<input type="submit" class="btn col-xs-2" <#if r.stat == "A">value="Inaktivál"<#else>value="Aktivál"</#if> style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='foldalChangeStat';">
			  	<input type="submit" class="btn col-xs-2" value="Töröl" style="max-width: 80px; margin-right: 5px;" onclick="javascript: form.action='foldalDelet';">
			</form>
		</div>
	</#list>
</#if>
	<div class="foldal-modosit-popup" id="foldal-modosit-popup">
		<div class="foldal-modosit-popup-subdiv col-xs-12">
			<form role="form" action="foldalModosit" method="post" name="popup-form">
				<input type="hidden" id="id" name="id"/>
				<input type="hidden" id="originalCim" name="originalCim"/>
			 	<div class="form-group">
			      <label for="cim"><p>Cím:</p></label>
				  <input required="true" type="text" class="form-control" id="cim" name="cim">
			   </div>
			   <textarea required="true" class="form-control" id="leiras" name="leiras" rows="6" ><div id="leirDiv" ></div></textarea>
				<!-- Initialize the editor. -->
			    <script>
					  $(function() {
					    $('textarea#leiras').froalaEditor({
					      height: 300,
					      language: 'hu',
					      direction: 'ltr',
					      toolbarButtons: ['fullscreen', 'bold', 'italic', 'underline', 'strikeThrough', 'subscript', 'superscript', 'fontFamily', 'fontSize', '|', 'color', 'paragraphStyle', '|', 'paragraphFormat', 'align', 'formatOL', 'formatUL', 'outdent', 'indent', '-', 'insertLink', 'insertImage', 'insertTable', '|', 'quote', 'insertHR', 'undo', 'redo', 'clearFormatting', 'selectAll', 'html']
					    })
					  });
					  $(function() { $('textarea').froalaEditor() });
				</script>
			 
			  <div class="row">
				   <div class="form-group col-xs-6">
					      <label for="date"><p>Megjelenés dátuma:</p></label>
					      <input type="date" class="form-control" id="date" name="date">
				  </div>
				   <div class="form-group col-xs-6">
					      <label for="dateTo"><p>Érvényesség vége:</p></label>
					      <input type="date" class="form-control" id="dateTo" name="dateTo">
				  </div>
			  </div>
			  <div class="row">
			  <div class="form-group col-xs-6">
					  <label for="nyelv"><p>Nyelv:</p></label>
					  <div class="form-group">          
						<select id="kategoria" name="nyelv" class="form-control">
								<option value="hun"><p>Magyar</p></option>
								<option value="eng"><p>Angol</p></option>
						</select>
					  </div>
				  </div>
				 <div class="form-group col-xs-6">
				 		<label for="autoOpen" class="btn active"><p>Automatikus nyitás</p></label>
				 		<input type="checkbox" id="autoOpen" name="autoO"/>
					</div>
				</div>
			  <button type="button" class="btn btn-default col-xs-3" style="margin-right: 10px;" id="submit-btn-foldal" onclick="submitForm('foldal-modosit-popup')">Módosít</button>
			  <button type="button" class="btn btn-default col-xs-3" id="cancel-btn-foldal" onclick="closeDiv('foldal-modosit-popup')">Mégsem</button>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	$('#foldal-modosit-popup').hover(function() {
	    $('html').css('overflow', 'hidden');
	}, function() {
	    $('html').css('overflow', 'auto');
	});
	</script>
</div>

<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">