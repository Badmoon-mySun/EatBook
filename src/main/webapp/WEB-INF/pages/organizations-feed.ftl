<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Organizations" "/static/css/organizationsFeed.css" "/static/js/search11.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="mainInf">
        <div class="firstInf">
            <h1>Заведения Казани</h1>
        </div>

        <div class="cont">
            <form class="form" autocomplete="off">
                <div class="form-group">
                    <div class="col-sm-6 form-group NoPadding">
                        <input id="myInput" type="text" class="form-control">
                    </div>
                    <div class="col-sm-3 form-group NoPadding">
                        <select id="category" class="form-control">
                            <option value="">Все категории</option>
                            <option value="Ресторан">Рестораны</option>
                            <option value="Кафе">Кафе</option>
                        </select>
                    </div>
                    <div class="col-sm-2 frm-group ">
                        <input type="button" value="Отправить" onclick="sendAjax($('#myInput').val(), $('#category').val())"
                               class="form-control btn-primary" >
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="mainCard" id="content">
        <#list organizations as org>
            <div class="card" style="width: 350px">
                <div class="border">
                    <div class="wrap">
                        <div class="product-wrap">
                            <a href=""><img class="imgCard" src="/image?name=${org.image}"></a>
                        </div>
                        <div class="loop-action">
                            <a class="add-to-cart">${org.type}</a>
                            <a href="/organization?id=${org.id}" class="loop-add-to-cart">More details</a>
                        </div>
                    </div>
                    <div class="product-info">
                        <h3 class="product-title">${org.name}</h3>
                        <div class="price">${org.address}</div>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</@common.bootstrap_common>