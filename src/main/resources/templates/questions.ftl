<#import "/spring.ftl" as spring />

<html>
<head>
    <title>Questions</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<table class="table thead-dark col-6 col-sm-4">
    <thead>
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
        <#list questions as question>
        <tr>
            <td>${question.id}</td>
            <td>${question.title}</td>
            <td><a href="/questions/edit/${question.id}" class="btn btn-primary">Edytuj</a></td>
            <td><a href="/questions/remove/${question.id}" class="btn btn-danger">Usun</a></td>
        </tr>
        </#list>
    </tbody>
</table>
<form action="/questions/add" method="post">
    <@spring.bind "question" />
    <div class="form-group">
        Tytuł:
        <@spring.formInput "question.title"/>
        <button type="submit" class="btn btn-success">Dodaj pytanie</button>
    </div>
</form>
</body>
</html>