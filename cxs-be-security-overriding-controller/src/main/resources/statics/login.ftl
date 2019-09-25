<html>

<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous"/>
</head>
<#if ERROR_MESSAGE??><p><span style="color: red; ">Your login attempt was not successful, try again.<br/><br/>Reason:${ERROR_MESSAGE}</span></p></#if>
<body class="text-center container">
<form class="form-signin" action="${LOGIN_PAGE_URL}" method="POST">
    <img class="w-25" src='https://pbs.twimg.com/profile_images/464394309337223169/a9y5kaLO_400x400.png' />
    <div class="col-12 mb-4">
        <label for="inputUsername" class="sr-only">Username</label>
        <input type="text" id="inputUsername" class="form-control" placeholder="Username" name="${USERNAME_FIELD}" required="" autofocus="">
    </div>
    <div class="col-12 mb-4">
        <label for="email" class="sr-only">Email</label>
        <input type="email" id="email" class="form-control" placeholder="email" name="${EMAIL_FIELD}" required autofocus="">
    </div>
    <div class="col-12 mb-4">
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" name="${PASSWORD_FIELD}" placeholder="Password" required="">
    </div>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>
</body>

</html>