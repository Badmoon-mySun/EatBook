<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Organizations" "/static/css/organizationsFeed.css" "js/search.js">
    <#include "bases/bootstrap_nav.ftl">
    <div class="mainInf">
        <div class="firstInf">
            <h1>Лучшие заведения Казани</h1>
        </div>

        <div class="cont">
            <form class="form" autocomplete="off">
                <div class="form-group">
                    <div class="col-sm-6 form-group NoPadding">
                        <input id="myInput" type="text" name="myCountry" class="form-control">
                    </div>
                    <div class="col-sm-3 form-group NoPadding">
                        <select name="Categories" class="form-control">
                            <option value="0"> All Categories</option>
                            <option value="1">Electronics</option>
                            <option value="2">Food</option>
                            <option value="3">Furniture</option>
                        </select>
                    </div>
                    <div class="col-sm-2 frm-group ">
                        <input type="submit" class="form-control btn-primary">
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="mainCard">
        <#list organizations as org>
            <div class="card" style="width: 350px">
                <div class="border">
                    <div class="wrap">
                        <div class="product-wrap">
                            <a href=""><img class="imgCard" src="/image?name=${org.image}"></a>
                        </div>
                        <div class="loop-action">
                            <a class="add-to-cart">${org.type}</a>
                            <a href="/organization?id=${org.id}" class="loop-add-to-cart">Подробнее</a>
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