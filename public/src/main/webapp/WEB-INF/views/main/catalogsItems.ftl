<#-- @ftlvariable name="items" type="java.util.List<ru.dz.labs.api.domain.Goods>" -->
<#-- @ftlvariable name="catalog" type="ru.dz.labs.api.domain.Categories" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate />
<#macro m_body>
<head><title></title></head>
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

            <div class="interval-block">
                <div class="head">Подобрать по цене</div>
                <div class="interval">
                    <div class="control">
                        <span>От </span>
                        <input type="text" id="minCost" name="minCost" style="margin-right:20px;">
                        <span> До </span>
                        <input type="text" id="maxCost" name="maxCost">
                        <span> Руб</span>
                    </div>
                    <div id="slider" class="ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all"
                         aria-disabled="false">
                        <div class="ui-slider-range ui-widget-header ui-corner-all"
                             style="left: 0%; width: 100%;"></div>
                        <a class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 0%;"></a><a
                            class="ui-slider-handle ui-state-default ui-corner-all" href="#" style="left: 100%;"></a>
                    </div>
                </div>
                <div class="show-interval"><span>Подобрать</span></div>
            </div>


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
        </div>
            </section><#else><h4>В каталоге пока нет товаров</h4>
        </#if>
        <div class="clear"></div>
    </div>

</div>
    <#if items??>
<div style="background: #ebe8bd;text-align: center;">
    <ul class="pagination">
        <li class="disabled"><a>«</a></li>
        <li class="active"><a>1</a></li>
        <li><a href="/katalog/shokoladnye-figury/2">2</a></li>
        <li><a href="/katalog/shokoladnye-figury/3">3</a></li>
        <li><a href="/katalog/shokoladnye-figury/4">4</a></li>
        <li class="disabled"><a>...</a></li>
        <li><a href="/katalog/shokoladnye-figury/8">8</a></li>
        <li><a href="/katalog/shokoladnye-figury/2">»</a></li>
    </ul>
</div><#else><h4>В каталоге пока нет товаров</h4>
</#if>

<div>

    <div class="clearfix"></div>
</div>


<link rel="stylesheet" type="text/css" href="http://chocoart.by/css/interval.css">
<script type="text/javascript" src="http://chocoart.by/js/jquery.ui-slider.js"></script>
<script type="text/javascript">
    var minCost = 100;
    var smallCost = 100;
    var maxCost = 30000;
    var bigCost = 30000;
</script>
<script type="text/javascript" src="http://chocoart.by/js/set-interval.js"></script>
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