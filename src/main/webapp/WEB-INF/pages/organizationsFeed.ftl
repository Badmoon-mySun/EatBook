<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Organizations" "/static/css/organizationsFeed.css" "/static/js/search1.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="mainInf">
        <div class="firstInf">
            <h1>Лучшие заведения Казани</h1>
        </div>

        <div class="cont">
            <form class="form" autocomplete="off">
                <div class="form-group">
                    <div class="col-sm-6 form-group NoPadding">
                        <input id="myInput" type="text" class="form-control">
                    </div>
                    <div class="col-sm-3 form-group NoPadding">
                        <select id="category" class="form-control">
                            <option value="all">Все категории</option>
                            <option value="restoran">Рестораны</option>
                            <option value="cafe">Кафе</option>
                        </select>
                    </div>
                    <div class="col-sm-2 frm-group ">
                        <input type="button" onclick="sendAjax($('#myInput').val(), $('#category').val())"
                               class="form-control btn-primary" >
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="mainCard" id="content"></div>
</@common.bootstrap_common>