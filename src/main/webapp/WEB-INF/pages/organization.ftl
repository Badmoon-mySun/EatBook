<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "${organization.name}" "/static/css/organization.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="bg">
        <div class="backpicture">
            <div class="tittle">
                <h2><font size="2">${organization.type}</font></h2>
                <h4><font size="12">${organization.name}</font></h4>
            </div>
            <div class="svoist">
                <h4><font size="6">🌆 ${organization.address}</h4>
                <h4 style="margin-top: 10px;"><font size="6">💳 1000 &#8381;</h4>
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
            <div class="comment_us">
            </div>
            <div class="comments_heading">Все отзывы об этом ресторане: (4)</div>
            <div class="comment_us">
                <form action="${uri}" method="post">
                    <div class="commentinput">
                        <textarea name="comment" placeholder="Можете оставить свой отзыв об этом заведении"></textarea>
                    </div>
                    <div class="commentbtn">
                        <button type="submit">Send</button>
                    </div>
                </form>
            </div>
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