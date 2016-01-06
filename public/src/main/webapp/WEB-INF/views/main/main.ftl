<#-- @ftlvariable name="newGoods" type="java.util.List<ru.dz.labs.api.domain.Goods>" -->
<#include "../template/mainTemplate.ftl">
<@mainTemplate />
<#macro m_body>
<head>  <title>Бутик элитного бельгийского шоколада и шоколадных подарков Chocolate Collection</title>
</head>

<div id="center">
    <div class="min-margin">
        <div class="center-wrapper">
            <div class="main-banner border_box">
                <div class="banner-wrapper box_skitter box_skitter_large">
                    <ul>
                        <li><a href="#randomSmart"><img src="../../../resources/i/957684fe471f9c91198b5462f8de97ca.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/19929f8880c38e511f961bd07ad9ddac.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/3eb0dda447c57789550a81821e650f9a.png" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/4424d896e2001e4c374d75eaa88e2362.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/d135f9a911d0b5e91ce3741aaac664a8.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/9cfe218921f63ae2be4b8e6861faea36.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/bcb1cf083c0afb95bb60efa3b5dacbc8.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/0ebcbbc65319b55c6e065690d23fca90.jpg" class="randomSmart"></a>
                        <li><a href="#randomSmart"><img src="../../../resources/i/62d4bfd39505c2719eca7b49b34cd334.jpg" class="randomSmart"></a>
                    </ul>
                </div>
            </div>
            <div class="styled-head-line"><span>Бутик шоколада премиум класса</span></div>



            <div align="justify">
                Бутик Chocolate Collection, магазин элитного шоколада в Туле, предлагает своим клиентам шоколад высочайшего качества ручной работы, который способен пробудить чувства в каждом, кто хотя бы единожды попробовал его. <br>
                Шоколад нашего магазина отличается необычайным многообразием вкусовых сочетаний - душистых фруктов, кофе, меда, карамели, различных видов орехов и элитных алкогольных напитков. Чрезвычайно мягкий с пралине, с миндалем, вкусом вишни, апельсина, клубники, корицей, перцем… – все это элитный шоколад из Бельгии. Шоколад из уникального редкого сорта какао-бобов с использованием исключительно натуральных компонентов. Наслаждение, с которым мало что сравнится, роскошь, которая не бывает чрезмерной. Это не просто шоколад, это не просто конфеты, это не просто вкус… <br>
                Только в фирменном бутике Chocolate Collection вам будет предложен широкий ассортимент настоящих шедевров шоколада ручной работы, который удовлетворит самого изысканного ценителя качественного шоколада. Продукция выполнена по классическим рецептам лучших шоколатье. Наши шоколатье открывали все новые и новые грани вкуса, совершенствовали рецепты и шлифовали свое мастерство, чтобы получить действительно эксклюзивный шоколад, достойный монархов. Сладость натуральных компонентов, горечь послевкусия и неповторимый аромат... Вам захочется радовать себя нашим шоколадом каждый день!<br>
                Купить шоколад в интернет-магазине Chocolate Collection выгодно и удобно – у нас только проверенные поставщики и только лучшее качество. Наш интернет-магазин шоколада премиум класса всегда к вашим услугам.
            </div>
            <#if newGoods??>
            <h1><span>Новинки</span></h1>
            <section class="offers-block margin">

                <div class="row">
                    <#list newGoods as good>
                    <div style="width: 25%!important;" class="col-xs-4">
                        <article class="catalog-item">
                            <div class="table-cell">
                                <img class="imageCatalog" src=${good.image}>
                            </div>
                            <a href="/catalog/good/${good.id}" class="item-title">${good.name}</a>
                            <form action="/cart" method="post">
                            <a class="add2basket" title="Купить"/></a></form>
                            <div class="item-price">${good.price} руб.		</div>
                        </article>

                    </div>
                    </#list>
                </div>
            </section></#if>
        </div>
    </div>
</div>
</#macro>