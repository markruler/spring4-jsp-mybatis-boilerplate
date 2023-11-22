<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <title>User page</title>
</head>
<body>
<form name="fileinfo"
      action="/files"
      method="post"
      enctype="multipart/form-data">
    <input type="file" name="upload-file" />
    <input type="submit" value="Upload" />
</form>
</body>
</html>
