<#-- @ftlvariable name="items" type="java.util.List<ru.dz.labs.api.domain.Goods>" -->
<#-- @ftlvariable name="catalog" type="ru.dz.labs.api.domain.Categories" -->
<#-- @ftlvariable name="pagesCount" type="java.lang.Integer" -->
<#-- @ftlvariable name="currentPage" type="java.lang.Integer" -->
<#-- @ftlvariable name="max" type="java.math.BigDecimal" -->
<#-- @ftlvariable name="min" type="java.math.BigDecimal" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate />
<#macro m_body>
<head><title>${catalog.name}</title></head>
<div id="center">
    <div class="min-margin">
    <div class="center-wrapper">
        <div class="breadcrumbs"><a href="/" title="Главная страница">Главная страница</a> / <a href="/catalog/"
                                                                                                title="Каталог">Каталог</a>
            /${catalog.name}
        </div>
        <h1><span>${catalog.name}</span></h1>
        <#if catalog.description??>
            <div align="justify"> ${catalog.description}
            </div></#if>
        <br><br><br>
        <#if items??>
            <form action="/catalog/${catalog.name}/1" method="get">
                <div class="interval-block">
                    <div class="head"><b>Подобрать по цене</b></div>
                    <div class="interval">
                        <div class="control">
                            <span>От </span>
                            <input type="text" name="from" style="margin-right:20px;" placeholder=${min}>
                            <span> До </span>
                            <input type="text" name="to" placeholder=${max}>
                            <span> Руб</span>
                        </div>

                    </div>
                    <input type="submit" name="" value="Подобрать"/>
                </div>
            </form>
        </div>
            <#if !items?has_content>
                <div align="center"><h4>Товары с такой характеристикой отсутствуют</h4></div> </#if>
            <section class="offers-block">
                <div class="row">

                    <#list items as item>
                        <div class="col-xs-4">
                            <a href="/catalog/good/${item.id}">
                                <div class="product">
                                    <div class="head">${item.name}</div>
                                    <div class="image">
                                        <img src=${item.image}>
                                    </div>
                                    <div class="cost">
                                    ${item.price} р.
                                    </div>
                                    <ul class="parametrs">
                                        <li class="parametr">
                                            <span class="name"><i class="fa fa-bookmark"></i> Состав:</span>
                                            <span class="value">${item.composition}</span>
                                        </li>
                                        <li class="parametr">
                                            <span class="name"><i class="fa fa-bookmark"></i> Вес нетто:</span>
                                            <span class="value">${item.weight} г</span>
                                        </li>
                                        <#if item.size??>
                                            <li class="parametr">
                                                <span class="name"><i class="fa fa-bookmark"></i> Размер (высота*глубина*ширина):</span>
                                                <span class="value">${item.size}</span>
                                            </li></#if>
                                        <#if item.packaging??>
                                            <li class="parametr">
                                                <span class="name"><i class="fa fa-bookmark"></i> Упаковка:</span>
                                                <span class="value">${item.packaging}</span>
                                            </li></#if>
                                    </ul>
                                </div>
                            </a>
                        </div></#list>
                </div>
            </section><#else>
            <div align="center"><h4>В каталоге пока нет товаров</h4></div>
        </#if>
    </div>
    <div class="clear"></div>
</div>

</div>
    <#if pagesCount!=0>
    <div style="background: #ebe8bd;text-align: center;">
        <ul class="pagination">
            <#if currentPage==1>
                <li class="disabled"><a>«</a></li> <#else>
                <li><a href="/catalog/${catalog.name}/${currentPage-1}">«</a></li></#if>
            <#if pagesCount==1 || pagesCount==2|| pagesCount==3>
                <#list 1..pagesCount as i>
                    <#if currentPage==i>
                        <li><a class="active" href="/catalog/${catalog.name}/${i}">${i}</a></li><#else>
                        <li><a href="/catalog/${catalog.name}/${i}">${i}</a></li></#if></#list><#else>
                <#list 1..3 as i><#if currentPage==i>
                    <li><a class="active" href="/catalog/${catalog.name}/${i}">${i}</a></li><#else>
                    <li><a href="/catalog/${catalog.name}/${i}">${i}</a></li></#if>  </#list>
                <li class="disabled"><a>...</a></li>
                <li><a href="/catalog/${catalog.name}/${pagesCount}">${pagesCount}</a></li>
            </#if>
            <#if currentPage==pagesCount>
                <li class="disabled"><a>»</a></li><#else >
                <li><a href="/catalog/${catalog.name}/${currentPage+1}">»</a></li></#if>
        </ul>
    </div></#if>

<div>

    <div class="clearfix"></div>
</div>


<link rel="stylesheet" type="text/css" href="http://chocoart.by/css/interval.css">
<script type="text/javascript">
    $(document).ready(function () {
        $(".product").hover(
                function () {
                    var par = $(this).find(".parametrs");
                    if (par.css("display") == "none") {
                        par.show("fast");
                    }
                },
                function () {
                    var par = $(this).find(".parametrs");
                    par.hide("fast");
                }
        );
    });
</script>
<div id="btn-to-top"><i class="fa fa-chevron-up"></i></div>
<script type="text/javascript">
    $(document).ready(function () {
        $(window).scroll(function () {
            if ($(this).scrollTop() > 65) {
                $('#btn-to-top').fadeIn();
            } else {
                $('#btn-to-top').fadeOut();
            }
        });
        $('#btn-to-top').click(function () {
            $('body,html').animate({
                scrollTop: 0
            }, 400);
            return false;
        });
    });
</script>
</#macro>