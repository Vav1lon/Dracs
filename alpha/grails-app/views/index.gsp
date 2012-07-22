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
                <singleline label="Title"><a
                        href="<g:createLink url="/alpha/preUpload"/>">Загрузить новый фаил</a>
                </singleline>
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
            <table width="100%" border="0" cellspacing="2" cellpadding="2">
                <th>Номер в базе</th>
                <th>Имя файла</th>
                <th>Расширение файла</th>
                <th>Автор</th>
                <th>Размер</th>
                <g:each in="${files}" var="file">
                    <tr>
                        <td style="text-align:center"><multiline label="Title">${file.id}</multiline></td>
                        <td style="text-align:center"><a href="<g:createLink controller="file" action="info"
                                                   params="[id: file.id]"/>">${file.name}</a>
                        </td>
                        <td style="text-align:center">${file.extension}</td>
                        <td style="text-align:center">me</td>
                        <td style="text-align:center">${file.size}</td>
                    </tr>
                </g:each>
            </table>
        </td>
    </tr>
</table>
<!--/content section-->