<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Job searcher</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">

</head>


<c:forEach items="${vacancyList}" var="vacancy">
<li id="vacancy_<c:out value="vacancy.id" />">
    <div class="col-sm-4">
        <div class="panel panel-success">
            <div class="panel-heading">
                <h3 class="panel-title"><strong>
                    <c:out value="${vacancy.title}"/>
                </strong></h3>
            </div>
            <div class="panel-body">
                <c:out value="${vacancy.description}"/>
                <hr>
                <div class="alert alert-success" role="alert">
                    <strong>Salary: <c:out value="${vacancy.salary}"/></strong>
                </div>
                <div class="alert alert-info" role="alert">
                    <strong>Employer: <c:out value="${vacancy.employer}"/></strong>
                </div>
                <div class="alert alert-warning" role="alert">
                    <strong>Location: SPb</strong>
                </div>

            </div>
        </div>
    </div>
</c:forEach>

</body>
