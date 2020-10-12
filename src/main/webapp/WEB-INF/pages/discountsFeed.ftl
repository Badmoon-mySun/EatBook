<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Discounts" "/static/css/discount.css" "/static/js/slider.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="mainInf">
        <div class="firstInf">
            <h1>Акции и скидки</h1>
        </div>
        <div class="slider">
            <div class="slider__wrapper">
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/5.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/2.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/3.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/4.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/6.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/7.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
                <div class="slider__item">
                    <div style="height: 450px; background: url('/static/image/8.jpg') top right no-repeat;
                            background-size: cover;"></div>
                </div>
            </div>
            <a class="slider__control slider__control_left" href="#" role="button"></a>
            <a class="slider__control slider__control_right slider__control_show" href="#" role="button"></a>
        </div>

        <div class="mainCard">
            <#list discounts as discount>
                <div class="card" style="width: 350px">
                    <div class="border">
                        <div class="wrap">
                            <div class="product-wrap">
                                <a href=""><img class="imgCard" src="/image?name=${discount.image}"></a>
                            </div>
                            <div class="loop-action">
                                <a href="/discount?id=${discount.id}" class="loop-add-to-cart">Перейти к акции</a>
                            </div>
                        </div>
                        <div class="product-info">
                            <h5 style="color: #b01030;">${discount.title}</h5>
                            <h5 style="color: #b01030;">${discount.organization.type}:</h5>
                            <h3 class="product-title">${discount.organization.name}</h3>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    <div>
</@common.bootstrap_common>