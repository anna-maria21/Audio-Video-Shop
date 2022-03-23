<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>

    <#if noMoneyMessage??><p style="color: red;">Недостатньо коштів!</p></#if>
    <#if noBonusMessage??><p style="color: red;">Немає бонусів!</p></#if>

    <h2 class="text-center mt-5 mb-3">Фільми</h2>
    <div class="row mb-3">
        <#list films as film>
        <div class="card col-3 mb-3" style="width: 18rem;">
          <img src="https://svgsilh.com/svg_v2/2027080.svg" class="card-img-top mt-2" >
          <div class="card-body text-center">
                <i><b>Назва: </b></i>${film.name}<br/>
                <i><b>Режисер: </b></i>${film.director}<br/>
                <i><b>Опис: </b></i>${film.description}<br/>
                <i><b>Рік випуску: </b></i>${film.year?c}<br/>
                <i><b>Категорія: </b></i>${film.filmCategory.name}<br/>
                <i><b>Рейтинг: </b></i>${film.rating}<br/>
                <i><b>Тип товару: </b></i>${film.type.name}<br/>
                <i><b>Ціна: </b></i>${film.price}<br/>
                <form action="/buy/film" method="get">
                    <input type="checkbox" name="bonus" class="mt-2"> Використати бонуси</input>
                    <input type="hidden" value="${film.id}" name="id">
                    <input type="hidden" value="${user?if_exists.id?if_exists}" name="idUser">
                    <button type="submit" class="btn btn-success mt-3">Дивитись</button>
                </form>
          </div>
        </div>
        <div class="col-md-1"></div>
        </#list>
    </div>
    <h2 class="text-center mt-5 mb-3">Музика</h2>
    <div class="row mb-3">
        <#list musics as music>
        <div class="card col-3 mb-3" style="width: 18rem;">
          <img src="https://svgsilh.com/svg/763193.svg" class="card-img-top mt-2" >
          <div class="card-body text-center">
                <i><b>Назва: </b></i>${music.name}<br/>
                <i><b>Виконавець: </b></i>${music.performer}<br/>
                <i><b>Рік випуску: </b></i>${music.year?c}<br/>
                <i><b>Категорія: </b></i>${music.musicCategory.name}<br/>
                <i><b>Рейтинг: </b></i>${music.rating}<br/>
                <i><b>Тип товару: </b></i>${music.type.name}<br/>
                <i><b>Ціна: </b></i>${music.price}<br/>
                <form action="/buy/music" method="get">
                    <input type="checkbox" name="bonus" class="mt-2"> Використати бонуси</input>
                    <input type="hidden" value="${music.id}" name="id">
                    <input type="hidden" value="${user?if_exists.id?if_exists}" name="idUser">
                    <button type="submit" class="btn btn-success mt-3">Слухати</button>
                </form>
          </div>
        </div>
        <div class="col-md-1"></div>
        </#list>
    </div>

</@c.page>