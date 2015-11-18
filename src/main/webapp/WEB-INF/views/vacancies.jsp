<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Job searcher</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">

</head>
<h1>Amount of vacancies:</h1>
<h2>${count}</h2>

<c:forEach var="vacancy" items="${vacancyList}">
    <div class="raw">
        <div class="col-sm-4">
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        <strong>
                            <c:out value="${vacancy.title}"/>
                        </strong>
                    </h3>
                </div>
                <div class="panel-body">
                    ${description}
                    <hr>
                    <div class="alert alert-success" role="alert">
                        <strong>Salary: <c:out value="${vacancy.salary}"/></strong>
                    </div>
                    <div class="alert alert-info" role="alert">
                        <strong>Employer: <c:out value="${vacancy.employer}"/></strong>
                    </div>
                    <div class="alert alert-warning" role="alert">
                        <strong>Location: <c:out value="${vacancy.country}"/></strong>
                    </div>

                </div>
            </div>
        </div>
    </div>
</c:forEach>


</body>
