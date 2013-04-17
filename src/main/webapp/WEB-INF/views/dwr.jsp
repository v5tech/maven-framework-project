<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>dwr文件上传下载</title>
<script type='text/javascript' src='/maven-framework/dwr/interface/dwrFileUtil.js'></script>
<script type='text/javascript' src='/maven-framework/dwr/engine.js'></script>
<script type='text/javascript' src='/maven-framework/dwr/util.js'></script>
<script type="text/javascript">
//dwr文件下载
function downloadPdfFile() {
  var pdftext = dwr.util.getValue('pdftext');

  dwrFileUtil.downloadPdfFile(pdftext, function(data) {
    dwr.engine.openInDownload(data);
  });
  
}

//dwr文件上传

function uploadFiles() {
  var image = dwr.util.getValue('uploadImage');
  var file = dwr.util.getValue('uploadFile');
  var color = dwr.util.getValue('color');

  dwrFileUtil.uploadFiles(image, file, color, function(data) {
    dwr.util.setValue('image', data);
  });
}

</script>


</head>
<body>
<h1>dwr文件上传</h1>

<table>
  <tr>
    <th>Image:</th>
    <td><input type="file" id="uploadImage" size="30"/></td>
  </tr>
  <tr>
    <th>File:</th>
    <td><input type="file" id="uploadFile" size="30"/></td>
  </tr>
  <tr>
    <th>Color:</th>
    <td>#<input type="text" id="color" value="FFFFFF" size="7"/></td>
  </tr>
  <tr>
    <th></th>
  	<td>
      <button onclick="uploadFiles()">上传</button>
  	</td>
  </tr>
</table>

<img id="image" src="javascript:void(0);"/>
<hr/>
<h1>dwr文件下载</h1>

<input type="text" id="pdftext" value="Hello, World" size="20"/>
<button onclick="downloadPdfFile()">Download</button>













</body>
</html>