<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Profile" "/static/css/profile.css" "/static/js/registration.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="container">
        <div id="main">
            <div class="row" id="real-estates-detail">
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <header class="panel-title">
                                <div class="text-center">
                                    <strong>Пользователь сайта</strong>
                                </div>
                            </header>
                        </div>
                        <div class="panel-body">
                            <div class="text-center" id="author">
                                <div class="picture">
                                    <img class="picture" src="/image?name=${user.avatar}">
                                </div>
                                <h3>${user.name}</h3>
                                <small class="label label-warning">Казань</small>
                                <form action="/user-avatar-upload" enctype="multipart/form-data" method="post">
                                    <p><input type="file" name="avatar" accept=".jpg, .jpeg, .png"
                                              onchange="this.form.submit();" style="padding: 30px">
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8 col-md-8 col-xs-12">
                    <div class="panel">
                        <div class="panel-body">
                            <ul id="myTab" class="nav nav-pills">
                                <li class="active"><a data-toggle="tab">О пользователе</a></li>
                            </ul>
                            <div id="myTabContent" class="tab-content">
                                <hr>
                                <div class="tab-pane fade active in" id="detail">
                                    <table class="table">
                                        <form action="${uri}" method="post" id="edit_register" name="form" class="fontform" onsubmit="return validateForm2()">
                                            <#if error??>
                                                <div style="font-size: 16px; color: red;">${error}</div>
                                            </#if>
                                            <h4 class="htext">Имя<input cols="30" rows="1" value="${user.name}" name="username" id="name" onkeyup="return proverkaName(this);" class="intext" pattern="^[А-Яа-яЁёA-Za-z]+$" required></h4>
                                            <h4 class="htext">Телефон<input type="text" value="${user.phone}" name="phone" class="intext" id="number" onkeyup="return proverkaNumber(this);" placeholder="+79332221100" pattern="(\+7)+[0-9]{10}" required></h4>
                                            <h4 class="htext">Полных лет<textarea cols="30" rows="1" name="age" id="age" class="intext"
                                                                                  onkeyup="return proverkaAge(this);"><#if user.age != 0>${user.age}</#if></textarea></h4>
                                            <h4 class="htext">Пол<select name="gender">
                                                                    <option <#if user.gender?? && user.gender == "Man">selected</#if> value="Man" class="intext">Man</option>
                                                                    <option <#if user.gender?? && user.gender == "Woman">selected</#if> value="Woman" class="intext">Woman</option>
                                                                </select>
                                            </h4>
                                            <button class="edit_butt" type="submit" style="margin-top: 30px">Применить изменения</button>
                                        </form>
                                    </table>
                                    <div class="edit_second">
                                        <a class="edit_butt" href="/profile">Отменить</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@common.bootstrap_common>