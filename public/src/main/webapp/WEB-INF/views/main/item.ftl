<#-- @ftlvariable name="item" type="ru.dz.labs.api.domain.Goods" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate />
<#macro m_body>
<head>	<title></title></head>
<div id="center">
    <div class="min-margin">
        <div class="center-wrapper">
            <div class="breadcrumbs"><a href="/" title="Главная страница">Главная страница</a> / <a href="/catalog/" title="Каталог">Каталог</a> / <a href="/catalog/${item.category.name}" title="${item.category.name}">${item.category.name}</a>
                / ${item.name}</div>
            <h1><span>${item.name}</span></h1>
            <p><#if item.description??>${item.description}</#if></p>
            <article class="catalog-item-detail">
                <div class="img-holder"><img src=${item.image} /></div>

                <form action="/addToCart" method="post">
                <div class="description">
                    <h1>${item.name}</h1>
                    <#if item.byorder=true>
                    <span class="red">
				Под заказ
				</span></#if>
                    <div class="params">
                        <#if item.packaging??>
                        <div class="param-row">
                            <label>Упаковка</label>
                            <div class="param-value">${item.packaging}<br />
                            </div>
                        </div></#if>
                        <div class="param-row">
                            <label>Вес</label>
                            <div class="param-value">${item.weight}гр<br />
                            </div>
                        </div>
                        <div class="param-row">
                            <label>Артикул</label>
                            <div class="param-value">${item.vendor_code}</div>
                        </div>
                        <#if item.brand??>
                        <div class="param-row">
                            <label>Брэнд</label>
                            <div class="param-value">${item.brand}</div>
                        </div></#if>
                        <#if item.pfc??>
                            <div class="param-row">
                                <label>Белки, жиры, углеводы</label>
                                <div class="param-value">${item.pfc}</div>
                            </div>
                        </#if>
                        <div class="param-row">
                            <label>Энергетическая ценность</label>
                            <div class="param-value">${item.calories*4.184} кДж/${item.calories} кКал</div>
                        </div>
                        <div class="param-row">
                            <label>Состав</label>
                            <div class="param-value">${item.composition}</div>
                        </div>
                        <#if item.size??>
                        <div class="param-row">
                            <label>Размер</label>
                            <div class="param-value">${item.size}</div>
                        </div></#if>
                        <#if item.kind??>
                        <div class="param-row">
                            <label>Тип шоколада</label>
                            <div class="param-value">${item.kind}</div>
                        </div></#if>
                        <div class="param-row">
                            <label>В наличии</label>
                            <div class="param-value">${item.count} штук</div>
                        </div>
                    </div>
                    <div class="item-price">${item.price} руб.</div>
                        <input type="submit" name="set" value="В корзину"/>
                </div></form>
                <a href="../" class="back-link">Возврат в каталог</a>
                <div class="clear"></div>
            </article>
            <div class="clear"></div>
        </div>
    </div>
</div>
</#macro>