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
        <td background="../../images/header-bg.jpg" bgcolor="#c6d2db" valign="middle" align="center" height="79">
            <h1>
                <singleline label="Title">информация по ${fileInfo.name}</singleline>
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
        <td valign="top" bgcolor="#1c3851" background="../../images/content-bg.jpg"
            style="border: solid 1px #193044; border-radius: 8px; -moz-border-radius: 8px; -webkit-border-radius: 8px; -khtml-border-radius: 8px;">
            <table border="1" width="100%" cellpadding="0" cellspacing="1">
                <g:each in="${fileInfo.attributes}" var="fi">
                    <tr>
                        <td>${fi.key}</td>
                        <td>${fi.value}</td>
                    </tr>
                </g:each>
            </table>

            <br>
            <span style="text-align:center"><singleline label="Description">Материалы</singleline></span>
            <br>

            <table border="1" width="80%" cellpadding="0" cellspacing="1">
                <g:each in="${fileInfo.materials}" var="fi">
                    <tr>
                        <td>${fi.name}</td>
                        <td>${fi.description}</td>
                    </tr>
                </g:each>
            </table>
            <br>
            <a href="<g:createLink controller="file" action="index"/>">Вернутся к списку</a>
        </td>
    </tr>
</table>
<!--/content section-->