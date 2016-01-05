<#-- @ftlvariable name="categories" type="java.util.List<ru.dz.labs.api.domain.Categories>" -->

<#include "../template/mainTemplate.ftl">
<@mainTemplate />
<#macro recursion p1>
    <#list p1 as p>
        <#if p.categories ?has_content>
        <p><a class="category_group" data-toggle="collapse" href="#collapseExample${p.id}"
              aria-expanded="false" aria-controls="collapseExample${p.id}">${p.name}</a></p>

        <div class="collapse" id="collapseExample${p.id}">
            <div class="well">
                <p><@recursion p1=p.categories/></p>
            </div>
        </div><#else><p><a href="/"
                >${p.name}</a></p></#if>
    </#list>

</#macro>
<#macro m_body>
<head><title>Каталог продукции</title></head>
<div id="center">
    <div class="min-margin">
        <div class="center-wrapper">
            <div class="breadcrumbs"><a href="/" title="Главная страница">Главная страница</a> / Каталог</div>
            <h1><span>Каталог продукции</span></h1>

            <p style="text-align: justify;">Сладкий, ароматный, с легкой горечью, опьяняюще нежный и завораживающий. Что
                может быть качественнее и идеальнее по вкусу, чем <a style="text-decoration: none;" href="/"
                                                                     title="бельгийский шоколад">бельгийский шоколад</a>?
                Безусловно, поклонников этого сладкого десерта сложно измерить тысячами людей по всему миру, и всех их
                объединяет одно – любовь к шоколаду самого высокого качества.
                <br>
                Наша кондитерская компания Chocolate Collection с удовольствием предлагает вниманию истинных ценителей
                шоколадного удовольствия уникальный и неповторимо вкусный <a style="text-decoration: none;" href="/"
                                                                             title="шоколад бельгийского производства">шоколад
                    бельгийского производства</a>. Идеально подобранные ингредиенты, безупречное качество продукта
                премиум-класса, непревзойдённый талант кондитеров создают необычные вкусы шоколада. Шоколад с орехами и
                цукатами, шоколадное пралине и фондю, паста и конфеты, классическая горечь или нежная молочная
                бархатистость – калейдоскопическое многообразие форм и вкусов поражает воображение...Приятных Вам
                покупок!</p>
            <section class="sections-block margin">
                <div class="left-aside">
                    <div class="wrap_aside">
                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <#list categories as category>
                             <div class="panel panel-default">
                                <#if  category.categories?has_content>
                                        <div class="panel-heading" role="tab" id="heading${category.id}">
                                            <h4 class="panel-title">
                                                <a role="button" data-toggle="collapse" data-parent="#accordion"
                                                   href="#collapse${category.id}" aria-expanded="true"
                                                   aria-controls="collapse${category.id}">
                                                ${category.name}
                                                </a>
                                            </h4>
                                        </div>
                                        <div id="collapse${category.id}" class="panel-collapse collapse in"
                                             role="tabpanel"
                                             aria-labelledby="heading${category.id}">
                                            <div class="panel-body">
                                                    <!--nested panel -->
                                                                <@recursion p1=category.categories/>
                                            </div>
                                        </div><#else>
                                    <div class="panel-heading">
                                        <h4>
                                            <a role="button"
                                               href="/">
                                            ${category.name}
                                            </a>
                                        </h4>
                                    </div></#if>
                                </div>
                            </#list>
                        </div>


                    </div>
                </div>
                <div class="right_block">
                    <div class="row">
                        <div class="col-xs-4">
                            <article class="catalog-item">
                                <div class="table-cell">
                                    <img class="imageCatalog" src="../../../resources/i/img2.png">
                                </div>
                                <a href="/catalog/new-year/" class="item-title">Новый год</a>
                            </article>
                        </div>
                        <div class="col-xs-4">
                            <article class="catalog-item">
                                <div class="table-cell">
                                    <img class="imageCatalog" src="../../../resources/i/img2.png">
                                </div>
                                <a href="/catalog/new-year/" class="item-title">Новый год</a>
                            </article>
                        </div>
                        <div class="col-xs-4">
                            <article class="catalog-item">
                                <div class="table-cell">
                                    <img class="imageCatalog" src="../../../resources/i/img2.png">
                                </div>
                                <a href="/catalog/new-year/" class="item-title">Новый год</a>
                            </article>
                        </div>
                        <div class="col-xs-4">
                            <article class="catalog-item">
                                <div class="table-cell">
                                    <img class="imageCatalog" src="../../../resources/i/img2.png">
                                </div>
                                <a href="/catalog/new-year/" class="item-title">Новый год</a>
                            </article>
                        </div>
                    </div>
                    <div>
            </section>
            <div class="clear"></div>
        </div>
    </div>
</div>
</div>
</div>
</#macro>