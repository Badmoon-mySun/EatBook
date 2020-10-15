<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Tables" "/static/css/tables.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="inform">
        <p>Список всех столиков:</p>
    </div>
    <div class="listtable">
        <#list tables as table>
            <div class="table">
                <div class="block1">
                    <p style="margin-left: 15px; font-size: 30px">Столик №${table.number}</p>
                    <p style="margin-left: 15px; font-size: 25px">Количество мест - ${table.seats}</p>
                    <h4 class="htext"><select>
                            <option class="intext">Вторник, 3 ноября</option>
                            <option class="intext">Среда, 4 ноября</option>
                            <option class="intext">Четверг, 5 ноября</option>
                            <option class="intext">Пятница, 6 ноября</option>
                            <option class="intext">Суббота, 7 ноября</option>
                            <option class="intext">Воскресенье, 8 ноября</option>
                        </select></h4>
                </div>
                <div class="block2">
                    <p><b>С какого времени вы хотите забронировать?</b></p>
                    <div class="bloc">
                        <p><input name="dzen" type="radio" value="dzen"> 9:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 10:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 11:00</p>
                        <p><input name="dzen" type="radio" value="nedzen"> 12:00</p>
                        <p><input name="dzen" type="radio" value="dzen"> 13:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 14:00</p>
                        <p><input name="dzen" type="radio" value="nedzen"> 15:00</p>
                        <p><input name="dzen" type="radio" value="dzen"> 16:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 17:00</p>
                        <p><input name="dzen" type="radio" value="nedzen"> 18:00</p>
                        <p><input name="dzen" type="radio" value="dzen"> 19:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 20:00</p>
                        <p><input name="dzen" type="radio" value="nedzen"> 21:00</p>
                        <p><input name="dzen" type="radio" value="dzen"> 22:00</p>
                        <p><input name="dzen" type="radio" value="pdzen"> 23:00</p>
                    </div>
                </div>
                <div class="block3">
                    <p style="margin-top: 8px; margin-left: 16px; font-size: 20px"><b>На сколько часов забронировать?</b></p>
                    <h4 class="htext" style="margin-left: 5px; margin-top: -20px;"><select>
                            <option class="intext">1 час</option>
                            <option class="intext">2 часа</option>
                            <option class="intext">3 часа</option>
                            <option class="intext">4 часа</option>
                            <option class="intext">5 часов</option>
                            <option class="intext">6 часов</option>
                        </select></h4>
                    <button style="margin-left: 20px; margin-top: 20px; font-size: 18px; border-radius: 10px" onclick="return display();">Забронировать столик</button>
                </div>
            </div>
        </#list>
    </div>
</@common.bootstrap_common>