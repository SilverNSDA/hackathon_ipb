<%-- 
    Document   : nhap
    Created on : May 25, 2018, 10:58:41 PM
    Author     : SIlver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa</title>
    </head>
    <body>
        <form>
            <table>
                <tbody>
                    <tr>
                        <td>MSSP</td>
                        <td>
                            @{proid}
                        </td>
                    </tr>
                    <tr>
                        <td>Tên SP</td>
                        <td>
                            @{proname}
                        </td>
                    </tr>
                    <tr>
                        <td>Số Lượng</td>
                        <td>@{soluong}</td>
                    </tr>
                    <tr>
                        <td>Đơn Vị</td>
                        <td><input name="donvi" type="text"/></td>
                    </tr>
                    <tr>
                        <td>Giá</td>
                        <td><input name="gia" type="text"/></td>
                    </tr>
                </tbody>
            </table>
            <button type="submit" formmethod="PUT">Sửa SP</button>
        </form>
    </body>
</html>
