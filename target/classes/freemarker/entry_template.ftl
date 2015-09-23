<!DOCTYPE html>

<html>
<head>
    <title>Searcher main</title>
    <style type="text/css">
        .label {text-align: right}
    </style>
</head>
<body>
<h1>Welcome!</h1>

<p>
</p>

<form method="post">
    <table>
        <tr>
            <td class="label">Job title</td>
            <td>
                <input type="text" name="title" value="${defaultTitle}">
            </td>
        </tr>
        <tr>
            <td class="label">Country</td>
            <td>
                <input type="text" name="country" value="${defaultCountry}">
            </td>
        </tr>
    </table>
    <input type="submit">
</form>
</body>
</html>