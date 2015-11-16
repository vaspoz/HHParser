<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html>
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

  <body>

    <div class="container">

      <form class="form-signin" method="post">
        <h2 class="form-signin-heading">Enter query</h2>
        <label for="inputTitle" class="sr-only">Title</label>
        <input type="text" id="inputTitle" name="title" class="form-control" placeholder="Title" required autofocus>
        <label for="inputCountry" class="sr-only">Country</label>
        <input type="text" id="inputCountry" name="country" class="form-control" placeholder="Country" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Search</button>
      </form>

    </div> <!-- /container -->

    ${title}
    ${country}

  </body>
</html>
