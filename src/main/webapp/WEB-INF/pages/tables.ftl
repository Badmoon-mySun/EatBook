<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Tables" "/static/css/tables.css" "/static/js/tables3.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="inform">
        <p>Список всех столиков:</p>
    </div>
    <div class="listtable">
        <#list tables as table>
            <div id="${table.number}" class="table">
                <div class="block1">
                    <p style="margin-left: 15px; font-size: 30px">Столик №${table.number}</p>
                    <p style="margin-left: 15px; font-size: 25px">Количество мест - ${table.seats}</p>
                    <h4 class="htext">
                        <select name="day" id="table-${table.number}-day" onchange="sendAjax(${table.number}, ${table.id})">
                            <#list days as day>
                                <option class="intext">${day}</option>
                            </#list>
                        </select>
                    </h4>
                </div>
                <div class="block2">
                    <p><b>С какого времени вы хотите забронировать?</b></p>
                    <div id="table-${table.number}-time" class="bloc"></div>
                </div>
                <div class="block3">
                    <p style="margin-top: 8px; margin-left: 16px; font-size: 20px"><b>На сколько часов забронировать?</b></p>
                    <h4 class="htext" style="margin-left: 5px; margin-top: -20px;">
                        <select name="hour" id="table-${table.number}-hours" onchange="sendAjax(${table.number}, ${table.id})">
                            <option class="intext" value="1">1 час</option>
                            <option class="intext" value="2">2 часа</option>
                            <option class="intext" value="3">3 часа</option>
                            <option class="intext" value="4">4 часа</option>
                            <option class="intext" value="5">5 часов</option>
                            <option class="intext" value="6">6 часов</option>
                        </select></h4>
                    <button style="margin-left: 20px; margin-top: 20px; font-size: 18px; border-radius: 10px">Забронировать столик</button>
                </div>
            </div>
        </#list>
    </div>
</@common.bootstrap_common>