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
        <title>Nhập</title>
    </head>
    <body>
        <form>
            <table>
                <tbody>
                    <tr>
                        <td>MSSP</td>
                        <td>
                            <input name="mssp" type="text" list="nameList"/>
                            <datalist id="nameList">
                                @{proname}
                                <option value="TenSP">mssp</option>
                            </datalist>
                        </td>
                    </tr>
                    <tr>
                        <td>Số Lượng</td>
                        <td><input name="soluong" type="text"/></td>
                    </tr>
<!--                    <tr>
                        <td>Đơn Vị</td>
                        <td><input type="text"/></td>
                    </tr>-->
<!--                    <tr>
                        <td>Giá</td>
                        <td><input type="text"/></td>
                    </tr>-->
                </tbody>
            </table>
            <button type="submit" formmethod="POST">Nhap SP</button>
        </form>
    </body>
</html>
