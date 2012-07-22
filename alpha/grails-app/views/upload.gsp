<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
</head>

<!--intro-->
<table width="578" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td valign="top" height="20"></td>
    </tr>
    <tr>
        <td background="images/header-bg.jpg" bgcolor="#c6d2db" valign="middle" align="center" height="79">
            <h1>
                <singleline label="Title">Загрузка нового файла</singleline>
            </h1>
        </td>
    </tr>
    <tr>
        <td valign="top" height="20"></td>
    </tr>
</table>
<!--/intro-->
<!--content section-->
<table width="1024" border="0" align="center" cellpadding="20" cellspacing="0">
    <tr>
        <td valign="top" bgcolor="#1c3851" background="images/content-bg.jpg" style="border: solid 1px #193044; border-radius: 8px; -moz-border-radius: 8px; -webkit-border-radius: 8px; -khtml-border-radius: 8px;">
            <span style="text-align:center"><g:form controller="file" action="upload" method="post" enctype="multipart/form-data">
                <input type="file" name="drawingFile" />
                <br>
                <br>
                <input type="submit" value="Upload" />
                <br>
            </g:form>
            </span>
        </td>
    </tr>
</table>
<!--/content section-->