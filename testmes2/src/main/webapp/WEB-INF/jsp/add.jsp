<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>::: Spring with MyBatis :::</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript">
        function insert() {
            document.getElementById('form').submit();
        };
    </script>
</head>

<body>
    <h3>ê°ê² ë±ë¡</h3>

    <form id="form" name="form" action="<c:url value="add" />" method="post">
        <table style="width: 100%;" border="1">
            <thead>
                <tr>
                    <th width="10%">구분</th> 
                    <th>ë´ì©</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="text-align: center;">제품 명</td>
                    <td style="text-align: left;">
                        <input type="text" id="prodName" name="prodName"
							style="width: 200px;" />
                    </td>
                </tr>
                <tr>
                    <td style="text-align: center;">수량</td>
                    <td style="text-align: left;">
                        <input type="text" id="amount" name="amount" 
                        	style="width: 200px;" />
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

    <div style="text-align: right; padding-top: 10px;">
        <input type="button" id="button_insert" name="button_insert"
            value="등록" title="등록" onclick="insert();" />
        <a href="<c:url value="/shop/list" />">
            <input type="button" id="button_list" name="button_list"
                value="목록" />
        </a>
    </div>
</body>
</html>
