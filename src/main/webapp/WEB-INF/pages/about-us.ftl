<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Home" "/static/css/about-us.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="log">
        <div class="blog" style="">
            <div class="beforeblog">
                <div class="blueInfo" style="text-align: center;"><font size="22">О нас</font></div>
            </div>
            <div class="eatimage" style="text-align: center;">
                <img src="/static/image/eatbook.jpg" style="width: 250px; height: 210px">
                <h3>EatBook</h3>
            </div>
            <h5 style="width: 220px; margin-top: 22px;">
                <p><font size="4">Для гостей наш сервис бесплатен и никак не влияет на счет -
                        мы получаем комиссию от ресторанов. </font></p>
                <p><font size="4"> Мы делаем бронирование удобным и надежным - минимум ожидания,
                        никаких занятых телефонов и полный контроль на всех этапах.
                    </font></p>
            </h5>
        </div>

        <div class="blog">
            <div class="tect" style="text-align: center;">
                <img class="photoimage" src="/static/image/danil.jpg" style="width: 250px; height: 230px">
                <h4>Данил Поварницин</h4>
                <h4>Front-End</h4>
            </div>
            <div class="tect" style="text-align: center;">
                <img class="photoimage" src="/static/image/anvar.jpg" style="width: 250px; height: 230px">
                <h4>Анвар Хасанов</h4>
                <h4>Back-End</h4>
            </div>
            <div class="beforeblog">
                <div class="blueInfo" style="text-align: center;"><font size="22">Наша команда</font></div>
            </div>
        </div>

        <div class="blog" style="">
            <div class="beforeblog">
                <div class="blueInfo" style="text-align: center;"><font size="22">Связаться с нами</font></div>
            </div>
            <div class="diform">
                <form action="${uri}" method="post" name="form">
                    <input name="name" type="text" placeholder="Ваше имя" />
                    <input name="email" type="text" placeholder="Ваша почта" /><br>
                    <label>Выберите тему сообщения
                        <select class="categories" name="theme">
                            <option>Предложения по сайту</option>
                            <option>Замечания по сайту</option>
                            <option>Другое</option>
                        </select>
                    </label>
                    <br><textarea cols="32" name="message" rows="3" placeholder="Текст сообщения"></textarea>
                    <br><input type="submit" value="Отправить" />
                </form>
            </div>
        </div>
    </div>
</@common.bootstrap_common>