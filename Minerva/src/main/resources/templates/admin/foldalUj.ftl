<meta charset="utf-8">
<#include "header.ftl">
<div class="main-div container">
	<div class="admin-div">
		<center><h1>Új bejegyzés</h1></center>	
	</div>
	<div class="row">
		
		<#include "adminMenu.ftl">
<!-- ez a kód -->
		
			<div class="admin-div">
				<form role="form" action="foldalUj" method="post">
				 <div class="form-group">
				      <label for="cim"><p>Cím:</p></label>
					  <input required="true" type="text" class="form-control" id="cim" name="cim" value="<#if result??>${result.cim}</#if>" placeholder="Cím">
				   </div>
				   <textarea required="true" class="form-control" id="leiras" name="leiras" rows="10"><#if result??>${result.leiras}</#if></textarea>
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
						      <input type="date" class="form-control" id="date" name="date" value="<#if result??>${result.date}</#if>">
					  </div>
					   <div class="form-group col-xs-6">
						      <label for="dateTo"><p>Érvényesség vége:</p></label>
						      <input type="date" class="form-control" id="dateTo" name="dateTo" value="<#if result??>${result.dateTo}</#if>">
					  </div>
				  </div>
				  <div class="row">
				  <div class="form-group col-xs-6">
						  <label for="nyelv"><p>Nyelv:</p></label>
						  <div class="form-group">          
							<select id="kategoria" name="nyelv" class="form-control" value="<#if result??>${result.nyelv}</#if>">
									<option value="hun"><p>Magyar</p></option>
									<option value="eng"><p>Angol</p></option>
							</select>
						  </div>
					  </div>
					 <div class="form-group col-xs-6">
					 		<label for="autoOpen" class="btn active"><p>Automatikus nyitás</p></label>
					 		<#if result??>
					 			<#if result.autoOpen == 1 >
					 				<input type="checkbox" id="autoOpen" name="autoO" checked/>
					 				<#else>
					 					<input type="checkbox" id="autoOpen" name="autoO" />	
					 			</#if>
					 			<#else>
					 				<input type="checkbox" id="autoOpen" name="autoO" />
					 		</#if>
						</div>
					</div>
				  <button type="submit" class="btn btn-default">Létrehoz</button>
				  <a href="/admin?pageName=foldalUj"><input type="button" class="btn btn-default" value="Újra"/></a>
			</form>
			</div>
<!-- ez a vége -->
		</div><!-- admin function -->
	</div><!-- row -->
</div><!-- main -->

<#include "footer.ftl">