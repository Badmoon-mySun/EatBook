<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Home" "/static/css/menues.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="bg">
        <div class="backpicture">
        </div>
    </div>

    <div class="main_inf">
        <h4 class="">№1 в России</h4>
    </div>

    <div class="information">
        <h1 class="infMain">Бесплатная программа для ресторанов и кафе</h1>


        <div class="secondInformation">
            <h1 style="color: black">Форматы меропроиятий</h1>

            <div class="cardInt">
                <div class="card" style="width: 320px;">
                    <img class="tn-atom__img" src=https://static.tildacdn.com/tild6435-6161-4234-a166-376432653739/engagement.svg style="width:40%; height: 100px">
                    <div class="container">
                        <h4><b>Свадьбы</b></h4>
                    </div>
                </div>

                <div class="card" style="width: 320px">
                    <img class="tn-atom__img" src="https://static.tildacdn.com/tild3633-3732-4338-b766-633931653239/glasses.svg" style="width:40%; height: 100px">
                    <div class="container">
                        <h4><b>Банкеты</b></h4>
                    </div>
                </div>

                <div class="card" style="width: 320px">
                    <img class="tn-atom__img" src="https://static.tildacdn.com/tild6366-3663-4566-a437-373764623536/balloon.svg" style="width:40%; height: 100px">
                    <div class="container">
                        <h4><b>Корпоративы</b></h4>
                    </div>
                </div>
            </div>
            <div class="cardInt">

                <div class="card" style="width: 320px">
                    <img class="tn-atom__img" src="https://static.tildacdn.com/tild6338-6334-4438-b335-636437333562/buffet.svg" style="width:40%; height: 100px;">
                    <div class="container">
                        <h4><b>Фуршеты</b></h4>
                    </div>
                </div>


                <div class="card" style="width: 320px">
                    <img class="tn-atom__img" src="https://static.tildacdn.com/tild3730-3462-4565-a163-333033393433/conference_3.svg" style="width:40%; height: 100px">
                    <div class="container">
                        <h4><b>Конференции</b></h4>
                    </div>
                </div>

                <div class="card" style="width: 320px">
                    <img class="tn-atom__img" src="https://static.tildacdn.com/tild3639-3637-4363-b932-323539326462/coffee-cup.svg" style="width:40%; height: 100px">
                    <div class="container">
                        <h4><b>Кофе-брейки</b></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@common.bootstrap_common>