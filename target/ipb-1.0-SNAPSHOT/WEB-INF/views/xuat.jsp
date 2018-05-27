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
        <title>Xuất</title>
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
                        <td><input type="text" name="soluong"/></td>
                    </tr>
                    <tr>
                        <td>Đơn Vị</td>
                        <td>@{donvi}</td>
                    </tr>
                    <tr>
                        <td>Giá</td>
                        <td>@{gia}</td>
                    </tr>
                </tbody>
            </table>
            <button type="submit" formmethod="PUT">Xuất</button>
        </form>
    </body>
</html>
