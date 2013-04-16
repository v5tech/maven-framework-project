<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
function downloadPdfFile() {
  var pdftext = dwr.util.getValue('pdftext');

  UploadDownload.downloadPdfFile(pdftext, function(data) {
    dwr.engine.openInDownload(data);
  });
  
}

</script>


</head>
<body>
<input type="text" id="pdftext" value="Hello, World" size="20"/>
<button onclick="downloadPdfFile()">Download</button>













</body>
</html>