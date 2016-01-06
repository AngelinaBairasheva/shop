<#-- @ftlvariable name="endedCategories" type="java.util.List<ru.dz.labs.api.domain.Categories>" -->
<#macro footer>
<footer id="footer">
    <div class="decoration-line"></div>
    <div class="center-wrapper">
        <div class="bottom-contacts">
            <div class="head-line">Контакты</div>
            <div class="block-contacts">
                <div class="head-line">
                    Индивидуальные заказы<br>
                    Поставки в магазины и рестораны
                </div>
                E-mail <a href="mailto:prsnl.angelina@gmail.com">prsnl.angelina@gmail.com</a>				</div>
        </div>

        <div class="bottom-menu">
            <div class="head-line">Продукция</div>
            <ul><#assign x=0>
                <#list endedCategories as category>
                <#if x%5==0></ul><ul><#else >
                <li><a href="/catalog/${category.name}/1">${category.name}</a></li> </#if>
                    <#assign x=x+1>
                </#list>
            </ul>

            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>

</footer>
</#macro>