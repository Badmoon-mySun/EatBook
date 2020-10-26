<#import "bases/bootstrap_common.ftl" as common>
<#import "bases/bootstrap_nav.ftl" as nav>

<@common.bootstrap_common "Tables" "/static/css/tables.css" "">
    <#include "bases/bootstrap_nav.ftl">
    <div class="order_success">
        <div class="order_info">Столик успешно забронирован, менеджер заведения вскоре свяжется с вами для уточнения
            деталей бронирования</div>
    </div>
</@common.bootstrap_common>