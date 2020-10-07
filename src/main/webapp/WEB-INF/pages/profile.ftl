<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Profile" "/static/css/profile.css" "">
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
                                    <img class="picture" src="/image?name=${userAvatar}">
                                </div>
                                <h3>${username}</h3>
                                <small class="label label-warning">Казань</small>
                            </div>
                        </div>
                    </div>
                    <form class="edit_button" action="/profile-edit">
                        <button class="edit_butt">&#9998; Редактировать профиль</button>
                    </form>
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
                                    <table class="table table-th-block">
                                        <tbody>
                                        <tr><td class="active">Электронная почта</td><td>${userEmail}</td></tr>
                                        <tr><td></td><td></td></tr>
                                        <tr><td class="active">Телефон</td><td>${userPhone}</td></tr>
                                        <tr><td></td><td></td></tr>
                                        <#if userGender??>
                                            <tr><td class="active">Пол:</td><td>${userGender}</td></tr>
                                            <tr><td></td><td></td></tr>
                                        </#if>
                                        <#if userAge != 0>
                                            <tr><td class="active">Полных лет:</td><td>${userAge}</td></tr>
                                        </#if>
                                        <tr><td></td><td></td></tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="tab-pane fade" id="contact">
                                    <p></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@common.bootstrap_common>