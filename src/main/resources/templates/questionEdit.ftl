<#import "/spring.ftl" as spring />

<html>
<head>
    <title>Edit Question</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<form action="/questions/edit" method="post">
    <@spring.bind "question" />
    <div class="form-group">
        ID:
        <@spring.formInput "question.id" "disabled" />
        Tytuł:
        <@spring.formInput "question.title"/>
        <button type="submit" class="btn btn-success">Zapisz</button>
    </div>
</form>
</body>
</html>