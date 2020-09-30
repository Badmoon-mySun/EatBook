<#import "bases/authorization_base.ftl" as auth>

<@auth.auth "Registration" "/components/js/registration.js">
    <form action="${uri}" method="post" id="register" name="form" onsubmit="return validateForm()">
        <fieldset class="fields">
            <label for="name">Имя</label><input type="text" name="name" class="name" id="name" onkeyup="return proverkaName(this);" placeholder="Иван" pattern="^[А-Яа-яЁёA-Za-z]+$" required>
            <span></span><br>
            <label for="number">Телефон</label><input type="text" name="phone" class="name" id="number" onkeyup="return proverkaNumber(this);" placeholder="+79332221100" pattern="(\+7)+[0-9]{10}" required>
            <span> </span><br>
            <label for="email">Эл.почта</label><input type="email" name="email" class="name" id="email" placeholder="example@mail.com" required>
            <span></span><br>
            <label for="password">Пароль</label><input type=password name="password" id="password" placeholder="********" required><span></span><br>
            <label for="password">Повторите</label><input type="password" name="password2" id="password2" placeholder="********"><span></span>
        </fieldset>
        <fieldset class="fields second">
            <button class="button7" type="submit">Зарегистрироваться</button>
        </fieldset>
    </form>
</@auth.auth>