 <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Collapsible sidebar using Bootstrap 3</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="style2.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">



    <nav class="navbar navbar-light bg-light">
        <form class="container-fluid justify-content-start" >
            <button class="btn btn-outline-success me-2" type="submit" formaction="${pageContext.request.contextPath}/">Home</button>
            <button class="btn btn-outline-success me-2" type="submit" formaction="${pageContext.request.contextPath}/page2">Page 2</button>
        </form>
    </nav>


    <title><tiles:getAsString name="title"/></title>
</head>
<body>
<table>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <div class="wrapper">
        <td>
            <tiles:insertAttribute name="body" />
        </td>
        </div>
    </tr>
    <tr>
        <td colspan="2">
            <tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>