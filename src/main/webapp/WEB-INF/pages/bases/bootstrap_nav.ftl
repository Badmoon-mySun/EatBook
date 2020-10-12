<div class="polovina1">
    <nav class="navbar navbar-dark bg-company-red">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Навигация</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/home">EatBook</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/home">Главная</a></li>
                    <li><a href="/organizations">Места</a></li>
                    <li><a href="/discounts">Акции и скидки</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Профиль<b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li class="divider"></li>
                            <li><a href="/profile">Мой профиль</a></li>
                            <#if username??>
                                <li class="divider"></li>
                                <li><a href="/logout">Выйти из профиля</a></li>
                            </#if>
                        </ul>
                    </li>
                    <li><a href="/aboutus">Контакты</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <#if username??>
                        <li>
                            <a href="/profile">Здравствуйте, ${username}</a>
                        </li>
                    <#else>
                        <li>
                            <a href="/login">Войти</a>
                        </li>
                        <li class="dropdown">
                            <a href="/registration">Зарегистрироваться</a>
                        </li>
                    </#if>
                </ul>
            </div>
        </div>
    </nav>
</div>
