<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>

<body>
<h1>Results:</h1>
<#list vacancies as job>
    <h2>Job name</h2>
    <p>${job["name"]}</p>
    <p/>
</#list>
</body>
</html>