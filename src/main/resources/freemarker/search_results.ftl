<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
</head>

<body>
<h1>Results:</h1>
<#list vacancies as job>
    <h2>${job["title"]}</h2>
    <p>Company: ${job["company"]}</p>
    <p>Description: ${job["description"]}</p>
    <p>Producer: ${job["producer"]}</p>
    <p>Salary: ${job["salary"]}</p>
    <p>Location: ${job["location"]}</p>
</#list>
</body>
</html>