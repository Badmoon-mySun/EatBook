<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Discount" "/static/css/discount-page.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="bg">
        <div class="backpicture" style="
            background: linear-gradient( rgba(255, 255, 255, 0.8), rgba(0, 0, 0, 0.9)),
                url('/image?name=${discount.image}') no-repeat center center fixed;
            background-size: cover;">
            <div class="typetext">
                <h1><font size="20">${discount.title}</font></h1>
                <div class="padd" style="padding: 10px">
                    <h3><font>${discount.organization.type}: ${discount.organization.name}</font></h3>
                    <h4 style="margin-top: 20px;">До ${discount.date}</h4>
                </div>
            </div>
        </div>
    </div>
    <div class="buttons">
        <a class="edit_butt" href="/organization?id=${discount.organization.id}">
            <div class="buttonCreate" style="width: 300px;"><font size="5px">Перейти к ресторану</font></div>
        </a>
        <a class="butt" href="/discounts"><div class="buttonCreate" style="width: 230px;"><font size="5px">Вернуться</font></div></a>
    </div>
    <div class="iinfo">
        <h2>Описание</h2>
        <h4>${discount.info}</h4>
    </div>
</@common.bootstrap_common>