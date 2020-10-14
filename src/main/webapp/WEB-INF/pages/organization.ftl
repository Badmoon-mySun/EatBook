<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "${organization.name}" "/static/css/organization.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="bg">
        <div class="backpicture" style="
    background: linear-gradient( rgba(255, 255, 255, 0.8), rgba(0, 0, 0, 0.9)),
                url('/image?name=${organization.image}') no-repeat center center fixed;
    background-size: cover;">
            <div class="tittle">
                <h2><font size="2">${organization.type}</font></h2>
                <h4><font size="12">${organization.name}</font></h4>
            </div>
            <div class="svoist">
                <h4><font size="6">🌆 ${organization.address}</h4>
            </div>
        </div>
        <div class="rightinf">
            <p>Информация о ресторане:</p>
            <p style="font-size: 25px; padding: 12px 0">${organization.description}</p>
        </div>
    </div>
    <div class="list">
        <a href="listTable.html">
            <div class="listbutton">Забронировать свободные столики
            </div>
        </a>
    </div>
    <div class="secondinfo">
        <div class="comments">
            <div class="comments_heading">Все отзывы об этом ресторане:)</div>
            <#if user??>
                <form action="${uri}?id=${organization.id}" method="post">
                    <div class="comment_us">
                        <div class="commentinput">
                            <textarea name="review_text" placeholder="Можете оставить свой отзыв об этом заведении"></textarea>
                        </div>
                        <div class="commentbtn">
                            <button type="submit">Send</button>
                        </div>
                    </div>
                </form>
            <#else>
                <div class="comment_us">
                    <div class="commentinput">
                        <p><a href="/login">Войдите</a> в аккаунт, чтобы оставить отзыв</p>
                    </div>
                </div>
            </#if>
            <div class="commentsh">
                <#list reviews as review>
                    <div class="comment">
                        <div class="comment__image">
                            <img src="/image?name=${review.user.avatar}">
                        </div>
                        <div class="comment__inform">
                            <div class="comment__author">
                                <div class="author__name">${review.user.name}</div>
                                <div class="author__day">${review.date}</div>
                            </div>
                            <div class="comment__text">
                                <p>${review.text}</p>
                            </div>
                        </div>
                    </div>
                </#list>
            </div>
        </div>
    </div>
</@common.bootstrap_common>