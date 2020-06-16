
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <style>
        .card{
            margin: 100px auto;
            padding: 20px;
            width: 400px;
        box-shadow: 0px 0px 10px silver;
            background-color: white;
        }
    </style>
</head>
<body>
<div class="card">
    <form action="logoutProcess" method="get">
    <div style="width:200px;margin:0px auto">
        <img src="https://www.pngmart.com/files/10/Business-User-Account-PNG-Photos.png" width="100%">
    </div>
    <div style="padding:10px 5px">
        ${name}<br><br>
        ${address}<br><br>
        ${email}<br><br>
        <div style="padding:20px;text-align: center">
            <input type="submit" name="submit" value="Logout">

<%--
            <a style="padding:10px;text-decoration: none;color:white;background-color: blueviolet;border-radius: 10px;" href="login">Logout</a>
--%>
        </div>

    </div>
</div>
</form>
</body>
</html>
